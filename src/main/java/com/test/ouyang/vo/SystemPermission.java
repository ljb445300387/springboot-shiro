package com.test.ouyang.vo;

import java.util.Date;

public class SystemPermission {
	private String id;
	
	private String permissionName ;
	
	private String permissionNumber ;
	
	private String description ;
	
	private String permissionEnable ;
	
	private String createBy ;
	
	private String modifyBy ;
	
	private Date createDate ;
	
	private Date modifyDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPermissionName() {
		return permissionName;
	}

	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}

	public String getPermissionNumber() {
		return permissionNumber;
	}

	public void setPermissionNumber(String permissionNumber) {
		this.permissionNumber = permissionNumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPermissionEnable() {
		return permissionEnable;
	}

	public void setPermissionEnable(String permissionEnable) {
		this.permissionEnable = permissionEnable;
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
	
	public SystemPermission() {
	}
}
