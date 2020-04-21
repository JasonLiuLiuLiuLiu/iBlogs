package site.iblogs.portal.model.converter;

import org.mapstruct.Mapper;
import site.iblogs.model.Contents;
import site.iblogs.portal.model.response.ContentResponse;

@Mapper(componentModel = "spring")
public interface ContentResponseConverter {
    ContentResponse domain2dto(Contents contents);
}
