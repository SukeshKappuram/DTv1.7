package com.fbook.service;

import java.util.List;

import com.fbook.models.Forum;

public interface IForumService {
	public List getForums();
	public Forum getForum(int forumId);
	public void deleteForum(int fid);
	public void addForum(Forum f);
	
}
