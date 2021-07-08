package com.web.demo.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.User;

import com.web.demo.entity.Users;

public interface UserServiceSon {

	<S extends Users> S save(S entity);

	

	Optional<Users> findByEmailUsers(String emailUsers);

	Users findByusernameUsers(String username);



	Optional<Users> findByUsernameUsers(String usernameUsers);



	<S extends Users> Users addUser(Users user, int roles);



	Users confirmEmail(Users user, Optional<Users> us);



	Users channgepass(Optional<Users> u,String pass);













}
