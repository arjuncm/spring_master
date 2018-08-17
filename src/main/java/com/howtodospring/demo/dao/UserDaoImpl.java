package com.howtodospring.demo.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.howtodospring.demo.model.User;

@Repository
public class UserDaoImpl implements UserDao{
	@Autowired
	private SessionFactory sfactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<User> listUser() {
		
		return (List<User>) sfactory.getCurrentSession().get(User.class,new Integer(1) );
	}

	@Override
	public void save(User user) {
		
		sfactory.getCurrentSession().save(user);
	}

}
