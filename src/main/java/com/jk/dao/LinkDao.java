package com.jk.dao;

import java.util.List;
import java.util.Map;

import com.jk.model.Link;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LinkDao {
	public List<Link> getLinkData();

	public List<Link> listLinkData(Map<String, Object> map);

	public Long getTotal();

	public Integer addLink(Link link);

	public Integer updateLink(Link link);

	public Integer deleteLink(Integer id);
}
