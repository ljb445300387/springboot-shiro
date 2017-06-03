package com.test.ouyang.mapper;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.test.ouyang.vo.SystemUser;

public interface UserMapper extends MongoRepository<SystemUser, String> {
	public SystemUser findOneByname(String username);
}
