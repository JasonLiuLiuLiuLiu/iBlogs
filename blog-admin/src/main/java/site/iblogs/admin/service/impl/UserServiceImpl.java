package site.iblogs.admin.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import site.iblogs.admin.component.jwt.JwtTokenUtil;
import site.iblogs.admin.dto.AdminUserDetails;
import site.iblogs.admin.dto.request.PasswordParam;
import site.iblogs.admin.dto.request.ProfileParam;
import site.iblogs.admin.dto.request.RegisterParam;
import site.iblogs.admin.dto.response.UserInfoResponse;
import site.iblogs.admin.service.UserService;
import site.iblogs.common.service.RedisService;
import site.iblogs.common.utils.GravatarTools;
import site.iblogs.mapper.UserMapper;
import site.iblogs.model.User;
import site.iblogs.model.UserExample;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public AdminUserDetails getUserByUserName(String username) {
        UserExample example = new UserExample();
        example.createCriteria().andUsernameEqualTo(username);
        User admin = userMapper.selectByExample(example).stream().findFirst().orElse(null);
        if (admin != null) {
            List<String> permissionList = new ArrayList<>();
            permissionList.add("admin");
            return new AdminUserDetails(admin, permissionList);
        }
        throw new UsernameNotFoundException("用户名或密码错误");
    }

    @Override
    public RegisterParam register(RegisterParam umsAdminParam) {
        //目前系统仅允许一个用户
        UserExample example = new UserExample();
        example.createCriteria().andDeletedEqualTo(false);
        List<User> umsAdminList = userMapper.selectByExample(example);
        if (umsAdminList.size() > 0) {
            return null;
        }
        User user = new User();
        user.setCreated(new Date());
        user.setUsername(umsAdminParam.getUsername());
        user.setPassword(umsAdminParam.getPassword());
        user.setEmail(umsAdminParam.getEmail());
        //将密码进行加密操作
        String encodePassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodePassword);
        userMapper.insert(user);
        return umsAdminParam;
    }

    @Override
    public String login(String username, String password) {
        String token = null;
        try {
            UserDetails userDetails = getUserByUserName(username);
            if (!passwordEncoder.matches(password, userDetails.getPassword())) {
                throw new BadCredentialsException("密码不正确");
            }
            User user = ((AdminUserDetails) userDetails).getUser();
            user.setLogged(new Date());
            userMapper.updateByPrimaryKeySelective(user);
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtTokenUtil.generateToken(userDetails);
        } catch (AuthenticationException e) {
            LOGGER.warn("登录异常:{}", e.getMessage());
        }
        return token;
    }

    @Override
    public ProfileParam updateProfile(ProfileParam param) {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        UserDetails userDetails = getUserByUserName(userName);
        User user = ((AdminUserDetails) userDetails).getUser();
        user.setEmail(param.getEmail());
        userMapper.updateByPrimaryKeySelective(user);
        return param;
    }

    @Override
    public PasswordParam updatePassword(PasswordParam param) {
        try {
            String username = SecurityContextHolder.getContext().getAuthentication().getName();
            UserDetails userDetails = getUserByUserName(username);
            if (!passwordEncoder.matches(param.getOldPassword(), userDetails.getPassword())) {
                throw new BadCredentialsException("密码不正确");
            }
            User user = ((AdminUserDetails) userDetails).getUser();
            user.setPassword(passwordEncoder.encode(param.getNewPassword()));
            userMapper.updateByPrimaryKeySelective(user);
            jwtTokenUtil.removeToken(user.getUsername());
            return param;
        } catch (AuthenticationException e) {
            LOGGER.warn("登录异常:{}", e.getMessage());
            throw e;
        }
    }

    @Override
    public UserInfoResponse info() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = getUserByUserName(username).getUser();
        return new UserInfoResponse(user.getId(), user.getUsername(), GravatarTools.computeGravatarUrl(user.getEmail(), 80, null), user.getEmail());
    }

    @Override
    public void logout() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        if (!username.equals("anonymousUser")) {
            jwtTokenUtil.removeToken(username);
        }
    }
}
