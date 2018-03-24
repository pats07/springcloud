package com.webservice.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.webservice.domain.User;

@Service
public class UserService {

	static List<User> users = new ArrayList<>();
	static Integer count = 3;
	static{
		users.add(new User(1, "Patit", new Date()));
		users.add(new User(2, "Piku", new Date()));
		users.add(new User(3, "Ravish", new Date()));
	}
	
	public List<User> getAllUsers() {
		return users;
	}
	
	public User getUserById(Integer id) {
		
		for(User user: users) {
			if(user.getId() == id) {
				return user;
			}
		}		
		return null;
	}
	
	public User addUser(User user) {
		user.setId(++count);
		users.add(user);
		return user;
	}
	
	public User deleteUser(Integer id) {
		
		Iterator<User> it = users.iterator();
		
		while(it.hasNext()) {
			User user = it.next();
			if(user.getId() == id) {
				it.remove();
				return user;
			}
			
		}
		return null;
	}
	
}
