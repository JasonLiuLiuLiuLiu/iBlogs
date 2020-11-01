package site.iblogs.admin.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import site.iblogs.admin.dto.request.OptionUpdateParam;
import site.iblogs.admin.service.OptionService;
import site.iblogs.common.api.ApiResponse;
import site.iblogs.common.api.PageRequest;
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

    @Autowired
    private OptionService optionService;

    @ApiOperation("获取配置项")
    @RequestMapping(value = "/options", method = RequestMethod.POST)
    @ResponseBody
    public ApiResponse options() {
        return ApiResponse.success(optionService.getVisibleOptions());
    }

    @ApiOperation("保存配置项")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public ApiResponse saveOptions(@RequestBody OptionUpdateParam param) {
        if(optionService.updateOption(param)){
            return ApiResponse.success(param);
        }else {
            return ApiResponse.failed();
        }
    }

    @ApiOperation("分页获取")
    @RequestMapping(value = "/page", method = RequestMethod.POST)
    @ResponseBody
    public ApiResponse saveOptions(@RequestBody PageRequest param) {
        return ApiResponse.success(optionService.page(param));
    }
}
