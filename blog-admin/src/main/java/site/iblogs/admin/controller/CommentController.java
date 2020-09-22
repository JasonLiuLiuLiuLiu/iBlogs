package site.iblogs.admin.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import site.iblogs.common.api.PageParam;
import site.iblogs.common.api.RestResponse;

/**
 * @author: liuzhenyulive@live.com
 * @date: 9/22/2020 22:35
 */
@Api(tags = "CommentController", value = "评论 api")
@Controller
@RequestMapping("/comment")
public class CommentController {
    @ApiOperation("获取评论")
    @RequestMapping(value = "/comments", method = RequestMethod.POST)
    @ResponseBody
    public RestResponse commentList(PageParam commentParam) {
        return RestResponse.ok();
    }

    @ApiOperation("删除评论")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public RestResponse<?> deleteComment(Integer coid) {
        return RestResponse.ok();
    }

    @ApiOperation("修改评论状态")
    @RequestMapping(value = "/status", method = RequestMethod.POST)
    @ResponseBody
    public RestResponse<?> updateStatus() {
        return RestResponse.ok();
    }

    @ApiOperation("回复评论")
    @RequestMapping(value = "/reply", method = RequestMethod.POST)
    @ResponseBody
    public RestResponse<?> replyComment() {
        return RestResponse.ok();
    }
}
