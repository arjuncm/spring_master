package com.howtodospring.demo.service;

import java.util.List;

import com.howtodospring.demo.model.User;

public interface UserService {
	public void save(User user);
	public List<User> listUser();

}
