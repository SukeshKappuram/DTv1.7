package com.fbook.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


import com.fbook.models.Blog;
import com.fbook.models.Forum;
@Repository("blogDAO")
public class BlogDAOImpl implements BlogDAO {

	@Autowired(required=true)
	private SessionFactory factory;
	
	@Transactional(propagation=Propagation.SUPPORTS)
	public List<Blog> getBlogs() {
		Session s=factory.getCurrentSession();
		Transaction t=s.beginTransaction();
		Criteria c=s.createCriteria(Blog.class);
		System.out.print(c.list());
		List<Blog> blogs=new ArrayList<Blog>(2);
		blogs=c.list();
		blogs.add(new Blog(101, "My Blog", new Date(), 1001));
		t.commit();
		return blogs;
	}

	public void deleteBlog(int bid) {
		// TODO Auto-generated method stub
	}

	@Transactional(propagation=Propagation.SUPPORTS)
	public void addBlog(Blog b) {
		// TODO Auto-generated method stub
		Session s=factory.getCurrentSession();
		Transaction t=s.beginTransaction();
		s.saveOrUpdate(b);
		t.commit();
	}

	public Blog getBlog(int blogId) {
		Session s=factory.getCurrentSession();
		Transaction t=s.beginTransaction();
		Criteria criteria = s.createCriteria(Blog.class);
        criteria.add(Restrictions.eq("blogId",blogId));
        Blog f=(Blog) criteria.uniqueResult();
		t.commit();
		return f;
	}


}
