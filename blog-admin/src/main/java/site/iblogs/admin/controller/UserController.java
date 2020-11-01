package site.iblogs.admin.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import site.iblogs.admin.dto.request.LoginParam;
import site.iblogs.admin.dto.request.PasswordParam;
import site.iblogs.admin.dto.request.ProfileParam;
import site.iblogs.admin.dto.request.RegisterParam;
import site.iblogs.admin.service.UserService;
import site.iblogs.common.api.ApiResponse;
import site.iblogs.common.api.RestResponse;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: liuzhenyulive@live.com
 * @date: 9/22/2020 22:12
 */
@Api(tags = "UserController", value = "用户信息API")
@Controller
@RequestMapping("/user")
public class UserController {
    private static String TOKEN_HEAD = "Bearer ";

    @Autowired
    private UserService userService;

    @ApiOperation("保存用户信息")
    @RequestMapping(value = "/profile", method = RequestMethod.POST)
    @ResponseBody
    public ApiResponse updateProfile(@RequestBody ProfileParam param) {

        return ApiResponse.success(userService.updateProfile(param));
    }

    @ApiOperation("更新密码")
    @RequestMapping(value = "/password", method = RequestMethod.POST)
    @ResponseBody
    public ApiResponse updatePwd(@RequestBody PasswordParam param) {
        return ApiResponse.success(userService.updatePassword(param));
    }

    @ApiOperation(value = "用户注册")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public ApiResponse<RegisterParam> register(@RequestBody RegisterParam registerParam) {
        RegisterParam register = userService.register(registerParam);
        if (register == null) {
            return ApiResponse.failed("目前系统仅允许一个用户,请联系管理员");
        }
        return ApiResponse.success(register);
    }

    @ApiOperation(value = "获取用户信息")
    @RequestMapping(value = "/info", method = RequestMethod.POST)
    @ResponseBody
    public ApiResponse info() {
        return ApiResponse.success(userService.info());
    }

    @ApiOperation(value = "登录以后返回token")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ApiResponse login(@RequestBody LoginParam loginParam) {
        String token = userService.login(loginParam.getUsername(), loginParam.getPassword());
        if (token == null) {
            return ApiResponse.validateFailed("用户名或密码错误");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", TOKEN_HEAD);
        return ApiResponse.success(tokenMap);
    }

    @ApiOperation(value = "退出登录")
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    @ResponseBody
    public ApiResponse logOut() {
        userService.logout();
        return ApiResponse.success("登出成功");
    }
}
