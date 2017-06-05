
package com.test.ouyang;

import org.springframework.context.ApplicationListener;
import org.springframework.session.events.SessionDestroyedEvent;
import org.springframework.stereotype.Component;

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
