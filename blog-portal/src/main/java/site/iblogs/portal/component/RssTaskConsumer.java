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
import site.iblogs.common.model.ConfigKey;
import site.iblogs.common.utils.FtpUtil;
import site.iblogs.common.utils.UpYun;
import site.iblogs.portal.model.params.FtpFileInfo;
import site.iblogs.portal.model.params.FtpRssFileInfo;
import site.iblogs.portal.service.OptionService;

import java.util.ArrayList;
import java.util.List;

@Component
public class RssTaskConsumer implements StreamListener<String, ObjectRecord<String, FtpRssFileInfo>> {

    private final Logger logger = LoggerFactory.getLogger(RssTaskConsumer.class);
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @NacosValue(value = "${redis.stream.group.ftp.rss}", autoRefreshed = true)
    private String rssGroup;
    @Autowired
    private RssGenerator rssGenerator;
    @Autowired
    private OptionService optionService;
    @NacosValue(value = "${ftp.host}", autoRefreshed = true)
    private String host;
    @NacosValue(value = "${ftp.port}", autoRefreshed = true)
    private Integer port;
    @NacosValue(value = "${ftp.username}", autoRefreshed = true)
    private String username;
    @NacosValue(value = "${ftp.password}", autoRefreshed = true)
    private String password;

    @NacosValue(value = "${upYun.username}", autoRefreshed = true)
    private String upYunUsername;
    @NacosValue(value = "${upYun.password}", autoRefreshed = true)
    private String upYunPassword;
    @NacosValue(value = "${upYun.bucketname}", autoRefreshed = true)
    private String bucketname;

    @Override
    public void onMessage(ObjectRecord<String, FtpRssFileInfo> message) {
        RecordId id = message.getId();
        FtpFileInfo messageValue = message.getValue();
        try {
            logger.info("开始消费stream:{}中的信息:{}, 消息id:{}", message.getStream(), messageValue.toString(), id);
            String path = rssGenerator.run();
            logger.info("成功生成了rss文件:{}", path);
            BoolResultWithMessage result = FtpUtil.uploadFile(host, port, username, password, "", "", "rss.xml", path);
            if (result.getSuccess()) {
                logger.info("成功上传了rss文件:{},消息id:{}", path, id);
            } else {
                logger.warn("rss 上传失败,message:" + result.getMessage());
            }
            upYunUrlRefresh();
            stringRedisTemplate.opsForStream().acknowledge(rssGroup, message);
            stringRedisTemplate.opsForStream().delete(message);
        } catch (Exception ex) {
            logger.error("failed to process message, exception:{}", ex.getMessage());
        }

    }

    private void upYunUrlRefresh() {
        String siteUrl = optionService.getOption(ConfigKey.SiteUrl).getValue();
        List<String> urls = new ArrayList<>();
        urls.add(siteUrl + "/rss");
        if (siteUrl.contains("www.")) {
            urls.add(siteUrl.replace("www.", "") + "/rss");
        } else if (siteUrl.contains("://")) {
            int index = siteUrl.indexOf("://");
            urls.add(siteUrl.substring(0, index + 3) + "www." + siteUrl.substring(index + 3) + "/rss");
        }
        StringBuilder urlsStr = new StringBuilder();
        for (String s : urls) {
            urlsStr.append(s).append("\n");
        }
        String result = UpYun.purgeUrl(bucketname, upYunUsername, upYunPassword, urlsStr.toString());
        logger.info("Refresh url with result:{}", result);
    }
}
