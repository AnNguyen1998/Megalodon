package com.web.demo.repository;
/**
 * @author NguyenHuuSon
 */

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.demo.entity.Users;

@Repository
public interface UsersRepositorySon extends JpaRepository<Users,Integer> {

	Users findByusernameUsers(String username);
	Optional<Users> findByUsernameUsers(String username);
	Optional<Users> findByEmailUsers(String emailUsers);
	

}
