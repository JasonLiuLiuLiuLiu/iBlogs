package site.iblogs.portal.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import site.iblogs.common.api.ApiResponse;
import site.iblogs.common.api.PageResponse;
import site.iblogs.portal.model.params.MetaDataType;
import site.iblogs.portal.model.response.MetaDataResponse;
import site.iblogs.portal.service.MetadataService;

@Api(tags = "MetaDataController", value = "分类,标签")
@Controller
@RequestMapping("/metadata")
public class MetaDataController {

    @Autowired
    private MetadataService metadataService;

    @ApiOperation("获取分类")
    @RequestMapping(value = "categories", method = RequestMethod.GET)
    @ResponseBody
    public ApiResponse<PageResponse<MetaDataResponse>> Categories(int pageNum, int pageSize) {
        return ApiResponse.success(metadataService.getMetadata(MetaDataType.Category,pageNum,pageSize));
    }

    @ApiOperation("获取标签")
    @RequestMapping(value = "tags", method = RequestMethod.GET)
    @ResponseBody
    public ApiResponse<PageResponse<MetaDataResponse>> Tags(int pageNum, int pageSize) {
        return ApiResponse.success(metadataService.getMetadata(MetaDataType.Tag,pageNum,pageSize));
    }
}
