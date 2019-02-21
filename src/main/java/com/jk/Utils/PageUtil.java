package com.jk.Utils;

import com.jk.model.Blog;

public class PageUtil {
	public static String genPagination(String targetUrl,long totalNum,int currentPage,int pageSize,String param)
	{
		long totalPage = totalNum % pageSize==0 ? totalNum/pageSize : totalNum/pageSize+1; 
		if(totalPage == 0){
			return "δ��ѯ������";
		}else{
			StringBuffer pageCode = new StringBuffer();
			if(currentPage > 1) {
				pageCode.append("<li><a href='" + targetUrl + "?page=1&" + param + "'>��ҳ</a></li>");
				pageCode.append("<li><a href='" + targetUrl + "?page=" + (currentPage-1) + "&" + param + "'>��һҳ</a></li>");			
			}else{
				pageCode.append("<li class='disabled'><a>��ҳ</a></li>");
				pageCode.append("<li class='disabled'><a>��һҳ</a></li>");		
			}
			for(int i = currentPage - 2; i <= currentPage + 2; i++) {
				if(i < 1 || i > totalPage) {
					continue;
				}
				if(i == currentPage) {
					pageCode.append("<li class='active'><a href='" + targetUrl + "?page=" + i + "&" + param + "'>" + i + "</a></li>");	
				}else{
					pageCode.append("<li><a href='" + targetUrl + "?page=" + i + "&" + param + "'>" + i + "</a></li>");	
				}
			}
			if(currentPage < totalPage) {
				pageCode.append("<li><a href='" + targetUrl + "?page=" + (currentPage+1) + "&" + param + "'>��һҳ</a></li>");
				pageCode.append("<li><a href='" + targetUrl + "?page=" + totalPage + "&" + param + "'>βҳ</a></li>");
			}else{
				pageCode.append("<li class='disabled'><a>��һҳ</a></li>");	
				pageCode.append("<li class='disabled'><a>βҳ</a></li>");
			}
			return pageCode.toString();
		}
	}
	
	public static String getPrevAndNextPageCode(Blog prev, Blog next, String projectContent) {
		StringBuffer pageCode = new StringBuffer();
		if(prev == null || prev.getId() == null) {
			pageCode.append("<p>��һƪ����</P>");
		} else {
			pageCode.append("<p>��һƪ��<a href='" + projectContent + "/blog/articles/" + prev.getId() + ".html'>" + prev.getTitle() + "</a></p>");
		}
		
		if(next == null || next.getId() == null) {
			pageCode.append("<p>��һƪ����</P>");
		} else {
			pageCode.append("<p>��һƪ��<a href='" + projectContent + "/blog/articles/" + next.getId() + ".html'>" + next.getTitle() + "</a></p>");
		}
		
		return pageCode.toString();
	}
	
	//Lucence�������ͽ���ķ�ҳ
	public static String getUpAndDownPageCode (
			Integer page, 
			Integer totalNum, 
			String q, 
			Integer pageSize, 
			String projectContext) {
		
		//������ҳ��
		long totalPage = totalNum % pageSize==0 ? totalNum/pageSize : totalNum/pageSize+1; 
		StringBuffer pageCode = new StringBuffer();
		if(totalPage == 0) {
			return "";
		} else {
			pageCode.append("<nav>");
			pageCode.append("<ul class='pager'>");
			if(page > 1) {
				pageCode.append("<li><a href='"+projectContext+"/blog/search.html?page="+(page-1)+"&q="+q+"'>��һҳ</a></li>");
			} else {
				pageCode.append("<li class='disabled'><a>��һҳ</a></li>");
			}
			if(page < totalPage) {
				pageCode.append("<li><a href='"+projectContext+"/blog/search.html?page="+(page+1)+"&q="+q+"'>��һҳ</a></li>");
			} else {
				pageCode.append("<li class='disabled'><a>��һҳ</a></li>");
			}
			pageCode.append("</ul>");
			pageCode.append("<nav>");
			pageCode.append("<nav>");
			pageCode.append("<nav>");
		}
		
		return pageCode.toString();
	}

}
