package com.jk.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;import org.apache.lucene.queryparser.surround.query.SrndPrefixQuery;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jk.Utils.ResponseUtil;
import com.jk.model.Blog;
import com.jk.model.Comment;
import com.jk.service.BlogService;
import com.jk.service.CommentService;

import net.sf.json.JSONObject;


@Controller
@RequestMapping("/comment")
public class CommentController {
	@Resource
	private CommentService commentService;
	@Resource
	private BlogService blogService;
	//评论信息保存
	@RequestMapping("/save")
	public String save(Comment comment,HttpServletRequest request,HttpServletResponse response,HttpSession session) throws Exception{
		System.out.println("评论。");
//		String sRand=(String)session.getAttribute("sRand");//评论信息保存
		JSONObject jsonObject=new JSONObject();
		int resultTotal=0;
			String userIp=request.getRemoteAddr();//获取评论用户ip地址
			System.out.println("userIp"+userIp);
			comment.setUserIp(userIp);
			if(comment.getId()==null)
			{
				resultTotal=commentService.addComment(comment);
				Blog blog=blogService.findById(comment.getBlog().getId());
				blog.setReplyHit(blog.getReplyHit()+1);
				blogService.update(blog);
			}else
			{
				
			}
			if(resultTotal>0){
				jsonObject.put("success", true);
			}
			ResponseUtil.write(response, jsonObject);
			return null;
		
	}
}
