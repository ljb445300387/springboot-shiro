package com.test.ouyang.configure;


import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
@Configuration
public class ErrorPageConfiguration {
	
	@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer(){
		return  new EmbeddedServletContainerCustomizer(){
			public void customize(ConfigurableEmbeddedServletContainer container) {
				ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/error/errorPageFor404.html");
				container.addErrorPages(error404Page);
			}
			
		};
	} 
}
