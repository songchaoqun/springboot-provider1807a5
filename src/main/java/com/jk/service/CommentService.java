package com.jk.service;

import com.jk.model.Comment;

import java.util.List;
import java.util.Map;

public interface CommentService {
    List<Comment> getCommentData(Map<String, Object> map);
    Long getTotal(Map<String, Object> map);
    public Integer update(Comment comment);
    public Integer deleteComment(Integer id);
}
