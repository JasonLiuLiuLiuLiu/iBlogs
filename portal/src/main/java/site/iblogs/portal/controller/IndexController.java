package site.iblogs.portal.controller;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import site.iblogs.common.api.ApiResponse;
import site.iblogs.portal.model.response.IndexContentResponse;
import site.iblogs.portal.model.response.MetaDataResponse;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

@Api(tags = "IndexController", value = "博客首页")
@Controller
@RequestMapping("/index")
public class IndexController {

    public ApiResponse<IndexContentResponse> Index(int index) {
        throw new NotImplementedException();
    }

    public ApiResponse<IndexContentResponse> Hot(int index) {
        throw new NotImplementedException();
    }

    public ApiResponse<IndexContentResponse> Random(int index) {
        throw new NotImplementedException();
    }

    public ApiResponse<IndexContentResponse> Tag(String tag, int index) {
        throw new NotImplementedException();
    }

    public ApiResponse<IndexContentResponse> Category(String category, int index) {
        throw new NotImplementedException();
    }

    public ApiResponse<IndexContentResponse> Archive(int index) {
        throw new NotImplementedException();
    }

    public ApiResponse<MetaDataResponse> AllCategories() {
        throw new NotImplementedException();
    }

    public ApiResponse<MetaDataResponse> AllTags() {
        throw new NotImplementedException();
    }

    public ApiResponse<IndexContentResponse> Search(String keyword, int index) {
        throw new NotImplementedException();
    }
}
