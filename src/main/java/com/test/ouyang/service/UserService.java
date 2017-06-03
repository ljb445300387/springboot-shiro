package com.test.ouyang.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.ouyang.mapper.UserMapper;
import com.test.ouyang.vo.SystemUser;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;

	@PostConstruct
	public void init() {
		SystemUser s = new SystemUser();
		s.setAccount("ljb");
		s.setName("ljb");
		s.setPasswd("b116e1f8b82ba5091cc277023393d702");
		s.setSalt("9ed7248fb51285d294bad05395b762c2");
		userMapper.save(s);
	}

	public SystemUser getUserInfo(String username) {
		return userMapper.findOneByname(username);
	}

}
