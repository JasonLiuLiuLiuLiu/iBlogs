package site.iblogs.portal.model.converter;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import site.iblogs.model.Comments;
import site.iblogs.portal.model.response.CommentResponse;

@Mapper(componentModel = "spring")
public interface CommentResponseConverter {
    @Mappings({
            @Mapping(target = "status", expression = "java(site.iblogs.portal.model.params.CommentStatus.values()[comment.getStatus()])")
    })
    CommentResponse domain2dto(Comments comment);
}
