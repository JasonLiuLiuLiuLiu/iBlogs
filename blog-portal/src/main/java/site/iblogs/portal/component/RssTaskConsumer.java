package site.iblogs.portal.component;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.stream.ObjectRecord;
import org.springframework.data.redis.connection.stream.RecordId;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.stream.StreamListener;
import org.springframework.stereotype.Component;
import site.iblogs.common.dto.BoolResultWithMessage;
import site.iblogs.common.utils.SFTPUtil;
import site.iblogs.portal.model.params.FtpFileInfo;
import site.iblogs.portal.model.params.FtpRssFileInfo;

@Component
public class RssTaskConsumer implements StreamListener<String, ObjectRecord<String, FtpRssFileInfo>> {

    private final Logger logger = LoggerFactory.getLogger(RssTaskConsumer.class);
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @NacosValue(value = "${redis.stream.group.ftp.rss}", autoRefreshed = true)
    private String rssGroup;
    @Autowired
    private RssGenerator rssGenerator;
    @NacosValue(value = "${ftp.host}", autoRefreshed = true)
    private String host;
    @NacosValue(value = "${ftp.port}", autoRefreshed = true)
    private Integer port;
    @NacosValue(value = "${ftp.username}", autoRefreshed = true)
    private String username;
    @NacosValue(value = "${ftp.password}", autoRefreshed = true)
    private String password;
    @NacosValue(value = "${ftp.filePath}", autoRefreshed = true)
    private String filePath;

    @Override
    public void onMessage(ObjectRecord<String, FtpRssFileInfo> message) {
        RecordId id = message.getId();
        FtpFileInfo messageValue = message.getValue();
        try {
            logger.debug("开始消费stream:{}中的信息:{}, 消息id:{}", message.getStream(), messageValue.toString(), id);
            String path = rssGenerator.run();
            logger.debug("成功生成了rss文件:{}", path);
            BoolResultWithMessage result = SFTPUtil.upload(host, port, username, password, filePath, "rss.xml", path);
            if (result.getSuccess()) {
                logger.debug("成功上传了rss文件:{},消息id:{}", path, id);
            } else {
                logger.warn("rss 上传失败,message:" + result.getMessage());
            }
            stringRedisTemplate.opsForStream().acknowledge(rssGroup, message);
            stringRedisTemplate.opsForStream().delete(message);
        } catch (Exception ex) {
            logger.error("failed to process message, exception:{}", ex.getMessage());
        }

    }
}
