package com.web.demo.controller;
/**
 * @author NguyenHuuSon
 */
import java.security.Principal;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RequestParam;

import com.web.demo.config.WebUtils;
import com.web.demo.entity.Role;
import com.web.demo.entity.TokenUser;
import com.web.demo.entity.Users;
import com.web.demo.service.TokenServiceSon;
import com.web.demo.service.UserServiceSon;


@Controller
public class LoginControllerSon {
	@Autowired
	UserServiceSon userservice;
	@Autowired
	TokenServiceSon tokenservice;
	@Autowired
	private PasswordEncoder passwordEncoder;

	// Login
	@GetMapping("/shop")
	public String game(Model model, Principal principal, @RequestParam(required = false) String message) {
		// Regis
		model.addAttribute("user", new Users());

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
		if (principal != null) {
			User loginedUser = (User) ((Authentication) principal).getPrincipal();
			String userInfo = WebUtils.toString(loginedUser);
			model.addAttribute("userInfo", userInfo);
		}
		return "shop/shop-3";
	}

	

	@PostMapping("/regis")
	public String savecustomer(@Validated @ModelAttribute("user") Users user, ModelMap model,
			@RequestParam(required = false) String pre_password, BindingResult rs) {
		Optional<Users> userbyusername = userservice.findByUsernameUsers(user.getUsernameUsers());
		Optional<Users> userbyemail = userservice.findByEmailUsers(user.getEmailUsers());
		if(rs.hasErrors()) {
			model.addAttribute("user",user);
			return "shop/shop-3";
		}
		if (userbyusername.isPresent()) {
			model.addAttribute("message2", "Username already exists");
			return "shop/shop-3";
		}
		if (userbyemail.isPresent()) {
			model.addAttribute("message2", "Email already exists");
			return "shop/shop-3";
		}
		if (!pre_password.equalsIgnoreCase(user.getPasswordUsers())) {
			model.addAttribute("message2", "Password not match");
			return "shop/shop-3";
		} else {
			Role role = new Role();
			role.setIdRole(3);
			user.setRole(role);
			user.setPasswordUsers(passwordEncoder.encode(user.getPasswordUsers()));
			
			
			userservice.save(user);
			TokenUser token=new TokenUser(user);
			tokenservice.save(token);
			model.addAttribute(user);
			return "redirect:/shop";
		}
	}
	
	
}
