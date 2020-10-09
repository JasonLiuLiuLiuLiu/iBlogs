package site.iblogs.admin.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import site.iblogs.admin.dto.request.MetaParam;
import site.iblogs.common.api.RestResponse;

/**
 * @author: liuzhenyulive@live.com
 * @date: 9/22/2020 22:35
 */
@Api(tags = "MetadataController", value = "分类&&标签 api")
@Controller
@RequestMapping("/meta")
public class MetadataController {
    @ApiOperation("保存元数据")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public RestResponse<?> saveMeta(@RequestBody MetaParam param) {
        return RestResponse.ok();
    }

    @ApiOperation("删除元数据")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public RestResponse<?> deleteMeta(Integer mid) {
        return RestResponse.ok();
    }

    @ApiOperation("获取元数据")
    @RequestMapping(value = "/page", method = RequestMethod.POST)
    @ResponseBody
    public RestResponse metaList() {
        return RestResponse.ok();
    }
}
