package site.iblogs.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import site.iblogs.model.Metas;
import site.iblogs.model.MetasExample;

public interface MetasMapper {
    long countByExample(MetasExample example);

    int deleteByExample(MetasExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Metas record);

    int insertSelective(Metas record);

    List<Metas> selectByExampleWithBLOBs(MetasExample example);

    List<Metas> selectByExample(MetasExample example);

    Metas selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Metas record, @Param("example") MetasExample example);

    int updateByExampleWithBLOBs(@Param("record") Metas record, @Param("example") MetasExample example);

    int updateByExample(@Param("record") Metas record, @Param("example") MetasExample example);

    int updateByPrimaryKeySelective(Metas record);

    int updateByPrimaryKeyWithBLOBs(Metas record);

    int updateByPrimaryKey(Metas record);
}