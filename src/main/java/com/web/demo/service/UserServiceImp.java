package com.web.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.demo.entity.Users;
import com.web.demo.repository.UsersRepository;

@Service
public class UserServiceImp implements UserService {
	
	
	
 @Override
public <S extends Users> S save(S entity) {
		return usersRepository.save(entity);
	}

@Autowired
UsersRepository usersRepository;

}
