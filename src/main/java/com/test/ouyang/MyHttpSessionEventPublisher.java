
package com.test.ouyang;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.session.events.SessionDestroyedEvent;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;

import lombok.extern.slf4j.Slf4j;

@Component
public class MyHttpSessionEventPublisher implements ApplicationListener<SessionDestroyedEvent> {

	@Override
	public void onApplicationEvent(SessionDestroyedEvent event) {
		System.out.println("2");
		System.out.println("2");
		System.out.println("2");
		System.out.println("2");
		System.out.println("2");
		System.out.println("2");
		System.out.println("2");
		System.out.println("2");
		System.out.println("2");
		System.out.println("2");
		System.out.println("2");
		System.out.println("2");
		System.out.println("2");
		System.out.println("2");
		System.out.println("2");
		System.out.println("2");
	}
}
