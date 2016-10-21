package com.fbook.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fbook.models.Comment;
@Repository("commentDAO")
public class CommentDAOImpl implements CommentDAO{

	@Autowired(required=true)
	private SessionFactory factory;
	
	@Transactional(propagation=Propagation.SUPPORTS)
	public List<Comment> getComments(int BlogId) {
		// TODO Auto-generated method stub
		Session s=factory.getCurrentSession();
		Transaction t=s.beginTransaction();
		Criteria c=s.createCriteria(Comment.class);
		System.out.print(c.list());
		List<Comment> comments=c.list();
		//comments.add(new Comment(101, "My Blog", new Date(), "You"));
		t.commit();
		return comments;
	}

	@Transactional(propagation=Propagation.SUPPORTS)
	public List<Comment> getDisscusions(int forumId) {
		// TODO Auto-generated method stub
		Session s=factory.getCurrentSession();
		Transaction t=s.beginTransaction();
		Criteria c=s.createCriteria(Comment.class);
		System.out.print(c.list());
		List<Comment> disscusions=c.list();
		//comments.add(new Comment(101, "My Blog", new Date(), "You"));
		t.commit();
		return disscusions;
	}

	@Transactional(propagation=Propagation.SUPPORTS)
	public void addComment(Comment c) {
		// TODO Auto-generated method stub
		Session s=factory.getCurrentSession();
		Transaction t=s.beginTransaction();
		s.saveOrUpdate(c);
		t.commit();
	}

}
