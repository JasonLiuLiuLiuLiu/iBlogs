package site.iblogs.admin.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import site.iblogs.common.api.PageParam;
import site.iblogs.common.api.RestResponse;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author: liuzhenyulive@live.com
 * @date: 9/22/2020 22:12
 */
@Api(tags = "AttachmentController", value = "附件 api")
@Controller
@RequestMapping("/attachment")
public class AttachmentController {

    @ApiOperation("上传附件")
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public RestResponse<?> upload(String request) {
        return RestResponse.ok(request);
    }

    @ApiOperation("显示附件")
    @RequestMapping(value = "/attaches", method = RequestMethod.POST)
    @ResponseBody
    public RestResponse attachList(PageParam pageParam) {
        return RestResponse.ok();
    }

    @ApiOperation("删除附件")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public RestResponse<?> deleteAttach(Integer id)  {
        return RestResponse.ok();
    }

}
