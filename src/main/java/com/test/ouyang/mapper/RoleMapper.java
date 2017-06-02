package com.test.ouyang.mapper;

import java.util.List;
import java.util.Map;

public interface RoleMapper {
	
	/**
	 * 根据用户ID查询拥有的角色信息列表
	 * */
	public List findRolesByUserInfo(Map userInfo);
}
