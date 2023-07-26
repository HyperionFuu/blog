package com.fuxin.service;

import com.fuxin.pojo.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Description: TypeService
 * Author: Fuu
 * Date: 2023/7/26
 */
public interface TypeService {

    Type saveType(Type type);

    Type getType(Long id);

    Type findByName(String name);

    Page<Type> listType(Pageable pageable);

    Type updateType(Long id, Type type);

    void deleteType(Long id);

}
