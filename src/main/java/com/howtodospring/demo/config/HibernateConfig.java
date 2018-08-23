/**
 * 
 */
package com.howtodospring.demo.config;

import java.nio.channels.SeekableByteChannel;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hsqldb.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.howtodospring.demo.model.User;

/**
 * @author arjun
 *
 */
/*@Configuration 
indicates that a class has more than one bean definitions.*/

/*@EnableTransactionManagement and <tx:annotation-driven/> are responsible 
for registering the necessary Spring components that power annotation-driven transaction management*/

@Configuration
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
@ComponentScans(value = { @ComponentScan("com.howtodospring.demo")})
public class HibernateConfig {
	@Autowired
	private ApplicationContext context;
	@Autowired
	private Environment env;
	
	 @Bean
	   public DataSource getDataSource() {
	      BasicDataSource dataSource = new BasicDataSource();
	      dataSource.setDriverClassName(env.getProperty("db.driver"));
	      dataSource.setUrl(env.getProperty("db.url"));
	      dataSource.setUsername(env.getProperty("db.username"));
	      dataSource.setPassword(env.getProperty("db.password"));
	      return dataSource;
	   }
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean  sessionFactory  = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(getDataSource());
		
		Properties props=new Properties();
	   // props.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
	    props.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
	    sessionFactory.setHibernateProperties(props);
		//TODo create two pojo classes 
		sessionFactory.setAnnotatedClasses(User.class);
		//sessionFactory.setAnnotatedClasses("Questions");
		return sessionFactory;
		
	}
	@Bean
	public HibernateTransactionManager transactionManager() {
		HibernateTransactionManager trManager  = new HibernateTransactionManager();
		trManager.setSessionFactory(sessionFactory().getObject());
		return trManager;
		
	}

}
