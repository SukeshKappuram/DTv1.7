package com.fbook.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.fbook.dao.BlogDAO;
import com.fbook.dao.BlogDAOImpl;
import com.fbook.models.User;
import com.fbook.service.CommentService;
import com.fbook.service.EmailService;
import com.fbook.service.IBlogService;
import com.fbook.service.IChatService;
import com.fbook.service.ICommentService;
import com.fbook.service.IForumService;
import com.fbook.service.IUserService;
import com.google.gson.Gson;
import com.fbook.models.*;

@Controller
public class UserController {
	
	@Autowired(required=true)
	IUserService iUserService;
	
	@Autowired(required=true)
	IBlogService iBlogService;
	
	@Autowired(required=true)
	IForumService iForumService;
	
	@Autowired(required=true)
	ICommentService iCommentService;
	
	@Autowired(required=true)
	IChatService iChatService;
	
	User u;
	int trackId;
	
	@RequestMapping(value = { "/Addblog" })
    public ModelAndView Blog() {  
		String message = "create Blog page called";  
        System.out.println(message);
		return new ModelAndView("CreateBlog", "command", new Blog());
    }
	
	@RequestMapping(value = { "/Addfourm" })
    public ModelAndView fourm() {  
        String message = "fourm page called";  
        System.out.println(message);
        return new ModelAndView("CreateFourm", "command", new Forum());  
    }
	
	@RequestMapping("/saveBlog")
	  public ModelAndView storeBlog(HttpServletRequest request,ModelMap model,@Valid @ModelAttribute("fbook") Blog b, BindingResult result)
	    {
			ModelAndView mv=new ModelAndView("CreateBlog");
			
			b.setCreatedDate(new Date());
			b.setAuthorId(u.getUserId());
			if(result.hasErrors()){
				mv=new ModelAndView("CreateBlog", "command", new Blog());
						mv.addObject("errors", result.getAllErrors());
			}
			else{
				iBlogService.addBlog(b);
				mv=new ModelAndView("CreateBlog", "command", new Blog());
			}
			return mv;
	    }
	
	@RequestMapping("/saveForum")
	  public ModelAndView storeForum(HttpServletRequest request,ModelMap model,@ModelAttribute("fbook") Forum f,BindingResult result)
	    {
			f.setCreatedDate(new Date());
			f.setAuthor(u.getFirstName()+u.getLastName());
			iForumService.addForum(f);
			return new ModelAndView("CreateFourm", "command", new Forum()); 
	    }
	
	@RequestMapping(value = {"/Welcome" })
	public ModelAndView Welcome(HttpServletRequest request,HttpServletResponse response) { 
		String mailId=request.getParameter("userName");
		u=iUserService.getUser(mailId);
		//System.out.println(u);
		return new ModelAndView("Welcome", "user",u);
	}
	
	@RequestMapping(value = {"/Blog" })
    public ModelAndView viewBlog(HttpServletRequest request,HttpServletResponse response) {  
		String blogId=request.getParameter("b");
		trackId=Integer.parseInt(blogId);
		Comment c=new Comment();
		return new ModelAndView("viewBlog","Blog",iBlogService.getBlog(Integer.parseInt(blogId))).addObject("user", u).addObject("command",c).addObject("comments", iCommentService.getComments(trackId));
	}
	
	@RequestMapping(value = {"/Forum" })
    public ModelAndView viewForum(HttpServletRequest request,HttpServletResponse response) {  
		String forumId=request.getParameter("f");
		trackId=Integer.parseInt(forumId);
		Comment c=new Comment();
		return new ModelAndView("viewForum","Forum",iForumService.getForum(Integer.parseInt(forumId))).addObject("user", u).addObject("command", c).addObject("disscussions", iCommentService.getDisscusions(trackId));
	}
	
	@RequestMapping(value = {"/Comment" })
    public ModelAndView addComment(HttpServletRequest request,ModelMap model,@ModelAttribute("fbook") Comment c,BindingResult result) {  
		try{
			c.setAuthorId(u.getUserId());
			c.setCreatedDate(new Date());
			c.setTrackId(trackId);
		}catch(Exception e){System.out.println(e);}
		iCommentService.addComment(c);
		return new ModelAndView("Welcome", "user",u);
	}
	
	@RequestMapping(value = {"/Chat" })
	public ModelAndView chat(){
		return new ModelAndView("Chatting", "user",u);
	}
	
	@RequestMapping(value = {"/chatUsers" })
	public ModelAndView chatUsers(){
		return new ModelAndView("chatUsers", "users",iUserService.viewAllUers(u.getUserId()));
	}
	
	@RequestMapping(value = {"/messanger" })
	public ModelAndView startChat(HttpServletRequest request,HttpServletResponse response){
		trackId=Integer.parseInt(request.getParameter("ur"));
		return new ModelAndView("Messenger", "command", new Chat()).addObject("messages",iChatService.getMessages(u.getUserId(),trackId)).addObject("user",u);
	}
	
	@RequestMapping(value = {"/Message" })
	public ModelAndView reChat(HttpServletRequest request,ModelMap model,@ModelAttribute("fbook") Chat c,BindingResult result){
		c.setFromUserId(u.getUserId());
		c.setMessageDate(new Date());
		c.setToUserId(trackId);
		iChatService.addChat(c);
		return new ModelAndView("Messenger", "command", new Chat()).addObject("messages",iChatService.getMessages(u.getUserId(),trackId)).addObject("user",u);
	}
}
