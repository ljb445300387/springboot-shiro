package com.test.ouyang.realm;

import java.util.logging.Logger;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.test.ouyang.service.UserService;
import com.test.ouyang.util.COMMON;
import com.test.ouyang.vo.SystemUser;

public class UserRealm extends AuthorizingRealm {

	private Logger log_ = Logger.getLogger(UserRealm.class.getName());

	@Autowired
	UserService userService;

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		String account = upToken.getUsername();
		SystemUser user = userService.getUserInfo(account);
		if (COMMON.isEmpty(user)) {
			throw new UnknownAccountException();
		} else {
			//获取随机盐
			String salt = user.getSalt();
			account = user.getAccount();
			String pwd = user.getPasswd();
			log_.info("account:" + account + "\t pwd:" + pwd + "\t salt:" + salt);
			return new SimpleAuthenticationInfo(account, pwd, getClass().getName());
		}
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		return null;
	}

}
