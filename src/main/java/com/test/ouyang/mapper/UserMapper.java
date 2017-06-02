package com.test.ouyang.mapper;

import java.util.List;
import java.util.Map;

import com.test.ouyang.vo.SystemUser;
import com.test.ouyang.vo.User;

public interface UserMapper {
	public User getUserInfo();
	
	public SystemUser checkUserByAccount(String account);
	
	/**
	 * 根据用户ID查询对应的权限信息
	 * */
	public List findPermissionByUserInfo(Map userInfo );
}
