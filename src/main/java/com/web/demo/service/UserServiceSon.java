package com.web.demo.service;

import java.util.Optional;

import com.web.demo.entity.Users;

public interface UserServiceSon {

	<S extends Users> S save(S entity);

	Optional<Users> findByUsernameUsers(String username);

	Optional<Users> findByEmailUsers(String emailUsers);
	
}
