package com.jk.model;

public class PageBean {
	private int page;
	private int pageSize;
	private int start;
//	private int totalPage;
	public PageBean(int page, int pageSize) {
		super();
		this.page = (page-1)*pageSize;
		this.pageSize = pageSize;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}

	
}
