package site.iblogs.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import site.iblogs.model.Meta;
import site.iblogs.model.MetaExample;

public interface MetaMapper {
    long countByExample(MetaExample example);

    int deleteByExample(MetaExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Meta record);

    int insertSelective(Meta record);

    List<Meta> selectByExampleWithBLOBs(MetaExample example);

    List<Meta> selectByExample(MetaExample example);

    Meta selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Meta record, @Param("example") MetaExample example);

    int updateByExampleWithBLOBs(@Param("record") Meta record, @Param("example") MetaExample example);

    int updateByExample(@Param("record") Meta record, @Param("example") MetaExample example);

    int updateByPrimaryKeySelective(Meta record);

    int updateByPrimaryKeyWithBLOBs(Meta record);

    int updateByPrimaryKey(Meta record);
}