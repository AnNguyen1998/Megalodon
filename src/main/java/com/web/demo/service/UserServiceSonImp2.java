package com.web.demo.service;
/**
 * @author NguyenHuuSon
 */
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.demo.entity.Users;
import com.web.demo.repository.UsersRepositorySon;

@Service
public class UserServiceSonImp2 implements UserServiceSon {
	
	
	
 @Override
public <S extends Users> S save(S entity) {
		return usersRepository.save(entity);
	}

@Autowired
UsersRepositorySon usersRepository;

@Override
public Optional<Users> findByUsernameUsers(String username) {
	// TODO Auto-generated method stub
	return usersRepository.findByUsernameUsers(username);
}

@Override
public Optional<Users> findByEmailUsers(String emailUsers) {
	// TODO Auto-generated method stub
	return usersRepository.findByEmailUsers(emailUsers);
}

}
