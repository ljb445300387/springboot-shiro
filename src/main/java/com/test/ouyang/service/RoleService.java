package com.test.ouyang.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.ouyang.mapper.RoleMapper;
@Service
public class RoleService implements RoleMapper {
	
	@Autowired
	RoleMapper roleMapper ;
	
	/**
	 * 根据用户ID查询拥有的角色信息列表
	 * */
	public List findRolesByUserInfo(Map userInfo) {
		return roleMapper.findRolesByUserInfo(userInfo);
	}

}
