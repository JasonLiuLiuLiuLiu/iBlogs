package site.iblogs.portal.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.connection.stream.ObjectRecord;
import org.springframework.data.redis.connection.stream.Record;
import org.springframework.data.redis.connection.stream.RecordId;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import site.iblogs.portal.model.params.FtpFileInfo;
import site.iblogs.portal.model.params.FtpSiteMapFileInfo;

@Component
public class SiteMapTaskProducer {
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Value("${redis.stream.chanel.ftp.siteMap}")
    private String siteMapChanel;

    @Scheduled(fixedDelay = 15000)
    public void Upload(){
        FtpSiteMapFileInfo fileInfo = new FtpSiteMapFileInfo("test");
        ObjectRecord<String, FtpSiteMapFileInfo> record = Record.of(fileInfo).withStreamKey(siteMapChanel);
        RecordId recordId = redisTemplate.opsForStream().add(record);
        assert recordId != null;
        System.out.println("Upload site map file to ftp,recordId:"+recordId.toString());
    }
}
