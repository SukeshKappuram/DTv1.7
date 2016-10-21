package com.fbook.service;

import java.util.List;

import com.fbook.models.Blog;

public interface IBlogService {
	public List getBlogs();
	public Blog getBlog(int blogId);
	public void deleteBlog(int bid);
	public void addBlog(Blog b);
}
