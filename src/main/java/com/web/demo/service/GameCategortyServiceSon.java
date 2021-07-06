package com.web.demo.service;

import java.util.List;

import com.web.demo.entity.Category;
import com.web.demo.entity.GameCategory;
import com.web.demo.entity.Games;

public interface GameCategortyServiceSon {

	List<GameCategory> findByGames(Games games);

}
