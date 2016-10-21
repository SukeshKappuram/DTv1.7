package com.fbook.dao;

import java.util.List;

import com.fbook.models.Blog;
import com.fbook.models.Forum;

public interface BlogDAO {
	public List<Blog> getBlogs();
	public Blog getBlog(int blogId);
	public void deleteBlog(int blogId);
	public void addBlog(Blog b);
}
