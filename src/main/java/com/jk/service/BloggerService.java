package com.jk.service;

import com.jk.model.Blogger;

public interface BloggerService {
	public Blogger getByUsername(String username);
	public Blogger getBloggerData();
	public Integer updateBlogger(Blogger blogger);

}
