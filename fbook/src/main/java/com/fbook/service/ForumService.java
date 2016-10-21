package com.fbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fbook.dao.ForumDAO;
import com.fbook.models.Forum;

@Service("iForumService")
public class ForumService implements IForumService {

	@Autowired(required=true)
	ForumDAO fd;
	
	public List getForums() {
		// TODO Auto-generated method stub
		return fd.getForums();
	}

	public void deleteForum(int fid) {
		// TODO Auto-generated method stub
		
	}

	@Transactional(propagation=Propagation.SUPPORTS)
	public void addForum(Forum f) {
		// TODO Auto-generated method stub
		fd.addForum(f);
	}

	public Forum getForum(int forumId) {
		// TODO Auto-generated method stub
		return fd.getForum(forumId);
	}

}
