package com.fuxin.service;

import com.fuxin.pojo.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Description: BlogService
 * Author: Fuu
 * Date: 2023/7/26
 */
public interface BlogService {

    Blog getBlog(Long id);

    Page<Blog> listBlog(Pageable pageable, Blog blog);

    Blog saveBlog(Blog blog);

    Blog updateBlog(Long id, Blog blog);

    void deleteBlog(Long id);

}
