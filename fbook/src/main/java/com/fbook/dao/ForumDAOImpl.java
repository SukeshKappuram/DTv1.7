package com.fbook.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fbook.models.Blog;
import com.fbook.models.Forum;
import com.fbook.models.User;

@Repository("forumDAO")
public class ForumDAOImpl implements ForumDAO {

	@Autowired(required=true)
	private SessionFactory factory;
	
	public List<Forum> getForums() {
		Session s=factory.getCurrentSession();
		Transaction t=s.beginTransaction();
		Criteria c=s.createCriteria(Forum.class);
		System.out.print(c.list());
		List<Forum> forums=new ArrayList<Forum>(2);
		forums=c.list();
		forums.add(new Forum(101, "My Blog", new Date(), "You"));
		t.commit();
		return forums;
	}

	public void deleteForum(int fid) {
		// TODO Auto-generated method stub
		
	}

	@Transactional(propagation=Propagation.SUPPORTS)
	public void addForum(Forum f) {
		// TODO Auto-generated method stub
		Session s=factory.getCurrentSession();
		Transaction t=s.beginTransaction();
		s.saveOrUpdate(f);
		t.commit();
	}

	public Forum getForum(int forumId) {
		Session s=factory.getCurrentSession();
		Transaction t=s.beginTransaction();
		Criteria criteria = s.createCriteria(Forum.class);
        criteria.add(Restrictions.eq("forumId",forumId));
        Forum f=(Forum) criteria.uniqueResult();
		t.commit();
		return f;
	}

}
