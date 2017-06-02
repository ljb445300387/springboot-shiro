package com.test.ouyang.util;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;

public class ShiroUtil {
	/**
	 * @param algorithmName spring 设置的加密方式MD5/SHA
	 * @param pwd 用户明文密码
	 * @param salt 加密的盐,对密码进行干扰,避免生成太简单的密文直接可用解密工具解密
	 * @param hashIterations 加密处理次数
	 * @return encodedPassword 用户明文密码加密后的密文。<br>
	 * 使用方法中传递过来的加密方式,密码,加密盐,加密次数生成特定的加密密码
	 * */
	public static String getPassword(String algorithmName, String pwd,String salt,int hashIterations){
		SimpleHash hash = new SimpleHash(algorithmName, pwd, salt, hashIterations);
		String encodedPassword = hash.toHex();
		return encodedPassword;
	}
	/**
	 * 此方法自动生成加密盐,在用户表中需要多保存本次生成的随机盐<br>
	 * @return randomSalt 生成的随机盐。
	 * */
	public static String getRandomSalt(){
		String randomSalt = new SecureRandomNumberGenerator().nextBytes().toHex();
		return randomSalt;
	}
	/**
	 * 检验用户密码
	 * */
	public static void main(String[] args) {
		String password = getPassword("MD5","password","89f30be46c571dd4f526af8a7518d030",3);
		System.out.println(password);
		if("16aeefd6b4e47866fd262c5191025702".equals(password)){
			System.out.println("password is right!");
		}
	}
}
