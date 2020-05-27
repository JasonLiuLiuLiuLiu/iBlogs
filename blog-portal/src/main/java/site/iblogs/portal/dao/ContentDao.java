package site.iblogs.portal.dao;

import org.apache.ibatis.annotations.Param;
import site.iblogs.model.Contents;
import site.iblogs.portal.model.response.ArchivesResponse;

import java.util.List;

public interface ContentDao {
    /*
    通过标签,分类等获取文章
     */
    List<Contents> getContentByMetaData(@Param("type") int type, @Param("name") String name);

    /*获取指定文章的前一篇文章的Id*/
    Integer getPre(@Param("id") int id);

    /*获取指定文章的后一篇文章的Id*/
    Integer getNext(@Param("id") int id);

    /*获取所有的创作时间*/
    List<ArchivesResponse> getArchives();

    /*通过归档时间获取文章*/
    List<Contents> getContentByArchive(@Param("date") String date);
}
