

package com.howtodospring.demo.service;

import java.util.List;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.howtodospring.demo.dao.UserDao;
import com.howtodospring.demo.model.Account;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;	
	@Transactional
	public void save(Account account) {
		userDao.save(account);
		
	}	
	@Transactional(readOnly = true)
	public List<Account> listUser() {
		return userDao.listUser();
		
	}
	@Transactional
	public void remove(Long id) {
		userDao.remove(id);
		
	}
	@Override
	public List<Account> removeUserList() {
		// TODO Auto-generated method stub
		return userDao.removeUserList();
	}

}
