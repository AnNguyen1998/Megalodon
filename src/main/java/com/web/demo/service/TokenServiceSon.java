package com.web.demo.service;
/**
 * @author NguyenHuuSon
 */


import com.web.demo.entity.TokenUser;


public interface TokenServiceSon {

	TokenUser findByValueTokenUsers(String valueTokenUsers);

	<S extends TokenUser> S save(S entity);


	
}
