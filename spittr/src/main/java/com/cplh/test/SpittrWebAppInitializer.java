package com.cplh.test;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

//import org.springframework.security.access.SecurityConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.cplh.test.config.RootConfig;
import com.cplh.test.config.WebConfig;
import com.cplh.test.config.WebSecurityConfig;

public class SpittrWebAppInitializer extends
		AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] { RootConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { WebConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	@Override
	protected void customizeRegistration(ServletRegistration.Dynamic registration) {
		registration.setMultipartConfig(new MultipartConfigElement(
				"/tmp/spittr/uploads", 2097152, 4194304, 0));
	}
	
	@Override
	protected Filter[] getServletFilters(){
		return new Filter[]{};
	}
}
