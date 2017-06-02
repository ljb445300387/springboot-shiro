package com.test.ouyang.vo;

import java.util.Date;

public class SystemRole {
	private String id;
	
	private String roleName ;
	
	private String roleNumber ;
	
	private String createBy;
	
	private String modifyBy ;
	
	private Date createDate ;
	
	private Date modifyDate ;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleNumber() {
		return roleNumber;
	}

	public void setRoleNumber(String roleNumber) {
		this.roleNumber = roleNumber;
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
	
	public SystemRole() {
	}
}
