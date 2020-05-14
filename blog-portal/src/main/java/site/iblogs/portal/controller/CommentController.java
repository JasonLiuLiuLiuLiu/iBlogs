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
import site.iblogs.portal.model.params.CommentRequest;
import site.iblogs.portal.model.response.CommentResponse;
import site.iblogs.portal.service.CommentService;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

@Api(tags = "CommentController", value = "评论API")
@Controller
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @ApiOperation("通过文章Id获取评论")
    @RequestMapping(value = "getComments", method = RequestMethod.POST)
    @ResponseBody
    public ApiResponse<PageResponse<CommentResponse>> GetComments(int cid, int pageNum, int pageSize){
        return ApiResponse.success(commentService.getComment(cid,pageNum,pageSize));
    }

    public ApiResponse AddComment(CommentRequest request){
        throw new NotImplementedException();
    }
}
