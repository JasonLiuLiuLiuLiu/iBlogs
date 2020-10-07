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
import site.iblogs.admin.dto.request.RegisterParam;
import site.iblogs.admin.service.UserService;
import site.iblogs.common.api.ApiResponse;
import site.iblogs.common.api.RestResponse;
import site.iblogs.model.Users;

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

    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Autowired
    private UserService userService;

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

    @ApiOperation(value = "用户注册")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public ApiResponse<RegisterParam> register(@RequestBody RegisterParam registerParam) {
        RegisterParam register = userService.register(registerParam);
        if(register==null){
            return ApiResponse.failed();
        }
        return ApiResponse.success(register);
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
        tokenMap.put("tokenHead", tokenHead);
        return ApiResponse.success(tokenMap);
    }
}
