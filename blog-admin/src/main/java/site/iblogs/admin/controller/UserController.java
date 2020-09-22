package site.iblogs.admin.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import site.iblogs.admin.model.param.LoginParam;
import site.iblogs.common.api.RestResponse;

/**
 * @author: liuzhenyulive@live.com
 * @date: 9/22/2020 22:12
 */
@Api(tags = "UserController", value = "用户信息API")
@Controller
@RequestMapping("/user")
public class UserController {

    @ApiOperation("保存用户信息")
    @RequestMapping(value = "/profile", method = RequestMethod.POST)
    @ResponseBody
    public RestResponse saveProfile(String screenName, String email) {

        return RestResponse.ok();
    }

    @ApiOperation("更新密码")
    @RequestMapping(value = "/password", method = RequestMethod.POST)
    @ResponseBody
    public RestResponse upPwd(String old_password, String password) {

        return RestResponse.ok();
    }

    @ApiOperation("登录")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public RestResponse<?> doLogin(LoginParam loginParam) {
        return RestResponse.ok();
    }
}
