package com.test.ouyang.vo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;


@Data
public class SystemUser implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;

	private String name;

	private String mobilePhone;

	private String telPhone;

	private String gender;

	private String passwd;

	private String emailaddress;

	private Date birthday;

	private String isLocked;

	private String salt;

	private String passwordExpired;

	private String account;

	private String createBy;

	private String modifyBy;

	private Date createDate;

	private Date modifyDate;

}
