package site.iblogs.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import site.iblogs.model.Relationships;
import site.iblogs.model.RelationshipsExample;

public interface RelationshipsMapper {
    long countByExample(RelationshipsExample example);

    int deleteByExample(RelationshipsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Relationships record);

    int insertSelective(Relationships record);

    List<Relationships> selectByExample(RelationshipsExample example);

    Relationships selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Relationships record, @Param("example") RelationshipsExample example);

    int updateByExample(@Param("record") Relationships record, @Param("example") RelationshipsExample example);

    int updateByPrimaryKeySelective(Relationships record);

    int updateByPrimaryKey(Relationships record);
}