package com.test.ouyang;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.CookieHttpSessionStrategy;
import org.springframework.session.web.http.HttpSessionStrategy;

@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 180000)
public class HttpSessionConfig {

	@Bean
	public HttpSessionStrategy httpSessionStrategy() {
		CookieHttpSessionStrategy cookieHttpSessionStrategy = new CookieHttpSessionStrategy();
		cookieHttpSessionStrategy.setCookieName("sessionid");
		return cookieHttpSessionStrategy;
	}
	
}