package com.jk.controller.admin;

import com.jk.Utils.DateJsonValueProcessor;
import com.jk.Utils.ResponseUtil;
import com.jk.model.Comment;
import com.jk.model.PageBean;
import com.jk.service.CommentService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/admin/comment")
public class CommentAdminController {
	@Resource
	private CommentService commentService;
	@RequestMapping("/listComment")
	@ResponseBody
	public JSONObject listBlog(
			@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "rows", required = false) String rows,
			@RequestParam(value = "state", required = false) String state,
			HttpServletResponse response) throws Exception {
		PageBean pageBean = new PageBean(Integer.parseInt(page),
				Integer.parseInt(rows));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", pageBean.getStart());
		map.put("pageSize", pageBean.getPageSize());
		map.put("state", state);
		List<Comment> commentList = commentService.getCommentData(map);
		Long total = commentService.getTotal(map);
		JSONObject result = new JSONObject();
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.registerJsonValueProcessor(java.util.Date.class,
				new DateJsonValueProcessor("yyyy-MM-dd"));
		JSONArray jsonArray = JSONArray.fromObject(commentList, jsonConfig);
		result.put("rows", jsonArray);
		result.put("total", total);
		/*ResponseUtil.write(response, result);*/
		return result;
	}
	@RequestMapping("/deleteComment")
	@ResponseBody
	public String deleteComment(@RequestParam(value="ids",required=false)String ids,HttpServletResponse response)throws Exception
	{
		String idsStr[]=ids.split(",");
		for(int i=0;i<idsStr.length;i++){
			System.out.println(Integer.parseInt(idsStr[i]));
			commentService.deleteComment(Integer.parseInt(idsStr[i]));
		}
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("success", true);
		ResponseUtil.write(response, jsonObject);
		return null;
	}
	@RequestMapping("/review")
	@ResponseBody
	public String review(@RequestParam(value="ids",required=false)String ids,@RequestParam(value="state",required=false)Integer state
			,HttpServletResponse response)throws Exception
	{
		String[] idsStr=ids.split(",");
		JSONObject jsonObject=new JSONObject();
		for(int i=0;i<idsStr.length;i++){
			Comment comment=new Comment();
			comment.setId(Integer.parseInt(idsStr[i]));
			comment.setState(state);
			commentService.update(comment);
		}
		jsonObject.put("success", true);
		ResponseUtil.write(response, jsonObject);
		return null;
	}
}
