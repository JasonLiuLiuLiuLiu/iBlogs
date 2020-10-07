package site.iblogs.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.iblogs.admin.service.UserService;
import site.iblogs.mapper.UsersMapper;
import site.iblogs.model.Users;
import site.iblogs.model.UsersExample;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UsersMapper usersMapper;
    @Override
    public Users getUserByUserName(String username) {
        UsersExample example=new UsersExample();
        return usersMapper.selectByExample(example).stream().findFirst().orElse(null);
    }
}
