package com.fbook.service;

import java.util.List;

import com.fbook.models.Comment;

public interface ICommentService {
	public List<Comment> getComments(int BlogId);
	public List<Comment> getDisscusions(int forumId);
	public void addComment(Comment c);
}
