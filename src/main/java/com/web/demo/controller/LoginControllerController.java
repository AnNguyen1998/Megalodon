package com.web.demo.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.web.demo.config.WebUtils;
import com.web.demo.entity.Role;
import com.web.demo.entity.Users;
import com.web.demo.service.UserService;

@Controller
public class LoginControllerController {
	@Autowired
	UserService userservice;
	@Autowired
	private PasswordEncoder passwordEncoder;

	//Login
	@GetMapping("/shop")
	public String game(Model model,Principal principal ,@RequestParam(required = false) String message) {
		//Regis
		model.addAttribute("user",new Users());
		
		//
		if (message != null && !message.isEmpty()) {
	        if (message.equals("logout")) {
	          model.addAttribute("message", "Logout!");
	        }
	        if (message.equals("error")) {
	          model.addAttribute("message", "Login Failed!");
	        }
	      }
		System.out.println(message);
		if(principal != null) {
		User loginedUser = (User) ((Authentication) principal).getPrincipal();
		String userInfo=WebUtils.toString(loginedUser);
		model.addAttribute("userInfo", userInfo);
		}
		return "shop/shop-3";
	}
	
}

