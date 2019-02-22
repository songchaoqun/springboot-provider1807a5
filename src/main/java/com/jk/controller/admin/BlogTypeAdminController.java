package com.jk.controller.admin;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jk.Utils.ResponseUtil;
import com.jk.model.BlogType;
import com.jk.model.PageBean;
import com.jk.service.BlogService;
import com.jk.service.BlogTypeService;
import com.jk.service.LinkService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


@Controller
@RequestMapping("/admin/blogType")
public class BlogTypeAdminController {
	@Resource
	private BlogTypeService blogTypeService;
	@Resource
	private BlogService blogService;
	@Resource
	private LinkService linkService;
	@RequestMapping("/listBlogType")
	public String listBlogType(@RequestParam(value="page",required=false)String page,
							   @RequestParam(value="rows",required=false)String rows,
							   HttpServletResponse response)throws Exception{
		PageBean pageBean=new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		Map<String, Object>map=new HashMap<String, Object>();
		map.put("start", pageBean.getPage());
		System.out.println("start:"+pageBean.getStart());
		map.put("pageSize", pageBean.getPageSize());
		System.out.println("pagesize:"+pageBean.getPageSize());
		List<BlogType> blogTypeList=blogTypeService.listByPage(map);
		Long total=blogTypeService.getTotal();
		JSONObject result=new JSONObject();
		JSONArray jsonArray=JSONArray.fromObject(blogTypeList);
		result.put("rows", jsonArray);
		result.put("total", total);
		ResponseUtil.write(response, result);
		return null;
	}
	@RequestMapping("/save")
	public String save(BlogType blogType,HttpServletResponse response,HttpServletRequest request)throws Exception
	{
		int resultTotal=0;
		if(blogType.getId()==null){
			resultTotal=blogTypeService.addBlogType(blogType);
		}else
		{
			resultTotal=blogTypeService.updateBlogType(blogType);
		}
		JSONObject jsonObject=new JSONObject();
		if(resultTotal>0){
			int blogTypeTotal=blogTypeService.getBlogTypeData().size();
			int linkTotal=linkService.getLinkData().size();
			int alltotals=blogTypeTotal+linkTotal;
			List<BlogType> BlogTypeList=blogTypeService.getBlogTypeData();//��ʹ���²��������Ϣ
			request.getSession().getServletContext().setAttribute("countsallcategories", blogTypeTotal);
			request.getSession().getServletContext().setAttribute("countsalltags", alltotals);
			jsonObject.put("success", true);
		}else
		{
			jsonObject.put("success", false);
		}
		ResponseUtil.write(response, jsonObject);
		return null;
	}
	@RequestMapping("/delete")
	public String deleteBlogType(@RequestParam(value="ids",required=false)String ids,HttpServletResponse response,HttpServletRequest request) throws Exception{
		String[] idsStr=ids.split(",");
		JSONObject jsonObject=new JSONObject();
		for(int i=0;i<idsStr.length;i++){
			int id=Integer.parseInt(idsStr[i]);
			if(blogService.getBlogByTypeId(id)>0){
				jsonObject.put("exist", "��������в��ͣ�����ɾ��!");
			}else
			{
				blogTypeService.deleteBlogType(id);
			}
		}
		int blogTypeTotal=blogTypeService.getBlogTypeData().size();
		int linkTotal=linkService.getLinkData().size();
		int alltotals=blogTypeTotal+linkTotal;
		List<BlogType> BlogTypeList=blogTypeService.getBlogTypeData();//��ʹ���²��������Ϣ
		request.getSession().getServletContext().setAttribute("countsallcategories", blogTypeTotal);
		request.getSession().getServletContext().setAttribute("countsalltags", alltotals);
		jsonObject.put("success", true);
		ResponseUtil.write(response, jsonObject);
		return null;
	}
}
