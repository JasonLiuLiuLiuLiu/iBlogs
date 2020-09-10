package site.iblogs.portal.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import site.iblogs.common.api.ApiResponse;
import site.iblogs.portal.service.OptionService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

@Api(tags = "OptionController", value = "配置项")
@Controller
@RequestMapping("/option")
public class OptionController {
    @Autowired
    private OptionService optionService;

    @ApiOperation("添加品牌关注")
    @RequestMapping(value = "/getOptions", method = RequestMethod.POST)
    @ResponseBody
    public ApiResponse<HashMap<String,String>> add(@RequestBody ArrayList<String> keys) {
        return ApiResponse.success(optionService.getOptions(keys));
    }
}
