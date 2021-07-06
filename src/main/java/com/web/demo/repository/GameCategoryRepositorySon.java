package com.web.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.demo.entity.Category;
import com.web.demo.entity.GameCategory;
import com.web.demo.entity.Games;




@Repository
public interface GameCategoryRepositorySon extends JpaRepository<GameCategory, Integer>{
	List<GameCategory> findByGames(Games games);
}
