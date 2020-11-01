package site.iblogs.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import site.iblogs.model.Blogsyncrelationship;
import site.iblogs.model.BlogsyncrelationshipExample;

public interface BlogsyncrelationshipMapper {
    long countByExample(BlogsyncrelationshipExample example);

    int deleteByExample(BlogsyncrelationshipExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Blogsyncrelationship record);

    int insertSelective(Blogsyncrelationship record);

    List<Blogsyncrelationship> selectByExample(BlogsyncrelationshipExample example);

    Blogsyncrelationship selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Blogsyncrelationship record, @Param("example") BlogsyncrelationshipExample example);

    int updateByExample(@Param("record") Blogsyncrelationship record, @Param("example") BlogsyncrelationshipExample example);

    int updateByPrimaryKeySelective(Blogsyncrelationship record);

    int updateByPrimaryKey(Blogsyncrelationship record);
}