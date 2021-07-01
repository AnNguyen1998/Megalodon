package com.web.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.demo.entity.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users,Integer> {

	Users findByusernameUsers(String username);

	

}
