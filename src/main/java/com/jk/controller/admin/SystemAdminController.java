package com.jk.controller.admin;

import com.jk.Utils.ResponseUtil;
import com.jk.model.Blog;
import com.jk.model.BlogType;
import com.jk.model.Blogger;
import com.jk.model.Link;
import com.jk.service.BlogService;
import com.jk.service.BlogTypeService;
import com.jk.service.BloggerService;
import com.jk.service.LinkService;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

 /** 
 * @ClassName: SystemAdminController 
 * @author: lyd
 * @date: 2017��10��10�� ����4:47:30 
 * @describe:����ˢ��ϵͳ����
 */
@Controller
@RequestMapping("/admin/system")
public class SystemAdminController {
	@Resource
	private BloggerService bloggerService;
	@Resource
	private LinkService linkService;
	@Resource
	private BlogTypeService blogTypeService;
	@Resource
	private BlogService blogService;
	@RequestMapping("/refreshSystemCache")
	public String refreshSystemCache(HttpServletRequest request,HttpServletResponse response) throws Exception{
			ServletContext application=request.getSession().getServletContext();
			Blogger blogger=bloggerService.getBloggerData();
			blogger.setPassword(null);
			application.setAttribute("blogger", blogger);
			List<Link> linkList=linkService.getLinkData();
			application.setAttribute("linkList", linkList);
			List<BlogType> blogTypeList=blogTypeService.getBlogTypeData();
			application.setAttribute("blogTypeList", blogTypeList);
			List<Blog>blogTimeList=blogService.getBlogData();
			application.setAttribute("blogTimeList", blogTimeList);
			JSONObject jsonObject=new JSONObject();
			jsonObject.put("success", true);
			ResponseUtil.write(response, jsonObject);
			return null;
	}
}
