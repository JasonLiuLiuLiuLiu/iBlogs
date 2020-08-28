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
import site.iblogs.common.utils.FtpUtil;
import site.iblogs.portal.model.params.FtpFileInfo;
import site.iblogs.portal.model.params.FtpSiteMapFileInfo;

@Component
public class SiteMapTaskConsumer implements StreamListener<String, ObjectRecord<String, FtpSiteMapFileInfo>> {

    private final Logger logger = LoggerFactory.getLogger(SiteMapTaskConsumer.class);
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private SiteMapGenerator sitemapGenerater;

    @Value("${redis.stream.group.ftp.siteMap}")
    private String siteMapGroup;
    @Value("${ftp.host}")
    private String host;
    @Value("${ftp.port}")
    private Integer port;
    @Value("${ftp.username}")
    private String username;
    @Value("${ftp.password}")
    private String password;

    @Override
    public void onMessage(ObjectRecord<String, FtpSiteMapFileInfo> message) {
        RecordId id = message.getId();
        FtpFileInfo messageValue = message.getValue();

        try {
            logger.debug("正在消费stream:{}中的信息:{}, 消息id:{}", message.getStream(), messageValue.toString(), id);
            String path=sitemapGenerater.run();
            logger.info("生成了sitemap文件{},消息id:{}",path,id);
            FtpUtil.uploadFile(host,port,username,password,"","","sitemap.xml",path);
            stringRedisTemplate.opsForStream().acknowledge(siteMapGroup, message);
            stringRedisTemplate.opsForStream().delete(message);
            logger.debug("完成消费stream:{}中的信息:{}, 消息id:{}", message.getStream(), messageValue.toString(), id);
        } catch (Exception ex) {
            logger.error("failed to process message, exception:{}", ex.getMessage());
        }
    }
}