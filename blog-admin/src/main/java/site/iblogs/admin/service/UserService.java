package site.iblogs.admin.service;

import site.iblogs.model.Users;

public interface UserService {
    Users getUserByUserName(String username);
}
