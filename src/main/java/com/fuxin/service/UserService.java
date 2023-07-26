package com.fuxin.service;

import com.fuxin.pojo.User;

/**
 * Description: UserService
 * Author: Fuu
 * Date: 2023/7/25
 */
public interface UserService {
    public User checkUser(String username, String password);
}
