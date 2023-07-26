package com.fuxin.dao;

import com.fuxin.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Description: UserRespository
 * Author: Fuu
 * Date: 2023/7/25
 */
public interface UserRespository extends JpaRepository<User,Long> {

    User findByUsernameAndPassword(String username, String password);

}
