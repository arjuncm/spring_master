package com.howtodospring.demo.dao;

import java.util.List;

import com.howtodospring.demo.model.User;


public interface UserDao {
	public void save(User user);
	public List<User> listUser() ;
	public void remove(Long id);
	public List<User> removeUserList() ;
	
	

}
