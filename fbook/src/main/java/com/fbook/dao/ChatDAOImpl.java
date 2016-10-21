package com.fbook.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fbook.models.Chat;
import com.fbook.models.Forum;
@Repository("chatDAO")
public class ChatDAOImpl implements ChatDAO {

	@Autowired(required=true)
	private SessionFactory factory;
	
	@Transactional(propagation=Propagation.SUPPORTS)
	public void addChat(Chat c) {
		// TODO Auto-generated method stub
		Session s=factory.getCurrentSession();
		Transaction t=s.beginTransaction();
		s.saveOrUpdate(c);
		t.commit();
	}

	public List<Chat> getMessages(int fromUserId,int toUserId) {
		// TODO Auto-generated method stub
		Session s=factory.getCurrentSession();
		Transaction t=s.beginTransaction();
		Criteria c=s.createCriteria(Chat.class);
		List<Integer> users=new ArrayList<Integer>(2);
		users.add(new Integer(fromUserId));
		users.add(new Integer(toUserId));
		c.add(Restrictions.and(Restrictions.in("fromUserId",users),Restrictions.in("toUserId",users)));
		c.addOrder(Order.asc("messageId"));
		System.out.print(c.list());
		List<Chat> messages=c.list();
		t.commit();
		return messages;
	}

}
