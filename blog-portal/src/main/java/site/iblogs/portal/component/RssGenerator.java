package site.iblogs.portal.component;

import com.rometools.rome.feed.synd.*;
import com.rometools.rome.io.SyndFeedOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import site.iblogs.common.model.ConfigKey;
import site.iblogs.model.Content;
import site.iblogs.portal.service.ContentService;
import site.iblogs.portal.service.OptionService;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.*;

@Component
public class RssGenerator {
    private static final String copyRight="Copyright © 2018-2020 Liu,Zhenyu";
    private static final String FEED_TYPE = "atom_0.3";

    @Autowired
    private OptionService optionService;
    @Autowired
    private ContentService contentService;

    public String run() {
        String filePath=new File(System.getProperty("java.io.tmpdir"),"rss.xml").getPath();
        try {
            SyndFeed feed = new SyndFeedImpl();
            feed.setFeedType(FEED_TYPE);
            String siteUrl = optionService.getOption(ConfigKey.SiteUrl).getValue();

            feed.setTitle(optionService.getOption(ConfigKey.SiteTitle).getValue());
            feed.setLink(siteUrl);
            feed.setCopyright(copyRight);
            feed.setPublishedDate(new Date());
            feed.setDescription(optionService.getOption(ConfigKey.Description).getValue());

            ArrayList<SyndEntry> entries = new ArrayList<>();
            SyndEntry entry;
            SyndContent description;
            List<Content> allContents=contentService.getTopContent(20,true);

            for (Content content : allContents) {
                entry = new SyndEntryImpl();
                entry.setTitle(content.getTitle());
                entry.setLink(String.format("%s/article/%s", siteUrl, content.getId()));
                entry.setPublishedDate(content.getCreated());
                description = new SyndContentImpl();
                description.setType("text/html");
                description.setValue(content.getContent());
                entry.setDescription(description);
                entry.setPublishedDate(content.getCreated());
                entry.setUpdatedDate(content.getModified());
                entries.add(entry);
            }

            feed.setEntries(entries);

            Writer writer = new FileWriter(filePath);
            SyndFeedOutput output = new SyndFeedOutput();
            output.output(feed, writer);
            writer.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("ERROR: " + ex.getMessage());
        }
        return filePath;
    }
}
