package com.peer.Config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.peer.model.Blog;
import com.peer.model.Chat;
import com.peer.model.Comment;
import com.peer.model.Event;
import com.peer.model.Forum;
import com.peer.model.Friend;
import com.peer.model.Friends;
import com.peer.model.User;
import com.peer.model.UserRole;



@Configuration
@ComponentScan("com.peer")
@EnableTransactionManagement
public class ApplicationConfiguration {
	private  Properties getHibernateProperties()
	{
		Properties properties=new Properties();
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		return properties;
	}
	
	@Autowired
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource)
	{
		LocalSessionFactoryBuilder localSessionFactoryBuilder=new LocalSessionFactoryBuilder(dataSource);
		localSessionFactoryBuilder.addProperties(getHibernateProperties());
		localSessionFactoryBuilder.addAnnotatedClass(User.class);
		localSessionFactoryBuilder.addAnnotatedClass(Blog.class);
		localSessionFactoryBuilder.addAnnotatedClass(Chat.class);
		localSessionFactoryBuilder.addAnnotatedClass(Comment.class);
		localSessionFactoryBuilder.addAnnotatedClass(Forum.class);
		localSessionFactoryBuilder.addAnnotatedClass(Event.class);
		localSessionFactoryBuilder.addAnnotatedClass(UserRole.class);
		localSessionFactoryBuilder.addAnnotatedClass(Friends.class);
		localSessionFactoryBuilder.addAnnotatedClass(Friend.class);
		
		return localSessionFactoryBuilder.buildSessionFactory();
	}
	
	@Autowired
	@Bean(name="transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{
		HibernateTransactionManager hibernateTransactionManager=new HibernateTransactionManager(sessionFactory);
		return hibernateTransactionManager;
		
	}
	
	@Autowired
	@Bean(name="javaMailSender")
	public JavaMailSender javaMailService() {
		
		JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
			
		Properties mailProperties = new Properties();
        
        mailProperties.put("mail.smtp.host", "smtp.gmail.com");
        mailProperties.put("mail.smtp.auth","true");
        mailProperties.put("mail.smtp.starttls.enable", "true");
        mailProperties.put("mail.smtp.port", "587");
        mailProperties.setProperty("mail.debug", "true");
        
	        javaMailSender.setJavaMailProperties(mailProperties);
	        javaMailSender.setHost("smtp.gmail.com");
	        javaMailSender.setPort(587);
	        javaMailSender.setProtocol("smtp");
	        javaMailSender.setUsername("sumikshareddy4@gmail.com");
	        javaMailSender.setPassword("reddy@111");
	        
	        return javaMailSender;
	    }
}