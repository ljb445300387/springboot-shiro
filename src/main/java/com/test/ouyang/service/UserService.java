package com.test.ouyang.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.ouyang.mapper.UserMapper;
import com.test.ouyang.vo.SystemUser;
import com.test.ouyang.vo.User;

@Service
public class UserService implements UserMapper{
	
	@Autowired
	private UserMapper userMapper;
	
	public User getUserInfo() {
		return userMapper.getUserInfo();
	}

	public SystemUser checkUserByAccount(String account) {
		return userMapper.checkUserByAccount(account);
	}

	public List findPermissionByUserInfo(Map userInfo) {
		return userMapper.findPermissionByUserInfo(userInfo);
	}

}
