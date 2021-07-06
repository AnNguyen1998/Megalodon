package com.web.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.demo.entity.Category;
import com.web.demo.entity.GameCategory;
import com.web.demo.entity.Games;
import com.web.demo.repository.GameCategoryRepositorySon;

@Service
public class GameCategoryServiceImpSon  implements GameCategortyServiceSon{
@Override
public List<GameCategory> findByGames(Games games) {
		return gamecate.findByGames(games);
	}

@Autowired
GameCategoryRepositorySon gamecate;

}
