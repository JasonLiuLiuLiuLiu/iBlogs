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
import site.iblogs.common.model.BoolResultWithMessage;
import site.iblogs.common.utils.SFTPUtil;
import site.iblogs.portal.model.params.FtpFileInfo;
import site.iblogs.portal.model.params.FtpSiteMapFileInfo;
import site.iblogs.portal.service.OptionService;

@Component
public class SiteMapTaskConsumer implements StreamListener<String, ObjectRecord<String, FtpSiteMapFileInfo>> {

    private final Logger logger = LoggerFactory.getLogger(SiteMapTaskConsumer.class);
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private SiteMapGenerator sitemapGenerater;

    @NacosValue(value = "${redis.stream.group.ftp.siteMap}", autoRefreshed = true)
    private String siteMapGroup;
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

    @NacosValue(value = "${upYun.username}", autoRefreshed = true)
    private String upYunUsername;
    @NacosValue(value = "${upYun.password}", autoRefreshed = true)
    private String upYunPassword;
    @NacosValue(value = "${upYun.bucketname}", autoRefreshed = true)
    private String bucketname;

    @Override
    public void onMessage(ObjectRecord<String, FtpSiteMapFileInfo> message) {
        RecordId id = message.getId();
        FtpFileInfo messageValue = message.getValue();
        try {
            logger.debug("正在消费stream:{}中的信息:{}, 消息id:{}", message.getStream(), messageValue.toString(), id);
            String path = sitemapGenerater.run();
            logger.debug("生成了sitemap文件:{},消息id:{}", path, id);
            BoolResultWithMessage result = SFTPUtil.upload(host, port, username, password, filePath, "sitemap.xml", path);
            if (result.getSuccess()) {
                logger.debug("成功上传了sitemap文件:{},消息id:{}", path, id);
            } else {
                logger.warn("sitemap 上传失败,message:" + result.getMessage());
            }
            stringRedisTemplate.opsForStream().acknowledge(siteMapGroup, message);
            stringRedisTemplate.opsForStream().delete(message);
            logger.debug("完成消费stream:{}中的信息:{}, 消息id:{}", message.getStream(), messageValue.toString(), id);
        } catch (Exception ex) {
            logger.error("failed to process message, exception:{}", ex.getMessage());
        }
    }
}
