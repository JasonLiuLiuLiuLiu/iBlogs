package site.iblogs.portal.mbg.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import site.iblogs.portal.mbg.model.Attachments;
import site.iblogs.portal.mbg.model.AttachmentsExample;

public interface AttachmentsMapper {
    int countByExample(AttachmentsExample example);

    int deleteByExample(AttachmentsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Attachments record);

    int insertSelective(Attachments record);

    List<Attachments> selectByExampleWithBLOBs(AttachmentsExample example);

    List<Attachments> selectByExample(AttachmentsExample example);

    Attachments selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Attachments record, @Param("example") AttachmentsExample example);

    int updateByExampleWithBLOBs(@Param("record") Attachments record, @Param("example") AttachmentsExample example);

    int updateByExample(@Param("record") Attachments record, @Param("example") AttachmentsExample example);

    int updateByPrimaryKeySelective(Attachments record);

    int updateByPrimaryKeyWithBLOBs(Attachments record);

    int updateByPrimaryKey(Attachments record);
}