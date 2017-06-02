package com.test.ouyang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.ouyang.service.UserService;
import com.test.ouyang.vo.User;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
    @RequestMapping("/getUserInfo")
    @ResponseBody
	public User getUserInfo(){
        User user = userService.getUserInfo();
        if(user!=null){
            System.out.println("user.getName():"+user.getName());
        }
        return user;
	}
}
