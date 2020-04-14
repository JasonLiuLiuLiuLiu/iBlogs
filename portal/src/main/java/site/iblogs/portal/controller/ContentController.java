package site.iblogs.portal.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import site.iblogs.common.api.ApiResponse;
import site.iblogs.common.api.PageResponse;
import site.iblogs.model.Contents;
import site.iblogs.portal.model.response.ContentResponse;
import site.iblogs.portal.service.ContentService;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

/**
 * 内容管理Controller
 *
 * @author Liu Zhenyu on 3/12/2020
 */
@Api(tags = "ContentController", value = "内容管理")
@Controller
@RequestMapping("/content")
public class ContentController {

    @Autowired
    private ContentService contentService;

    private static final Logger LOGGER = LoggerFactory.getLogger(ContentController.class);

    @ApiOperation("获取所有内容")
    @RequestMapping(value = "all", method = RequestMethod.GET)
    @ResponseBody
    public ApiResponse<List<Contents>> listContent() {
        return ApiResponse.success(contentService.listAllContent());
    }

    @ApiOperation("分页获取所有内容")
    @RequestMapping(value = "page", method = RequestMethod.GET)
    @ResponseBody
    public ApiResponse<PageResponse<ContentResponse>> pagedContent(Integer pageNum, Integer pageSize) {
        return ApiResponse.success(PageResponse.restPage(contentService.listContent(pageNum, pageSize)));
    }

    public ApiResponse<ContentResponse> Index(String url){
        throw new NotImplementedException();
    }

    public ApiResponse<ContentResponse> Index(int index) {
        throw new NotImplementedException();
    }

    public ApiResponse<ContentResponse> Tag(String tag, int index) {
        throw new NotImplementedException();
    }

    public ApiResponse<ContentResponse> Category(String category, int index) {
        throw new NotImplementedException();
    }

    public ApiResponse<ContentResponse> Archive(int index) {
        throw new NotImplementedException();
    }

    public ApiResponse<ContentResponse> Search(String keyword, int index) {
        throw new NotImplementedException();
    }
}
