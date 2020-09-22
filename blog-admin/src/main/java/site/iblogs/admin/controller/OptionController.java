package site.iblogs.admin.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import site.iblogs.common.api.RestResponse;

import java.util.List;
import java.util.Map;

/**
 * @author: liuzhenyulive@live.com
 * @date: 9/22/2020 22:36
 */
@Api(tags = "OptionController", value = "配置项 api")
@Controller
@RequestMapping("/option")
public class OptionController {

    @ApiOperation("获取配置项")
    @RequestMapping(value = "/options", method = RequestMethod.POST)
    @ResponseBody
    public RestResponse options() {
        return RestResponse.ok();
    }

    @ApiOperation("保存配置项")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public RestResponse<?> saveOptions() {
        return RestResponse.ok();
    }
}
