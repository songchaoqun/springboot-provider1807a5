package com.jk.service.impl;

import javax.annotation.Resource;

import com.jk.service.BloggerService;
import org.springframework.stereotype.Service;

import com.jk.dao.BloggerDao;
import com.jk.model.Blogger;
@Service("bloggerService")
public class BloggerServiceImpl implements BloggerService {
	@Resource
	private BloggerDao bloggerDao;
	public Blogger getByUsername(String username) {
		return bloggerDao.getByUsername(username);
	}

	public Blogger getBloggerData() {
		return bloggerDao.getBloggerData();
	}

	public Integer updateBlogger(Blogger blogger) {
		return bloggerDao.updateBlogger(blogger);
	}

}
