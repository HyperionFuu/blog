package com.lrm.service;

import com.lrm.po.User;

/**
 * Created by Fuxin on 2023/07/15.
 */
public interface UserService {

    User checkUser(String username, String password);
}
