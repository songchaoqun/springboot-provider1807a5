package com.jk.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.jk.service.LinkService;
import org.springframework.stereotype.Service;

import com.jk.dao.LinkDao;
import com.jk.model.Link;
@Service("linkService")
public class LinkServiceImpl implements LinkService {
	@Resource
	private LinkDao linkDao;
	public List<Link> getLinkData() {
		// TODO Auto-generated method stub
		return linkDao.getLinkData();
	}

	public List<Link> listLinkData(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return linkDao.listLinkData(map);
	}

	public Long getTotal() {
		// TODO Auto-generated method stub
		return linkDao.getTotal();
	}

	public Integer addLink(Link link) {
		// TODO Auto-generated method stub
		return linkDao.addLink(link);
	}

	public Integer updateLink(Link link) {
		// TODO Auto-generated method stub
		return linkDao.updateLink(link);
	}

	public Integer deleteLink(Integer id) {
		// TODO Auto-generated method stub
		return linkDao.deleteLink(id);
	}

}
