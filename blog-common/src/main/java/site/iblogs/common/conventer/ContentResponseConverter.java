package site.iblogs.common.conventer;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import site.iblogs.common.dto.request.ContentSaveRequest;
import site.iblogs.common.dto.response.ContentEditResponse;
import site.iblogs.model.Content;
import site.iblogs.common.dto.response.ContentResponse;

@Mapper(componentModel = "spring")
public interface ContentResponseConverter {
    @Mappings({
            @Mapping(target = "type", expression = "java(site.iblogs.common.dto.enums.ContentType.values()[contents.getType()])"),
            @Mapping(target = "status", expression = "java(site.iblogs.common.dto.enums.ContentStatus.values()[contents.getStatus()])"),
            @Mapping(target = "allowComment", expression = "java(contents.getAllowcomment())"),
            @Mapping(target = "allowFeed", expression = "java(contents.getAllowfeed())"),
            @Mapping(target = "allowPing", expression = "java(contents.getAllowping())")
    })
    ContentResponse domain2dto(Content contents);

    @Mappings({
            @Mapping(target = "type", expression = "java(site.iblogs.common.dto.enums.ContentType.values()[contents.getType()])"),
            @Mapping(target = "status", expression = "java(site.iblogs.common.dto.enums.ContentStatus.values()[contents.getStatus()])"),
            @Mapping(target = "allowComment", expression = "java(contents.getAllowcomment())"),
            @Mapping(target = "allowFeed", expression = "java(contents.getAllowfeed())"),
            @Mapping(target = "allowPing", expression = "java(contents.getAllowping())"),
            @Mapping(target = "tags", ignore = true),
            @Mapping(target = "fmtType", expression = "java(contents.getFmttype())")
    })
    ContentEditResponse domain2EditResponse(Content contents);

    @Mappings({
            @Mapping(target = "type", expression = "java(request.getType().ordinal())"),
            @Mapping(target = "status", expression = "java(request.getStatus().ordinal())"),
            @Mapping(target = "allowcomment", expression = "java(request.getAllowComment())"),
            @Mapping(target = "allowfeed", expression = "java(request.getAllowFeed())"),
            @Mapping(target = "allowping", expression = "java(request.getAllowPing())"),
            @Mapping(target = "tags", expression = "java(String.join(\",\", request.getTags()))"),
            @Mapping(target = "fmttype", expression = "java(request.getFmtType())")
    })
    Content saveRequest2Domain(ContentSaveRequest request);
}
