package com.howtodospring.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.howtodospring.demo.dao.UserDao;
import com.howtodospring.demo.model.User;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public void save(User user) {
		userDao.save(user);
		
	}

	@Override
	public List<User> listUser() {
		return userDao.listUser();
		
	}

}
