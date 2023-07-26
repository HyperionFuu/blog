package com.fuxin.dao;

import com.fuxin.pojo.Type;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Description: TypeRepository
 * Author: Fuu
 * Date: 2023/7/26
 */
public interface TypeRepository extends JpaRepository<Type,Long> {

    Type findByName(String name);

}
