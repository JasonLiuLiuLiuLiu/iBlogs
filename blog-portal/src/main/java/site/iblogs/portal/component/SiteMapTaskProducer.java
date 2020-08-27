package site.iblogs.portal.component;

import org.springframework.beans.factory.annotation.Autowired;
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

    @Scheduled(fixedDelay = 3000)
    public void Upload(){
        FtpSiteMapFileInfo fileInfo = new FtpSiteMapFileInfo("test");
        ObjectRecord<String, FtpSiteMapFileInfo> record = Record.of(fileInfo).withStreamKey(StreamConsumerRunner.SITE_MAP_CHANNEL);
        RecordId recordId = redisTemplate.opsForStream().add(record);
        assert recordId != null;
        System.out.println("Upload site map file to ftp,recordId:"+recordId.toString());
    }
}
