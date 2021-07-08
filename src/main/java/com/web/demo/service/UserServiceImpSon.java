package com.web.demo.service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.web.demo.entity.Role;
import com.web.demo.entity.TokenUser;
import com.web.demo.entity.Users;
import com.web.demo.repository.TokenRepositorySon;
import com.web.demo.repository.UsersRepositorySon;

import antlr.Token;

@Service
public class UserServiceImpSon implements UserServiceSon {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	TokenRepositorySon tokenrepository;

	@Autowired
	UsersRepositorySon usersRepository;
	@Autowired
	public JavaMailSender emailSender;

	@Override
	public Optional<Users> findByUsernameUsers(String usernameUsers) {
		return usersRepository.findByUsernameUsers(usernameUsers);
	}

	@Override
	public Users findByusernameUsers(String username) {
		return usersRepository.findByusernameUsers(username);
	}

	@Override
	public <S extends Users> S save(S entity) {
		return usersRepository.save(entity);
	}

	@Override
	public Optional<Users> findByEmailUsers(String emailUsers) {
		// TODO Auto-generated method stub
		return usersRepository.findByEmailUsers(emailUsers);
	}

	
	@Override
	public Users addUser(Users user, int roles) {
		Role role = new Role();
		role.setIdRole(roles);
		user.setRole(role);
		user.setPasswordUsers(passwordEncoder.encode(user.getPasswordUsers()));
		Users u= usersRepository.save(user);
		TokenUser token = new TokenUser(u);
		tokenrepository.save(token);
		return user;

	}
	
	@Override
	public Users confirmEmail(Users user,Optional<Users> us) {
		TokenUser tokenuser=tokenrepository.findByUsers(us);
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(user.getEmailUsers());
		message.setSubject("Fogot Password");
		message.setText("Hi, we confirm you forgot your password, please click this link:  "
				+ "http://localhost:8080/confirm-reset?token=" + tokenuser.getValueTokenUsers());
		this.emailSender.send(message);
		
		
		return user;
		
	}
	
	@Override
	public Users channgepass(Optional<Users> u,String pass) {
		u.get().setPasswordUsers(passwordEncoder.encode(pass));
		Users user= usersRepository.save(u.get());
		TokenUser token =tokenrepository.findByUsers(user);
		token.setValueTokenUsers(UUID.randomUUID().toString());
		tokenrepository.save(token);
		return user;
	}
}
