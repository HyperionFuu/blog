package com.lrm.service;

import com.lrm.po.Comment;

import java.util.List;

/**
 * Created by Fuxin on 2023/07/22.
 */
public interface CommentService {

    List<Comment> listCommentByBlogId(Long blogId);

    Comment saveComment(Comment comment);
}
