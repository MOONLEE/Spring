package com.mad.spring.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mad.spring.bean.User;

@Controller
public class ResisterController {
	private static final Logger logger = LoggerFactory.getLogger(ResisterController.class);
	
	
	@RequestMapping(value = "/resister.do", method = RequestMethod.GET)
	public String resister(Locale locale, Model model) {
		logger.info("Welcome resister");
		return "resister"; 
	}
	
	
	@RequestMapping(value = "/resister.do", method = RequestMethod.POST)
	public String resister(Locale locale,
			@ModelAttribute("User") User user, Model model) {
		logger.info(" resister process");
		
		if (!user.isOK()) {
			model.addAttribute("msg", "password error");
			return "resister";
		}
		
		userDAO.setUser(user);
		
		return "redirect:loginfinished.do";
	}
	
	@RequestMapping(value = "/loginfinished.do", method = RequestMethod.GET) 
	public String loginfinished(Model model) {
		
		return "loginfinished";
	}
	
}
