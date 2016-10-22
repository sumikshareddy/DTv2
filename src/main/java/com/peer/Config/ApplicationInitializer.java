package com.peer.Config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[]{ApplicationConfiguration.class,ViewResolverConfiguration.class,MvcConfig.class};
	}
	@Override
	protected Class<?>[] getServletConfigClasses() {
		
		return null;
	}
	@Override
	protected String[] getServletMappings() {
		return  new String[]{"/"};
	}

}
