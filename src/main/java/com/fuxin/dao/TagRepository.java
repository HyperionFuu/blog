package com.fuxin.dao;

import com.fuxin.pojo.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Description: TagRepository
 * Author: Fuu
 * Date: 2023/7/26
 */
public interface TagRepository extends JpaRepository<Tag,Long> {

    Tag findByName(String name);

}
