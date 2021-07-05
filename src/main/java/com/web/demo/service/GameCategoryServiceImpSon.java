package com.web.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.demo.entity.GameCategory;
import com.web.demo.repository.GameCategoryRepositorySon;

@Service
public class GameCategoryServiceImpSon implements GameCategoryServiceSon{
@Override
public <S extends Integer> S save(S entity) {
		return gamecate.save(entity);
	}

	@Override
	public List<Integer> findAll() {
		return gamecate.findAll();
	}

	@Override
	public Optional<Integer> findById(GameCategory id) {
		return gamecate.findById(id);
	}

	@Override
	public Integer getById(GameCategory id) {
		return gamecate.getById(id);
	}

@Autowired
GameCategoryRepositorySon gamecate;

}
