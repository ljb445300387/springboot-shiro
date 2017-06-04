package com.test.ouyang;

import javax.servlet.ServletContext;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;
import org.springframework.session.web.http.HttpSessionStrategy;

@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 15)
public class HttpSessionConfig extends AbstractHttpSessionApplicationInitializer{

	@Bean
	public HttpSessionStrategy httpSessionStrategy() {
		CookieHttpSessionStrategy cookieHttpSessionStrategy = new CookieHttpSessionStrategy();
		cookieHttpSessionStrategy.setCookieName("sessionid");
		return cookieHttpSessionStrategy;
	}

	@Override
	protected void beforeSessionRepositoryFilter(ServletContext servletContext) {
		servletContext.addListener(new MyHttpSessionEventPublisher());;
	}

}