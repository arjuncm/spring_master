package com.howtodospring.demo.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.howtodospring.demo.model.Account;

@Repository
public class UserDaoImpl implements UserDao{
	@Autowired
	private SessionFactory sfactory;

	@Override
	public List<Account> listUser() {
		@SuppressWarnings("unchecked")
		TypedQuery<Account> query = sfactory.getCurrentSession().createQuery("from Account  WHERE USER_STATUS =:ENABLED");
		query.setParameter("ENABLED", "ENABLED");
	      return query.getResultList();
	}

	@Override
	public void save(Account account) {
		//user.setStatus("ENABLED");
		sfactory.getCurrentSession().save(account);
	}

	@Override
	public void remove(Long id) {
		Session session = sfactory.getCurrentSession(); 
		Account account = (Account)session.get(Account.class, id);
	    account.setStatus("DISABLED");
	    if(account != null){
	    	System.out.println("******************"+account.toString());
	    }
		
		/*if(user !=null){
			session.update(user);
			System.err.println("Account deleted successfully, person details="+user);
		}
		*/
		
	}

	@Override
	public List<Account> removeUserList() {
		@SuppressWarnings("unchecked")
		TypedQuery<Account> query = sfactory.getCurrentSession().createQuery("from Account  WHERE USER_STATUS =:DISABLED");
		query.setParameter("DISABLED", "DISABLED");
	      return query.getResultList();
		
	}

}
