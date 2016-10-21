package com.fbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fbook.dao.CommentDAO;
import com.fbook.models.Comment;
@Service("iCommentService")
public class CommentService implements ICommentService{

	@Autowired(required=true)
	CommentDAO cd;
	
	public List<Comment> getComments(int BlogId) {
		// TODO Auto-generated method stub
		return cd.getComments(BlogId);
	}

	public List<Comment> getDisscusions(int forumId) {
		// TODO Auto-generated method stub
		return cd.getDisscusions(forumId);
	}

	public void addComment(Comment c) {
		// TODO Auto-generated method stub
		cd.addComment(c);
	}

}
