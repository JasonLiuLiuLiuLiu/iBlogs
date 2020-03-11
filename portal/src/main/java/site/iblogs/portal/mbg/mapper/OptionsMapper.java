package site.iblogs.portal.mbg.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import site.iblogs.portal.mbg.model.Options;
import site.iblogs.portal.mbg.model.OptionsExample;

public interface OptionsMapper {
    int countByExample(OptionsExample example);

    int deleteByExample(OptionsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Options record);

    int insertSelective(Options record);

    List<Options> selectByExampleWithBLOBs(OptionsExample example);

    List<Options> selectByExample(OptionsExample example);

    Options selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Options record, @Param("example") OptionsExample example);

    int updateByExampleWithBLOBs(@Param("record") Options record, @Param("example") OptionsExample example);

    int updateByExample(@Param("record") Options record, @Param("example") OptionsExample example);

    int updateByPrimaryKeySelective(Options record);

    int updateByPrimaryKeyWithBLOBs(Options record);

    int updateByPrimaryKey(Options record);
}