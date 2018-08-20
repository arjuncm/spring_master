/**
 * 
 */
package com.howtodospring.demo.config;

import javax.naming.spi.Resolver;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * @author arjun
 *
 */
/*@EnableWebMvc is used to enable Spring MVC. */
/*@ComponentScan  “telling Spring where to search” is called a Component Scan.*/
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.howtodospring.demo"})
public class WebMvcConfig implements WebMvcConfigurer{
	@Bean
	public InternalResourceViewResolver resolver() {
		 InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		 resolver.setViewClass(JstlView.class);
		 resolver.setPrefix("/WEB-INF/views/");
		 resolver.setSuffix(".jsp");
		return resolver;
		
	}
	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		return messageSource;
		
	}
	 public Validator validator() {
		LocalValidatorFactoryBean validator  = new  LocalValidatorFactoryBean();
		validator.setValidationMessageSource(messageSource());
		return validator;
		
	}
	
	
}
