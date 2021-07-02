package com.web.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.demo.entity.Users;
import com.web.demo.repository.UsersRepository;

@Service
public class UserServiceImp implements UserService {
	
	
	
 @Override
public Users findByusernameUsers(String username) {
		return usersRepository.findByusernameUsers(username);
	}
@Override
public <S extends Users> S save(S entity) {
		return usersRepository.save(entity);
	}

@Autowired
UsersRepository usersRepository;



@Override
public Optional<Users> findByEmailUsers(String emailUsers) {
	// TODO Auto-generated method stub
	return usersRepository.findByEmailUsers(emailUsers);
}

}
