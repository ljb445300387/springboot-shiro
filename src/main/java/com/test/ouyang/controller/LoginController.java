package com.test.ouyang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.ouyang.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LoginController {

	@Autowired
	UserService userService;

	@RequestMapping("/sayHello")
	public String sayHello(@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
		return "hello";
	}

	@RequestMapping("/")
	public String indexPage() {
		log.info("indexPage invoke ....");
		return "index";
	}

	/*@RequestMapping("/login")
	@ResponseBody
	public String login(//
			@RequestParam(value = "username") String username, //
			@RequestParam(value = "password") String password) {
	
		Subject subject = SecurityUtils.getSubject();
		String msg = "";
		if (!username.equals(subject.getPrincipal()) || !subject.isAuthenticated()) {
			UsernamePasswordToken token = new UsernamePasswordToken(username, password);
			try {
				Session session1 = subject.getSession(false);
				if (session1 != null) {
					return "不能重复登录";
				}
				
				subject.login(token);
				Session session = subject.getSession(false);
				SystemUser user = userService.getUserInfo(username);
				session.setAttribute("user", user);
				msg = "ok";
			} catch (UnknownAccountException e) {
				log.error("", e);
				//用户名不存在
				msg = "用户名不存在!";
			} catch (IncorrectCredentialsException e) {
				log.error("", e);
				//密码错误
				msg = "用户名或密码错误!";
			} catch (LockedAccountException e) {
				//账户被锁定
				msg = "账户被锁定";
			} catch (ExcessiveAttemptsException e) {
				//登录失败次数超过系统最大次数,请稍后重试
				msg = "登录失败次数超过系统最大次数,请稍后重试!";
			} catch (Exception e) {
				e.printStackTrace();
				//出现其他异常
				msg = "登录异常";
			}
			log.info("msg:" + msg);
		}
		return msg;
	}*/

	@RequestMapping("/unauthorizedUrl")
	public String unauthorized() {
		log.info("unauthorized....");
		return "unauthorizedUrl";
	}

	/*	@RequestMapping("logout")
		public @ResponseBody String logout() {
			Subject subject = SecurityUtils.getSubject();
			subject.logout();
			log.info("退出成功，已销毁用户信息，需要重新登录");
			return "/";
		}*/

	@RequestMapping("/adminView")
	public String adminView() {
		log.info("adminView...");
		return "page/adminView";
	}

	@RequestMapping("/testView")
	public String testView() {
		log.info("testView...");
		return "page/testView";
	}

	@RequestMapping("/guestView")
	public String guestView() {
		log.info("guestView...");
		return "page/guestView";
	}
}
