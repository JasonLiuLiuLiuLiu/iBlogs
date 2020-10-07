package site.iblogs.admin.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
import site.iblogs.admin.dto.request.RegisterParam;
import site.iblogs.admin.service.UserService;
import site.iblogs.mapper.UsersMapper;
import site.iblogs.model.Users;
import site.iblogs.model.UsersExample;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public AdminUserDetails getUserByUserName(String username) {
        UsersExample example=new UsersExample();
        //example.createCriteria().andUsernameEqualTo(user.getUsername());
        Users admin= usersMapper.selectByExample(example).stream().findFirst().orElse(null);
        if (admin != null) {
            List<String> permissionList = new ArrayList<>();
            permissionList.add("admin");
            return new AdminUserDetails(admin,permissionList);
        }
        throw new UsernameNotFoundException("用户名或密码错误");
    }

    @Override
    public RegisterParam register(RegisterParam umsAdminParam) {
        Users user=new Users();
        user.setCreated(new Date());
        user.setUsername(umsAdminParam.getUsername());
        user.setPassword(umsAdminParam.getPassword());
        user.setEmail(umsAdminParam.getEmail());
        //查询是否有相同用户名的用户
        UsersExample example = new UsersExample();
        //example.createCriteria().andUsernameEqualTo(user.getUsername());
        List<Users> umsAdminList = usersMapper.selectByExample(example);
        if (umsAdminList.size() > 0) {
            return null;
        }
        //将密码进行加密操作
        String encodePassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodePassword);
        usersMapper.insert(user);
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
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtTokenUtil.generateToken(userDetails);
        } catch (AuthenticationException e) {
            LOGGER.warn("登录异常:{}", e.getMessage());
        }
        return token;
    }
}
