package site.iblogs.portal.component;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.stream.ObjectRecord;
import org.springframework.data.redis.connection.stream.Record;
import org.springframework.data.redis.connection.stream.RecordId;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import site.iblogs.portal.model.params.FtpRssFileInfo;

@Component
public class RssTaskProducer {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @NacosValue(value = "${redis.stream.chanel.ftp.rss}", autoRefreshed = true)
    private String rssChanel;

    @Scheduled(fixedDelay = 1000000)
    public void Upload(){
        FtpRssFileInfo fileInfo = new FtpRssFileInfo("test");
        ObjectRecord<String, FtpRssFileInfo> record = Record.of(fileInfo).withStreamKey(rssChanel);
        RecordId recordId = redisTemplate.opsForStream().add(record);
        assert recordId != null;
        System.out.println("Upload rss file to ftp,recordId:"+recordId.toString());
    }
}
