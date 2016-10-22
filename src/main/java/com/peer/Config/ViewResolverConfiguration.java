package com.peer.Config;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
	@EnableWebMvc
	@ComponentScan(basePackages="com.devops")
	public class ViewResolverConfiguration {
		@Bean(name="dataSource")
		public DataSource getDataSource()
		{
			System.out.println("get Datasourcemethod called");
			DriverManagerDataSource  dataSource=new DriverManagerDataSource();
			System.out.println("hai");
			dataSource.setDriverClassName("org.h2.Driver");
			dataSource.setUsername("sumiksha");
			dataSource.setPassword("sairam931");
			dataSource.setUrl("jdbc:h2:tcp://localhost/~/peer");
			return dataSource;
		}
		 @Bean
		    public ViewResolver viewResolver() {
			 System.out.println("rtyuuuuuuuuu");
		        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		        System.out.println("hello");
		        viewResolver.setViewClass(JstlView.class);
		        viewResolver.setPrefix("/WEB-INF/Views/");
		        viewResolver.setSuffix(".jsp");
		        return viewResolver;
		    }
		 @Bean(name="multipartResolver") 
		 public MultipartResolver getMultiResolver(){
			 CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver();
			 return multipartResolver;
		 }
		 
	}