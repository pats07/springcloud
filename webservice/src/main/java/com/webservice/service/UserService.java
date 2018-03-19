package com.webservice.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.webservice.domain.User;

@Service
public class UserService {

	static List<User> users = new ArrayList<>();
	static{
		users.add(new User(1, "Patit", new Date()));
		users.add(new User(2, "Piku", new Date()));
		users.add(new User(3, "Ravish", new Date()));
	}
	
	public List<User> getAllUsers() {
		return users;
	}
	
	public User getUserById(Integer id) {
		if(users.get(id) != null) {
			throw new RuntimeException();
		}
		return users.get(id);
	}
	
}
