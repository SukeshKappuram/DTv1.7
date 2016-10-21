package com.fbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fbook.dao.BlogDAO;
import com.fbook.dao.UserDAO;
import com.fbook.models.Blog;

@Service("iBlogService")
public class BlogService implements IBlogService{
	@Autowired(required=true)
	BlogDAO bd;

	public List<Blog> getBlogs() {
		// TODO Auto-generated method stub
		return bd.getBlogs();
	}

	public void deleteBlog(int bid) {
		// TODO Auto-generated method stub
		
	}

	@Transactional(propagation=Propagation.SUPPORTS)
	public void addBlog(Blog b) {
		// TODO Auto-generated method stub
		bd.addBlog(b);
	}

	public Blog getBlog(int blogId) {
		// TODO Auto-generated method stub
		return bd.getBlog(blogId);
	}

}
