package com.web.demo.service;

import java.util.List;
import java.util.Optional;



import com.web.demo.entity.Games;



public interface GamesServiceSon {

	

	<S extends Games> S save(S entity);

	Optional<Games> findById(Integer id);


	List<Games> findAll();

	

	

}
