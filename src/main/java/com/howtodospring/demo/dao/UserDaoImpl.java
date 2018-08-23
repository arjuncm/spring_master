package com.howtodospring.demo.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
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
		TypedQuery<User> query = sfactory.getCurrentSession().createQuery("from User  WHERE USER_STATUS =:ENABLED");
		query.setParameter("ENABLED", "ENABLED");
	      return query.getResultList();
	}

	@Override
	public void save(User user) {
		//user.setStatus("ENABLED");
		sfactory.getCurrentSession().save(user);
	}

	@Override
	public void remove(Long id) {
		Session session = sfactory.getCurrentSession(); 
		User user = (User)session.get(User.class, id);
	    user.setStatus("DISABLED");
	    if(user != null){
	    	System.out.println("******************"+user.toString());
	    }
		
		/*if(user !=null){
			session.update(user);
			System.err.println("User deleted successfully, person details="+user);
		}
		*/
		
	}

	@Override
	public List<User> removeUserList() {
		@SuppressWarnings("unchecked")
		TypedQuery<User> query = sfactory.getCurrentSession().createQuery("from User  WHERE USER_STATUS =:DISABLED");
		query.setParameter("DISABLED", "DISABLED");
	      return query.getResultList();
		
	}

}
