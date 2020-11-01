package site.iblogs.admin.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import site.iblogs.admin.dto.request.*;
import site.iblogs.admin.service.ContentService;
import site.iblogs.common.api.ApiResponse;
import site.iblogs.common.dto.request.ContentSaveRequest;

/**
 * @author: liuzhenyulive@live.com
 * @date: 9/22/2020 22:34
 */
@Api(tags = "ContentController", value = "分类&&标签 api")
@Controller
@RequestMapping("/content")
public class ContentController {
    @Autowired
    private ContentService contentService;

    @ApiOperation("分页获取文章")
    @RequestMapping(value = "/page", method = RequestMethod.POST)
    @ResponseBody
    public ApiResponse page(@RequestBody ContentPageParam param) {
        return ApiResponse.success(contentService.page(param));
    }

    @ApiOperation("更新文章状态")
    @RequestMapping(value = "/status", method = RequestMethod.POST)
    @ResponseBody
    public ApiResponse status(@RequestBody ContentStatusUpdateParam param) {
        return ApiResponse.success(contentService.status(param));
    }

    @ApiOperation("删除文章")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public ApiResponse delete(@RequestBody ContentDeleteParam param) {
        return ApiResponse.success(contentService.delete(param));
    }

    @ApiOperation("文章详情")
    @RequestMapping(value = "/details", method = RequestMethod.POST)
    @ResponseBody
    public ApiResponse details(@RequestBody ContentDetailRequest param) throws Exception {
        return ApiResponse.success(contentService.details(param));
    }

    @ApiOperation("保存文章")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public ApiResponse details(@RequestBody ContentSaveRequest param) {
        return ApiResponse.success(contentService.save(param));
    }
}
