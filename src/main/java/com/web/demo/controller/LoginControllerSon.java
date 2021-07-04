package com.web.demo.controller;

/**
 * @author NguyenHuuSon
 */
import java.security.Principal;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
	@Autowired
	public JavaMailSender emailSender;

	// Login
	@GetMapping("/shop")
	public String game(Model model, Principal principal, @RequestParam(required = false) String message, Users user) {
		// Regis
		model.addAttribute("user", user);

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
			@RequestParam(required = false) String pre_password) {
		Optional<Users> userbyusername = userservice.findByUsernameUsers(user.getUsernameUsers());
		Optional<Users> userbyemail = userservice.findByEmailUsers(user.getEmailUsers());

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
			TokenUser token = new TokenUser(user);

			tokenservice.save(token);
			model.addAttribute(user);
			return "redirect:/shop";
		}
	}

	@PostMapping("/forgot")
	public String forgot(Model model, @ModelAttribute("user") Users user) {
		Optional<Users> userbyemail = userservice.findByEmailUsers(user.getEmailUsers());

		if (userbyemail.isPresent()) {
			TokenUser tokenuser = tokenservice.findByUsers(userbyemail);
			tokenuser.setValueTokenUsers(UUID.randomUUID().toString());
			tokenservice.save(tokenuser);
			//
			SimpleMailMessage message = new SimpleMailMessage();
			message.setTo(user.getEmailUsers());
			message.setSubject("Fogot Password");
			message.setText("Hi, we confirm you forgot your password, please click this link:  "
					+ "http://localhost:8080/confirm-reset?token=" + tokenuser.getValueTokenUsers());
			this.emailSender.send(message);
			model.addAttribute("message3", "Please check your email");
			model.addAttribute("user", user);
			return "shop/shop-3";
		} else {
			model.addAttribute("message3", "Email not exist");
			model.addAttribute("user", user);
			return "shop/shop-3";

		}

	}

	@GetMapping("/confirm-reset")
	public String confirm(@RequestParam("token") String token, Model model, Users user,@RequestParam(required = false)String mess) {

		TokenUser tokenuser = tokenservice.findByValueTokenUsers(token);
		if (mess != null && !mess.isEmpty()) {
			if (mess.equals("P")) {
				model.addAttribute("mess", "Password not match");
			}
		}
		if (tokenuser != null) {
			Optional<Users> users = userservice.findByEmailUsers(tokenuser.getUsers().getEmailUsers());
			model.addAttribute("user", users);
			model.addAttribute("token", token);
			return "shop/confirmPassword";
		} else {
			
			model.addAttribute("messageError", " The link is invalid or broken!");
			return "shop/error-confirm";
		}

	}

	@PostMapping("/change-password")
	public String change(@RequestParam("token") String token, @RequestParam("prepassword") String prepass,
			@RequestParam("password") String pass, Model model,@ModelAttribute("user")Users user) {
		TokenUser tokenuser = tokenservice.findByValueTokenUsers(token);
		String linktoken = tokenuser.getValueTokenUsers();
		Optional<Users> users = userservice.findByEmailUsers(tokenuser.getUsers().getEmailUsers());
		if (!pass.equalsIgnoreCase(prepass)) {
			model.addAttribute("mes", "Password not match");
			return "redirect:/confirm-reset?token=" + linktoken+"&mess=P";
		} else {
			users.get().setPasswordUsers(passwordEncoder.encode(pass));
			userservice.save(users.get());
			return "redirect:/shop";
		}

	}

}
