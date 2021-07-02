package com.web.demo.service;
/**
 * @author NguyenHuuSon
 */
import java.util.Optional;

import com.web.demo.entity.Users;

public interface UsersServiceSon2 {

	<S extends Users> S save(S entity);

	Optional<Users> findByUsernameUsers(String username);

	Optional<Users> findByEmailUsers(String emailUsers);
	
}
