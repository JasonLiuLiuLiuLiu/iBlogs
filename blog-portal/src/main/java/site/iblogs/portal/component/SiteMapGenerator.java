package site.iblogs.portal.component;

import com.redfin.sitemapgenerator.W3CDateFormat;
import com.redfin.sitemapgenerator.WebSitemapGenerator;
import com.redfin.sitemapgenerator.WebSitemapUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import site.iblogs.common.model.ConfigKey;
import site.iblogs.model.Contents;
import site.iblogs.portal.service.ContentService;
import site.iblogs.portal.service.OptionService;

import java.io.File;
import java.net.MalformedURLException;
import java.util.List;
import java.util.TimeZone;

@Component
public class SiteMapGenerator {
    @Autowired
    private ContentService contentService;

    @Autowired
    private OptionService optionService;

    public String run() throws MalformedURLException {
        File file = new File(System.getProperty("java.io.tmpdir"));
        List<Contents> allContents = contentService.listAllContent();
        String siteUrl = optionService.getOption(ConfigKey.SiteUrl).getValue();
        W3CDateFormat dateFormat = new W3CDateFormat(W3CDateFormat.Pattern.DAY);
        dateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        WebSitemapGenerator wsg = WebSitemapGenerator.builder(siteUrl, file)
                .dateFormat(dateFormat).build();
        allContents.forEach(content -> {
            try {
                WebSitemapUrl url=new WebSitemapUrl.Options(String.format("%s/article/%s",siteUrl,content.getId())).lastMod(content.getModified()).build();
                wsg.addUrl(url);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        });
        wsg.write();
        return new File(file.getPath(),"sitemap.xml").getPath();
    }
}
