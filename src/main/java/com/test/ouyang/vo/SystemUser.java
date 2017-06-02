package com.test.ouyang.vo;

import java.util.Date;

public class SystemUser {
	private String id ;
	
	private String name ;
	
	private String mobilePhone ;
	
	private String telPhone ; 
	
	private String gender ;
	
	private String passwd ;
	
	private String emailaddress ;
	
	private Date birthday ;
	
	private String isLocked ;
	
	private String salt ;
	
	private String passwordExpired ;
	
	private String account ;
	
	private String createBy ;
	
	private String modifyBy ;
	
	private Date createDate;
	
	private Date modifyDate ;
	
	public SystemUser() {
	}
	
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getMobilePhone() {
		return mobilePhone;
	}


	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}


	public String getTelPhone() {
		return telPhone;
	}


	public void setTelPhone(String telPhone) {
		this.telPhone = telPhone;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getPasswd() {
		return passwd;
	}


	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}


	public String getEmailaddress() {
		return emailaddress;
	}


	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}


	public Date getBirthday() {
		return birthday;
	}


	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}


	public String getIsLocked() {
		return isLocked;
	}


	public void setIsLocked(String isLocked) {
		this.isLocked = isLocked;
	}


	public String getSalt() {
		return salt;
	}


	public void setSalt(String salt) {
		this.salt = salt;
	}


	public String getPasswordExpired() {
		return passwordExpired;
	}


	public void setPasswordExpired(String passwordExpired) {
		this.passwordExpired = passwordExpired;
	}


	public String getAccount() {
		return account;
	}


	public void setAccount(String account) {
		this.account = account;
	}


	public String getCreateBy() {
		return createBy;
	}


	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}


	public String getModifyBy() {
		return modifyBy;
	}


	public void setModifyBy(String modifyBy) {
		this.modifyBy = modifyBy;
	}


	public Date getCreateDate() {
		return createDate;
	}


	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}


	public Date getModifyDate() {
		return modifyDate;
	}


	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

}
