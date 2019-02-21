package com.jk.dao;

import java.util.List;
import java.util.Map;

import com.jk.model.BlogType;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BlogTypeDao {
	public List<BlogType> getBlogTypeData();
	public BlogType getById(Integer id);
	public List<BlogType> listByPage(Map<String, Object> map);
	public Long getTotal();
	public Integer addBlogType(BlogType blogType);
	public Integer updateBlogType(BlogType blogType);
	public Integer deleteBlogType(Integer id);
}
