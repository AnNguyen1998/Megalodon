package com.web.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.web.demo.entity.GameCategory;


@Repository
public interface GameCategoryRepositorySon extends JpaRepository<Integer, GameCategory>{
	
}
