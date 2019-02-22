package com.jk.dao;

import java.util.List;
import java.util.Map;

import com.jk.model.Comment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentDao {
	public List<Comment> getCommentData(Map<String,Object>map);
	public int addComment(Comment comment);
	public Long getTotal(Map<String, Object>map);
	public Integer update(Comment comment);
	public Integer deleteComment(Integer id);
	public Integer deleteCommentByBlogId(Integer blogId);
}
