package site.iblogs.portal.mbg.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import site.iblogs.portal.mbg.model.Blogsyncrelationships;
import site.iblogs.portal.mbg.model.BlogsyncrelationshipsExample;

public interface BlogsyncrelationshipsMapper {
    int countByExample(BlogsyncrelationshipsExample example);

    int deleteByExample(BlogsyncrelationshipsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Blogsyncrelationships record);

    int insertSelective(Blogsyncrelationships record);

    List<Blogsyncrelationships> selectByExampleWithBLOBs(BlogsyncrelationshipsExample example);

    List<Blogsyncrelationships> selectByExample(BlogsyncrelationshipsExample example);

    Blogsyncrelationships selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Blogsyncrelationships record, @Param("example") BlogsyncrelationshipsExample example);

    int updateByExampleWithBLOBs(@Param("record") Blogsyncrelationships record, @Param("example") BlogsyncrelationshipsExample example);

    int updateByExample(@Param("record") Blogsyncrelationships record, @Param("example") BlogsyncrelationshipsExample example);

    int updateByPrimaryKeySelective(Blogsyncrelationships record);

    int updateByPrimaryKeyWithBLOBs(Blogsyncrelationships record);

    int updateByPrimaryKey(Blogsyncrelationships record);
}