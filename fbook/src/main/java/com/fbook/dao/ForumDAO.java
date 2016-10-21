package com.fbook.dao;

import java.util.List;

import com.fbook.models.Forum;

public interface ForumDAO {
	
	public List getForums();
	public Forum getForum(int forumId);
	public void deleteForum(int forumId);
	public void addForum(Forum f);

}
