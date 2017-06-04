
package com.test.ouyang.configure;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.web.context.support.WebApplicationContextUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Order(100)
@WebListener
public class MyHttpSessionEventPublisher implements HttpSessionListener {

	ApplicationContext getContext(ServletContext servletContext) {
		return WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
	}

	public void sessionCreated(HttpSessionEvent event) {
		log.info("httpSession create event");
		log.info("httpSession create event");
		log.info("httpSession create event");
		log.info("httpSession create event");
		log.info("httpSession create event");
		log.info("httpSession create event");
		log.info("httpSession create event");
		log.info("httpSession create event");
		log.info("httpSession create event");
	}

	public void sessionDestroyed(HttpSessionEvent event) {
		log.info("httpSession destroyed event");
		log.info("httpSession destroyed event");
		log.info("httpSession destroyed event");
		log.info("httpSession destroyed event");
		log.info("httpSession destroyed event");
		log.info("httpSession destroyed event");
		log.info("httpSession destroyed event");
		log.info("httpSession destroyed event");
		log.info("httpSession destroyed event");
	}
}
