package com.web.demo.service;

import java.util.List;
import java.util.Optional;

import com.web.demo.entity.GameCategory;

public interface GameCategoryServiceSon {

	Integer getById(GameCategory id);

	Optional<Integer> findById(GameCategory id);

	List<Integer> findAll();

	<S extends Integer> S save(S entity);

}
