package site.iblogs.portal.component;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class RssUpdateTask {
    @Scheduled(fixedDelay = 3000)
    public void Upload(){
        System.out.println("Upload xml file to ftp");
    }
}
