package com.test.ouyang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.ouyang.service.UserService;
import com.test.ouyang.vo.SystemUser;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping("/getUserInfo")
	@ResponseBody
	public SystemUser getUserInfo(String username) {
		SystemUser user = userService.getUserInfo(username);
		if (user != null) {
			System.out.println("user.getName():" + user.getName());
		}
		return user;
	}
}
