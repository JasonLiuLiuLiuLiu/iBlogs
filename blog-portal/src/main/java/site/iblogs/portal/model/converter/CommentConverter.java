package site.iblogs.portal.model.converter;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import site.iblogs.model.Comments;
import site.iblogs.portal.model.request.CommentRequest;
import site.iblogs.portal.model.response.CommentResponse;

@Mapper(componentModel = "spring")
public interface CommentConverter {
    @Mappings({
            @Mapping(target = "status", expression = "java(site.iblogs.portal.model.params.CommentStatus.values()[comment.getStatus()])")
    })
    CommentResponse domain2dto(Comments comment);
    @Mappings({
            @Mapping(target = "cid", expression = "java(request.getContentId())"),
            @Mapping(target = "parent", expression = "java(request.getParentId())"),
    })
    Comments request2domain(CommentRequest request);
}
