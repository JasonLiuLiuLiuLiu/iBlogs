package site.iblogs.portal.model.converter;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import site.iblogs.model.Comment;
import site.iblogs.portal.model.request.CommentRequest;
import site.iblogs.common.dto.response.CommentResponse;

@Mapper(componentModel = "spring")
public interface CommentConverter {
    @Mappings({
            @Mapping(target = "status", expression = "java(site.iblogs.common.dto.enums.CommentStatus.values()[comment.getStatus()])")
    })
    CommentResponse domain2dto(Comment comment);
    @Mappings({
            @Mapping(target = "cid", expression = "java(request.getContentId())"),
            @Mapping(target = "parent", expression = "java(request.getParentId())"),
    })
    Comment request2domain(CommentRequest request);
}
