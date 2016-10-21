package com.fbook.dao;

import java.util.List;

import com.fbook.models.Comment;

public interface CommentDAO {
	public List<Comment> getComments(int BlogId);
	public List<Comment> getDisscusions(int forumId);
	public void addComment(Comment c);
}
