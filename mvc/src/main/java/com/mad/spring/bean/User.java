package com.mad.spring.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class User {
	private static final Logger logger = LoggerFactory.getLogger(User.class);
	private String id = null;
	private String password = null;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean isOK() {
		logger.info(id + " -  "  + password);
	 return ("1".equals(id) && "1".equals(password)) ? true : false;
	}
}
