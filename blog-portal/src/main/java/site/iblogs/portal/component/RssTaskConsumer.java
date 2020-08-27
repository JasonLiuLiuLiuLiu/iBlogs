package site.iblogs.portal.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.connection.stream.ObjectRecord;
import org.springframework.data.redis.connection.stream.RecordId;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.stream.StreamListener;
import org.springframework.stereotype.Component;
import site.iblogs.portal.model.params.FtpFileInfo;
import site.iblogs.portal.model.params.FtpRssFileInfo;

@Component
public class RssTaskConsumer implements StreamListener<String, ObjectRecord<String, FtpRssFileInfo>> {

    private final Logger logger = LoggerFactory.getLogger(RssTaskConsumer.class);
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Value("${redis.stream.group.ftp.rss}")
    private String rssGroup;

    @Override
    public void onMessage(ObjectRecord<String, FtpRssFileInfo> message) {
        RecordId id = message.getId();
        FtpFileInfo messageValue = message.getValue();
        try {
            logger.info("消费stream:{}中的信息:{}, 消息id:{}", message.getStream(), messageValue.toString(), id);
            stringRedisTemplate.opsForStream().acknowledge(rssGroup, message);
            stringRedisTemplate.opsForStream().delete(message);
        } catch (Exception ex) {
            logger.error("failed to process message, exception:{}", ex.getMessage());
        }

    }
}
