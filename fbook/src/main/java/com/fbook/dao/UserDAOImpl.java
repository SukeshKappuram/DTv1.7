package com.fbook.dao;

import java.util.*;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fbook.models.User;
@Repository("userDAO")
public class UserDAOImpl implements UserDAO{

	@Autowired(required=true)
	private SessionFactory factory;
	
	@Transactional(propagation=Propagation.SUPPORTS)
	public void addUser(User u) {
		Session s=factory.getCurrentSession();
		Transaction t=s.beginTransaction();
		s.saveOrUpdate(u);
		t.commit();
	}
	
	public List<User> getUsers(int userId) {
		Session s=factory.getCurrentSession();
		Transaction t=s.beginTransaction();
		Criteria criteria = s.createCriteria(User.class);
        criteria.add(Restrictions.ne("userId", userId));
        List<User> users=criteria.list();
		t.commit();
		return users;
	}
	
	public User getUser(String mailId){
		Session s=factory.getCurrentSession();
		Transaction t=s.beginTransaction();
		Criteria criteria = s.createCriteria(User.class);
        criteria.add(Restrictions.like("mailId", mailId));
        User u=(User) criteria.uniqueResult();
		t.commit();
		return u;
	}

}
