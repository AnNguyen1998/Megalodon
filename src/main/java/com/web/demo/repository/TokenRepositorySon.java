package com.web.demo.repository;
/**
 * @author NguyenHuuSon
 */



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.demo.entity.TokenUser;



@Repository
public interface TokenRepositorySon extends JpaRepository<TokenUser, String> {

	TokenUser findByValueTokenUsers(String valueTokenUsers);
  
}
