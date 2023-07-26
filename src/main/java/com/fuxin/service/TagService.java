package com.fuxin.service;

import com.fuxin.pojo.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Description: TagService
 * Author: Fuu
 * Date: 2023/7/26
 */
public interface TagService {

    Tag saveTag(Tag Tag);

    Tag getTag(Long id);

    Tag findByName(String name);

    Page<Tag> listTag(Pageable pageable);

    Tag updateTag(Long id, Tag Tag);

    void deleteTag(Long id);

}
