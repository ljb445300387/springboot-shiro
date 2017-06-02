package com.test.ouyang.realm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import com.test.ouyang.service.RoleService;
import com.test.ouyang.service.UserService;
import com.test.ouyang.util.COMMON;
import com.test.ouyang.vo.SystemUser;

public class UserRealm extends AuthorizingRealm {

	private Logger log_ = Logger.getLogger(UserRealm.class.getName());

	@Autowired
	UserService userService;
	@Autowired
	RoleService roleService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		Subject subject = SecurityUtils.getSubject();
		String key = "AUTHORIZATION_INFO";
		Session session = subject.getSession(false);
		if (COMMON.isEmpty(session)) {
			session = subject.getSession();
		}
		SimpleAuthorizationInfo authorizationInfo = (SimpleAuthorizationInfo) session.getAttribute(key);
		if (!subject.isAuthenticated() || COMMON.isEmpty(authorizationInfo)) {
			String username = (String) principals.getPrimaryPrincipal();
			log_.info("username:" + username);
			SystemUser user = userService.checkUserByAccount(username);
			if (!COMMON.isEmpty(user)) {
				Map userInfo = new HashMap();
				String userId = user.getId();
				log_.info("userId:" + userId);
				userInfo.put("userId", userId);
				userInfo.put("isWork", "Y");
				List roles = roleService.findRolesByUserInfo(userInfo);
				if (!COMMON.isEmpty(roles)) {
					//添加该用户对应的角色信息
					authorizationInfo = new SimpleAuthorizationInfo();
					authorizationInfo.addRoles(roles);
					List permissions = userService.findPermissionByUserInfo(userInfo);
					authorizationInfo.addStringPermissions(permissions);
				}
			} else {
				log_.info("用户不存在...");
				return null;
			}
		}
		return authorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		String account = upToken.getUsername();
		SystemUser user = null;
		try {
			user = userService.checkUserByAccount(account);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (COMMON.isEmpty(user)) {
			throw new UnknownAccountException();
		} else {
			String isLock = user.getIsLocked();
			if (!COMMON.isEmpty(isLock) && "Y".equals(isLock)) {
				//账户被锁定
				throw new LockedAccountException();
			}
			//获取随机盐
			String salt = user.getSalt();
			account = user.getAccount();
			String pwd = user.getPasswd();
			log_.info("account:" + account + "\t pwd:" + pwd + "\t salt:" + salt);
			SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(account, pwd, getClass().getName());
			return info;
		}
	}

}
