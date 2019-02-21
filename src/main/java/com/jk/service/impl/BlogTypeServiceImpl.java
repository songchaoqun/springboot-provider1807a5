package com.jk.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.jk.service.BlogTypeService;
import org.springframework.stereotype.Service;

import com.jk.dao.BlogTypeDao;
import com.jk.model.Blog;
import com.jk.model.BlogType;
@Service("blogTypeService")
public class BlogTypeServiceImpl implements BlogTypeService {
	@Resource
	private BlogTypeDao blogTypeDao;
	public List<BlogType> getBlogTypeData() {
	
		return blogTypeDao.getBlogTypeData();
	}

	public BlogType getById(Integer id) {
		// TODO Auto-generated method stub
		return blogTypeDao.getById(id);
	}

	public List<BlogType> listByPage(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return blogTypeDao.listByPage(map);
	}

	public Long getTotal() {
		// TODO Auto-generated method stub
		return blogTypeDao.getTotal();
	}

	public Integer addBlogType(BlogType blogType) {
		// TODO Auto-generated method stub
		return blogTypeDao.addBlogType(blogType);
	}

	public Integer updateBlogType(BlogType blogType) {
		// TODO Auto-generated method stub
		return blogTypeDao.updateBlogType(blogType);
	}

	public Integer deleteBlogType(Integer id) {
		// TODO Auto-generated method stub
		return blogTypeDao.deleteBlogType(id);
	}

}
