package site.iblogs.portal.component;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.stream.ObjectRecord;
import org.springframework.data.redis.connection.stream.Record;
import org.springframework.data.redis.connection.stream.RecordId;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import site.iblogs.portal.model.params.FtpSiteMapFileInfo;

@Component
public class SiteMapTaskProducer {
    private final Logger logger = LoggerFactory.getLogger(SiteMapTaskProducer.class);
    @Autowired
    private StringRedisTemplate redisTemplate;

    @NacosValue(value = "${redis.stream.chanel.ftp.siteMap}")
    private String siteMapChanel;

    @Scheduled(fixedDelay = 150000)
    public void Upload(){
        FtpSiteMapFileInfo fileInfo = new FtpSiteMapFileInfo("test");
        ObjectRecord<String, FtpSiteMapFileInfo> record = Record.of(fileInfo).withStreamKey(siteMapChanel);
        RecordId recordId = redisTemplate.opsForStream().add(record);
        assert recordId != null;
        logger.debug("Upload site map file to ftp,recordId:"+recordId.toString());
    }
}
