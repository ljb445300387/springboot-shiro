package com.test.ouyang.realm;

import java.io.Serializable;

import org.apache.shiro.util.SimpleByteSource;
/**
 * http://blog.csdn.net/poolokok/article/details/44009721
 */
public class MySimpleByteSource extends SimpleByteSource implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MySimpleByteSource(byte[] bytes) {
		super(bytes);
	}
}
