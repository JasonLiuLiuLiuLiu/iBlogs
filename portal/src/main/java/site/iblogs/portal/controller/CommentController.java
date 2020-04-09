package site.iblogs.portal.controller;

import site.iblogs.common.api.ApiResponse;
import site.iblogs.portal.model.params.CommentPageParam;
import site.iblogs.portal.model.params.CommentRequest;
import site.iblogs.portal.model.response.CommentResponse;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class CommentController {

    public ApiResponse<CommentResponse> Index(CommentPageParam param){
        throw  new NotImplementedException();
    }

    public ApiResponse AddComment(CommentRequest request){
        throw new NotImplementedException();
    }
}
