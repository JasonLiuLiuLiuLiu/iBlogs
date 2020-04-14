package site.iblogs.portal.controller;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import site.iblogs.common.api.ApiResponse;
import site.iblogs.portal.model.response.MetaDataResponse;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

@Api(tags = "MetaDataController", value = "分类,标签")
@Controller
@RequestMapping("/metadata")
public class MetaDataController {
    public ApiResponse<MetaDataResponse> AllCategories() {
        throw new NotImplementedException();
    }

    public ApiResponse<MetaDataResponse> AllTags() {
        throw new NotImplementedException();
    }
}
