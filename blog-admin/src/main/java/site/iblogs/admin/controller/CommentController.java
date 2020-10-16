package site.iblogs.admin.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import site.iblogs.admin.dto.request.CommentStatusUpdateParam;
import site.iblogs.admin.service.CommentService;
import site.iblogs.common.api.ApiResponse;
import site.iblogs.common.dto.request.CommentPageParam;

/**
 * @author: liuzhenyulive@live.com
 * @date: 9/22/2020 22:35
 */
@Api(tags = "CommentController", value = "评论 api")
@Controller
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @ApiOperation("获取评论")
    @RequestMapping(value = "/comments", method = RequestMethod.POST)
    @ResponseBody
    public ApiResponse commentList(@RequestBody CommentPageParam param) {
        return ApiResponse.success(commentService.commentList(param));
    }

    @ApiOperation("删除评论")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public ApiResponse deleteComment(Long id) {
        if(commentService.deleteComment(id)){
            return ApiResponse.success(id);
        }else {
            return ApiResponse.failed();
        }
    }

    @ApiOperation("修改评论状态")
    @RequestMapping(value = "/status", method = RequestMethod.POST)
    @ResponseBody
    public ApiResponse updateStatus(CommentStatusUpdateParam param) {
        return ApiResponse.success(commentService.updateStatus(param));
    }
}
