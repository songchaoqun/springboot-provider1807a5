package com.jk.dao;

import com.jk.model.Blogger;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BloggerDao {
	public Blogger getByUsername(String username);
	public Blogger getBloggerData();
	public Integer updateBlogger(Blogger blogger);
}
