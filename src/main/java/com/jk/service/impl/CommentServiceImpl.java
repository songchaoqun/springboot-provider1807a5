package com.jk.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.jk.dao.CommentDao;
import com.jk.model.Comment;
import com.jk.service.CommentService;
import org.springframework.stereotype.Service;

@Service("commentService")
public class CommentServiceImpl implements CommentService {
	@Resource
	private CommentDao commentDao;
	public List<Comment> getCommentData(Map<String, Object> map) {
		return commentDao.getCommentData(map);
	}

	public int addComment(Comment comment) {
		return commentDao.addComment(comment);
	}

	public Long getTotal(Map<String, Object> map) {
		return commentDao.getTotal(map);
	}

	public Integer update(Comment comment) {
		return commentDao.update(comment);
	}

	public Integer deleteComment(Integer id) {
		return commentDao.deleteComment(id);
	}

	public Integer deleteCommentByBlogId(Integer blogId) {
		return commentDao.deleteComment(blogId);
	}

}
