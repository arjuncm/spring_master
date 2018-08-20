package com.howtodospring.demo.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.howtodospring.demo.model.User;

@Repository
public class UserDaoImpl implements UserDao{
	@Autowired
	private SessionFactory sfactory;

	@Override
	public List<User> listUser() {
		@SuppressWarnings("unchecked")
		TypedQuery<User> query = sfactory.getCurrentSession().createQuery("from User");
		System.out.println("*******************************"+query.getResultList().get(0).getName());
	      return query.getResultList();
	}

	@Override
	public void save(User user) {
		
		sfactory.getCurrentSession().save(user);
	}

}
