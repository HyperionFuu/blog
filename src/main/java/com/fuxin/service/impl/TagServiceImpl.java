package com.fuxin.service.impl;

import com.fuxin.dao.TagRepository;
import com.fuxin.exception.NotFoundException;
import com.fuxin.pojo.Tag;
import com.fuxin.service.TagService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Description: TagServiceImpl
 * Author: Fuu
 * Date: 2023/7/26
 */
@Service
public class TagServiceImpl implements TagService {
    @Autowired
    private TagRepository tagRepository;

    @Transactional
    @Override
    public Tag saveTag(Tag Tag) {
        return tagRepository.save(Tag);
    }

    @Transactional
    @Override
    public Tag getTag(Long id) {
        return tagRepository.findOne(id);
    }

    @Override
    public Tag findByName(String name) {
        return tagRepository.findByName(name);
    }

    @Transactional
    @Override
    public Page<Tag> listTag(Pageable pageable) {
        return tagRepository.findAll(pageable);
    }

    @Transactional
    @Override
    public Tag updateTag(Long id, Tag Tag) {
        Tag t = tagRepository.findOne(id);
        if(null == t)
            throw new NotFoundException("不存在");
        BeanUtils.copyProperties(Tag,t);

        return tagRepository.save(t);
    }

    @Transactional
    @Override
    public void deleteTag(Long id) {
        tagRepository.delete(id);
    }
}
