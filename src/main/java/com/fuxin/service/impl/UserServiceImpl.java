package com.fuxin.service.impl;

import com.fuxin.dao.UserRespository;
import com.fuxin.pojo.User;
import com.fuxin.service.UserService;
import com.fuxin.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description: UserServiceImpl
 * Author: Fuu
 * Date: 2023/7/25
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRespository userRespository;

    @Override
    public User checkUser(String username, String password) {
        User user = userRespository.findByUsernameAndPassword(username, MD5Utils.code(password));
        return user;
    }
}
