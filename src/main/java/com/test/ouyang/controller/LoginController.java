package com.test.ouyang.controller;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.ouyang.service.UserService;
import com.test.ouyang.vo.SystemUser;

@SpringBootApplication
@Controller
public class LoginController {

	private static Logger log = Logger.getLogger(LoginController.class.getName());
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

	@RequestMapping("/login")
	@ResponseBody
	public String login(@RequestParam(value = "account") String account,
			@RequestParam(value = "password") String password) {
		Subject subject = SecurityUtils.getSubject();
		log.info("account:" + account + "\t password:" + password);
		String msg = "";
		if (!account.equals(subject.getPrincipal()) || !subject.isAuthenticated()) {
			UsernamePasswordToken token = new UsernamePasswordToken(account, password);
			try {
				subject.login(token);
				Session session = subject.getSession(false);
				SystemUser user = userService.checkUserByAccount(account);
				session.setAttribute("user", user);
				msg = "ok";
			} catch (UnknownAccountException uae) {
				log.erro
				//用户名不存在
				msg = "用户名不存在!";
			} catch (IncorrectCredentialsException ice) {
				//密码错误
				msg = "用户名或密码错误!";
			} catch (LockedAccountException lae) {
				//账户被锁定
				msg = "账户被锁定";
			} catch (ExcessiveAttemptsException eae) {
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
	}

	@RequestMapping("/unauthorizedUrl")
	public String unauthorized() {
		log.info("unauthorized....");
		return "unauthorizedUrl";
	}

	@RequestMapping("logout")
	public String logout() {
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		log.info("退出成功，已销毁用户信息，需要重新登录");
		return "/";
	}

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
