package com.fbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fbook.dao.UserDAO;
import com.fbook.models.User;

@Service("iUserService")
public class UserService implements IUserService {
	@Autowired(required=true)
	UserDAO ud;

	@Transactional(propagation=Propagation.SUPPORTS)
	public void addUser(User u) {
		ud.addUser(u);
	}

	public List<User> viewAllUers(int userId) {
		// TODO Auto-generated method stub
		return ud.getUsers(userId);
	}
	
	public User getUser(String mailId){
		return ud.getUser(mailId);
	}

}
