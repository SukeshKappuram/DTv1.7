package com.fbook.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.fbook.dao.BlogDAO;
import com.fbook.dao.BlogDAOImpl;
import com.fbook.models.User;
import com.fbook.service.EmailService;
import com.fbook.service.IBlogService;
import com.fbook.service.IEmailService;
import com.fbook.service.IForumService;
import com.fbook.service.IUserService;
import com.google.gson.Gson;

@Controller
public class HomeController {
	
	@Autowired(required=true)
	IUserService iUserService;
	
	@Autowired(required=true)
	IEmailService iEmailService;
	
	@Autowired(required=true)
	IBlogService iBlogService;
	
	@Autowired(required=true)
	IForumService iForumService;
	
	@RequestMapping(value = { "/", "/Home" })
    public ModelAndView index() {  
        String message = "index page called";  
        System.out.println(message);
        return new ModelAndView("Home", "Title", "FrindzBook");  
    }
	
	@RequestMapping(value = { "/SignIn" })
    public ModelAndView Login() {  
        String message = "Sign up page called";  
        System.out.println(message);
        return new ModelAndView("Login", "Title", "FrindzBook");  
    }
	
	@RequestMapping(value = { "/SignUp" })
    public ModelAndView SignUp() {  
        String message = "SignUp page called";
        System.out.println(message);
        return new ModelAndView("SignUp", "command", new User());  
    }
	
	@RequestMapping("/Register")
	  public ModelAndView store(HttpServletRequest request,@RequestParam("file") MultipartFile file,ModelMap model,@ModelAttribute("fbook") User u,BindingResult result)
	    {
		u.setEnabled(true);
    	iUserService.addUser(u);
		String fileName = null,error="";
    	if (!file.isEmpty()) {
            try {
                fileName = file.getOriginalFilename();
                byte[] bytes = file.getBytes();
                BufferedOutputStream buffStream = new BufferedOutputStream(new FileOutputStream(new File("E:/DT/Workspace/fbook/src/main/webapp/resources/images/User/" + fileName)));
                buffStream.write(bytes);
                buffStream.close();
                error= "You have successfully uploaded " + fileName;
            } catch (Exception e) {
            	error="You failed to upload " + fileName + ": " + e.getMessage();
            }
        } else {
        	error="Unable to upload. File is empty.";
        }
    	File oldName = new File("E:/DT/Workspace/fbook/src/main/webapp/resources/images/User/" + fileName);
        File newName = new File("E:/DT/Workspace/fbook/src/main/webapp/resources/images/User/" + u.getUserId()+fileName.substring(fileName.indexOf(".")));
        if(oldName.renameTo(newName)) {
           System.out.println(u.getUserId());
           error=u.getLastName()+" Profile Upload Successfully !";
        }
        	
        	iEmailService.Mail(u.getMailId(), u.getFirstName()+" "+u.getLastName());
	    	System.out.println("Registration Successfull!! "+u.getFirstName());
	    	return new ModelAndView("Login", "user", u);
	    }
	
	@RequestMapping(value = { "/blog" })
    public ModelAndView Blog() {  
		Gson gson=new Gson();
        String message = "blog page called";  
        System.out.println(message);
        return new ModelAndView("Blog", "blogs",gson.toJson(iBlogService.getBlogs())).addObject("bcount", iBlogService.getBlogs().size());  
    }
	
	@RequestMapping(value = { "/fourm" })
    public ModelAndView fourm() {  
		Gson gson=new Gson();
        String message = "fourm page called";  
        System.out.println(message);
        return new ModelAndView("Forum", "forums",gson.toJson(iForumService.getForums())).addObject("fcount", iForumService.getForums().size());  
    }
	
	
}
