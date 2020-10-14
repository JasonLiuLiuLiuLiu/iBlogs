package site.iblogs.admin.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import site.iblogs.admin.dto.request.ContentPageParam;
import site.iblogs.admin.service.ContentService;
import site.iblogs.common.api.ApiResponse;

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
}
