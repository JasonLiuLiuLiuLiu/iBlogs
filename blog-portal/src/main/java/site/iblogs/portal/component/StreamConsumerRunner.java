package site.iblogs.portal.component;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.Lifecycle;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.stream.*;
import org.springframework.data.redis.core.StreamOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.stream.StreamListener;
import org.springframework.data.redis.stream.StreamMessageListenerContainer;
import org.springframework.data.redis.stream.StreamMessageListenerContainer.StreamMessageListenerContainerOptions;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import site.iblogs.portal.model.params.FtpFileInfo;
import site.iblogs.portal.model.params.FtpRssFileInfo;
import site.iblogs.portal.model.params.FtpSiteMapFileInfo;

import java.time.Duration;
import java.util.LinkedList;
import java.util.List;

@Component
public class StreamConsumerRunner implements ApplicationRunner, DisposableBean {

    @NacosValue(value = "${redis.stream.chanel.ftp.rss}", autoRefreshed = true)
    private String rssChanel;
    @NacosValue(value = "${redis.stream.group.ftp.rss}", autoRefreshed = true)
    private String rssGroup;
    @NacosValue(value = "${redis.stream.chanel.ftp.siteMap}", autoRefreshed = true)
    private String siteMapChanel;
    @NacosValue(value = "${redis.stream.group.ftp.siteMap}", autoRefreshed = true)
    private String siteMapGroup;

    @Autowired
    private ThreadPoolTaskExecutor executor;
    @Autowired
    private RedisConnectionFactory redisConnectionFactory;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RssTaskConsumer rssTaskConsumer;
    @Autowired
    private SiteMapTaskConsumer siteMapTaskConsumer;

    private List<StreamMessageListenerContainer> containers = new LinkedList<>();

    @Override
    public void run(ApplicationArguments args) {
        CreateContainerAndStart(rssTaskConsumer, FtpRssFileInfo.class, rssChanel, rssGroup);
        CreateContainerAndStart(siteMapTaskConsumer, FtpSiteMapFileInfo.class, siteMapChanel, siteMapGroup);
    }

    private <T extends FtpFileInfo> void CreateContainerAndStart(StreamListener<String, ObjectRecord<String, T>> listener, Class<T> type, String channel, String group) {
        StreamMessageListenerContainerOptions<String, ObjectRecord<String, T>> options =
                StreamMessageListenerContainerOptions.builder()
                        .batchSize(10)
                        .executor(executor)
                        .pollTimeout(Duration.ZERO)
                        .targetType(type)
                        .build();

        StreamMessageListenerContainer<String, ObjectRecord<String, T>> container =
                StreamMessageListenerContainer.create(redisConnectionFactory, options);

        prepareChannelAndGroup(stringRedisTemplate.opsForStream(), channel, group);

        container.receive(Consumer.from(group, channel+"CONSUMER"),
                StreamOffset.create(channel, ReadOffset.lastConsumed()),
                listener);

        containers.add(container);
        container.start();
    }

    private void prepareChannelAndGroup(StreamOperations<String, ?, ?> ops, String channel, String group) {
        String status = "OK";
        try {
            StreamInfo.XInfoGroups groups = ops.groups(channel);
            if (groups.stream().noneMatch(xInfoGroup -> group.equals(xInfoGroup.groupName()))) {
                status = ops.createGroup(channel, group);
            }
        } catch (Exception exception) {
            RecordId initialRecord = ops.add(ObjectRecord.create(channel, "Initial Record"));
            Assert.notNull(initialRecord, "Cannot initialize stream with key '" + channel + "'");
            status = ops.createGroup(channel, ReadOffset.from(initialRecord), group);
        } finally {
            Assert.isTrue("OK".equals(status), "Cannot create group with name '" + group + "'");
        }
    }

    @Override
    public void destroy() {
        containers.forEach(Lifecycle::stop);
    }
}
