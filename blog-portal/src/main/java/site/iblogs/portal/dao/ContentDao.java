package site.iblogs.portal.dao;

import org.apache.ibatis.annotations.Param;
import site.iblogs.model.Contents;

import java.util.List;

public interface ContentDao {
    /*
    通过标签,分类等获取文章
     */
    List<Contents> getContentByMetaData(@Param("type") int type, @Param("name") String name);
}
