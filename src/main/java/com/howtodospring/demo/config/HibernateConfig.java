/**
 * 
 */
package com.howtodospring.demo.config;

import java.nio.channels.SeekableByteChannel;

import org.hsqldb.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author arjun
 *
 */
/*@Configuration 
indicates that a class has more than one bean definitions.*/

/*@EnableTransactionManagement and <tx:annotation-driven/> are responsible 
for registering the necessary Spring components that power annotation-driven transaction management*/

@Configuration
@EnableTransactionManagement
public class HibernateConfig {
	@Autowired
	private ApplicationContext context;
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean  sessionFactory  = new LocalSessionFactoryBean();
		sessionFactory.setConfigLocation(context.getResource("classpath:hibernate.cfg.xml"));
		//TODo create two pojo classes 
		//sessionFactory.setAnnotatedClasses("User");
		//sessionFactory.setAnnotatedClasses("Questions");
		return sessionFactory;
		
	}
	
	public HibernateTransactionManager transactionManager() {
		HibernateTransactionManager trManager  = new HibernateTransactionManager();
		trManager.setSessionFactory(sessionFactory().getObject());
		return trManager;
		
	}

}
