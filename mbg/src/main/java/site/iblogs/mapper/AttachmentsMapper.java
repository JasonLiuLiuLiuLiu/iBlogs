package site.iblogs.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import site.iblogs.model.Attachments;
import site.iblogs.model.AttachmentsExample;

public interface AttachmentsMapper {
    long countByExample(AttachmentsExample example);

    int deleteByExample(AttachmentsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Attachments record);

    int insertSelective(Attachments record);

    List<Attachments> selectByExample(AttachmentsExample example);

    Attachments selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Attachments record, @Param("example") AttachmentsExample example);

    int updateByExample(@Param("record") Attachments record, @Param("example") AttachmentsExample example);

    int updateByPrimaryKeySelective(Attachments record);

    int updateByPrimaryKey(Attachments record);
}