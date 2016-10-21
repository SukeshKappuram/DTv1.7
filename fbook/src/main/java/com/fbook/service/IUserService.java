package com.fbook.service;

import java.util.List;

import com.fbook.models.User;

public interface IUserService {
	public void addUser(User u);
	public List<User> viewAllUers(int userId);
	public User getUser(String mailId);
}
