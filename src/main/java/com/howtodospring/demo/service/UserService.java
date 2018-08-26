package com.howtodospring.demo.service;

import java.util.List;

import com.howtodospring.demo.model.Account;

public interface UserService {
	public void save(Account account);
	public List<Account> listUser();
	public void remove(Long id);
	public List<Account> removeUserList() ;

}
