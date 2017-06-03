package com.test.ouyang.configure;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.Filter;

import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.ServletContainerSessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.filter.DelegatingFilterProxy;

import com.test.ouyang.realm.ResourceCheckFilter;
import com.test.ouyang.realm.RetryLimitHashedCredentialsMatcher;
import com.test.ouyang.realm.UserRealm;

import lombok.Data;

/**
 * SHIRO核心配置信息
 * shiroFilter过滤器中新增拦截
 * */
@Data
@Configuration
@ConfigurationProperties(ignoreUnknownFields = false, prefix = "shiro.login")
@PropertySource("classpath:config/shiro.properties")
public class ShiroConfiguration {
	private Logger log_ = Logger.getLogger(ShiroConfiguration.class.getName());

	private String successUrl;
	private String loginUrl;
	private String unauthorizedUrl;
	private String cacheFilePath;
	private int errorTimes;
	private String hashAlgorithmName;
	private int hashIterations;

	/**
	 * http://www.cnblogs.com/ginponson/p/6217057.html
	 * 修复Spring Boot整合shiro出现UnavailableSecurityManagerException 问题
	 * 此处设置相当于在web.xml中增加filter
	 * */
	@Bean
	public FilterRegistrationBean delegatingFilterProxy() {
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		DelegatingFilterProxy proxy = new DelegatingFilterProxy();
		proxy.setTargetFilterLifecycle(true);
		proxy.setTargetBeanName("shiroFilter");
		filterRegistrationBean.setFilter(proxy);
		return filterRegistrationBean;
	}

	/**
	 * <property name="cacheManager" ref="cacheManager"/>
        <property name="sessionManager" ref="sessionManager"/>

        <property name="kickoutAfter" value="false"/>
        <property name="maxSession" value="2"/>
        <property name="kickoutUrl" value="/login?kickout=1"/>
	 * @return
	 */
	@Bean(name = "kickoutSessionControlFilter")
	public KickoutSessionControlFilter kickoutSessionControlFilter() {
		KickoutSessionControlFilter filter = new KickoutSessionControlFilter();
		filter.setCacheManager(cacheManager);
		filter.setSessionManager(sessionManager);
		filter.setMaxSession(1);
		
		return resourceCheckFilter;
	}
	
	@Bean(name = "resourceCheckFilter")
	public ResourceCheckFilter resourceCheckFilter() {
		ResourceCheckFilter resourceCheckFilter = new ResourceCheckFilter(unauthorizedUrl);
		return resourceCheckFilter;
	}

	//	SHIRO核心拦截器配置
	@Bean(name = "shiroFilter")
	public ShiroFilterFactoryBean shiroFilter(@Qualifier("securityManager") DefaultWebSecurityManager securityManager) {
		log_.info("successUrl:" + successUrl + "\t loginUrl:" + loginUrl + "\t unauthorizedUrl:" + unauthorizedUrl);
		ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
		bean.getFilters().put("kickout", value)
		bean.setSecurityManager(securityManager);
		bean.setSuccessUrl(successUrl);
		bean.setLoginUrl(loginUrl);
		bean.setUnauthorizedUrl(unauthorizedUrl);
		//配置访问权限
		LinkedHashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
		filterChainDefinitionMap.put("/adminView", "authc,resourceCheckFilter");
		filterChainDefinitionMap.put("/testView", "authc,resourceCheckFilter");
		filterChainDefinitionMap.put("/guestView", "authc,resourceCheckFilter");
		filterChainDefinitionMap.put("/static/**", "anon");
		filterChainDefinitionMap.put("/sayHello", "authc");
		filterChainDefinitionMap.put("/", "anon");
		bean.setFilterChainDefinitionMap(filterChainDefinitionMap);
		return bean;
	}

	/**
	 * 	<bean id="securityManager" class="org.apache.shiro.web.mgt.DefaultWebSecurityManager">
	<property name="sessionManager" ref="servletContainerSessionManager"/>
	<property name="realm" ref="dataBaseRealm"/>
	<property name="cacheManager" ref="cacheManager"/>
	</bean>
	 * @param userRealm
	 * @return
	 */
	@Bean
	ServletContainerSessionManager servletContainerSessionManager(){
		return new ServletContainerSessionManager();
	};

	//配置SHIRO核心安全事务管理器
	@Bean(name = "securityManager")
	public DefaultWebSecurityManager securityManager(@Qualifier("userRealm") UserRealm userRealm) {
		DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
		defaultWebSecurityManager.setRealm(userRealm);
		defaultWebSecurityManager.setSessionManager(servletContainerSessionManager());
		return defaultWebSecurityManager;
	}

	//配置自定义的权限登录器
	@Bean(name = "userRealm")
	public UserRealm userRealm(@Qualifier("credentialsMatcher") RetryLimitHashedCredentialsMatcher credentialsMatcher) {
		UserRealm userRealm = new UserRealm();
		userRealm.setCredentialsMatcher(credentialsMatcher);
		return userRealm;
	}

	//配置密码对比
	@Bean(name = "credentialsMatcher")
	public RetryLimitHashedCredentialsMatcher credentialsMatcher(
			@Qualifier("cacheManager") EhCacheManager cacheManager) {
		RetryLimitHashedCredentialsMatcher credentialsMatcher = new RetryLimitHashedCredentialsMatcher(cacheManager,
				errorTimes, hashAlgorithmName, hashIterations);
		return credentialsMatcher;
	}

	//配置缓存管理
	@Bean(name = "cacheManager")
	public EhCacheManager cacheManager() {
		EhCacheManager cacheManager = new EhCacheManager();
		cacheManager.setCacheManagerConfigFile(cacheFilePath);
		return cacheManager;
	}

	public static void main(String[] args) {
		Md5Hash md5Hash = new Md5Hash("admin", "9ed7248fb51285d294bad05395b762c2", 3);
		System.out.println(md5Hash);
	}
}
