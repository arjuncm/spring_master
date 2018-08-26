package com.howtodospring.demo.dao;

import java.util.List;

import com.howtodospring.demo.model.Account;


public interface UserDao {
	public void save(Account account);
	public List<Account> listUser() ;
	public void remove(Long id);
	public List<Account> removeUserList() ;
	
	

}
