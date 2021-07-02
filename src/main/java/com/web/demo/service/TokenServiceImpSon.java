package com.web.demo.service;
/**
 * @author NguyenHuuSon
 */
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.web.demo.entity.TokenUser;
import com.web.demo.repository.TokenRepositorySon;


public class TokenServiceImpSon implements TokenServiceSon{
	
	

	@Override
	public <S extends TokenUser> S save(S entity) {
		return confirmtoken.save(entity);
	}
	@Override
	public TokenUser findByValueTokenUsers(String valueTokenUsers) {
		return confirmtoken.findByValueTokenUsers(valueTokenUsers);
	}
	@Autowired
	TokenRepositorySon confirmtoken;
	
	
	
}
