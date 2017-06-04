package com.test.ouyang;

import javax.servlet.ServletContext;

import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;

import com.test.ouyang.configure.MyHttpSessionEventPublisher;

public class SessionApplicationInitializer extends AbstractHttpSessionApplicationInitializer {
	@Override
	protected void afterSessionRepositoryFilter(ServletContext servletContext) {
		servletContext.addListener(new MyHttpSessionEventPublisher());
	}
	
}