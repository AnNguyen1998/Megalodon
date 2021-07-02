package com.web.demo.service;

import java.util.Optional;

import com.web.demo.entity.Users;

public interface UserServiceSon {

	Optional<Users> findByUsernameUsers(String usernameUsers);

	Optional<Users> findByEmailUsers(String emailUsers);

	void save(Users user);

}
