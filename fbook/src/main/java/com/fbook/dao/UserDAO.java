package com.fbook.dao;
import java.util.*;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fbook.models.User;

public interface UserDAO {
	public void addUser(User u);
	public List<User> getUsers(int userId);
	public User getUser(String mailId);
}
