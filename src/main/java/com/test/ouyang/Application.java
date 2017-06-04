package com.test.ouyang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

import com.test.ouyang.banner.MyBannner;

@EnableAutoConfiguration
@SpringBootApplication
@ServletComponentScan(basePackages={"com.test.ouyang.configure"})
public class Application {
	/**
	 * 服务启动
	 */
	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(Application.class);
		MyBannner bannner = new MyBannner();
		application.setBanner(bannner);
		application.run(args);
	}
}
