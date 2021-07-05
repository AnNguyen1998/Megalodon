package com.web.demo.service;

import java.util.List;
import java.util.Optional;

import com.web.demo.entity.Category;

public interface CategoryServiceSon {

	Optional<Integer> findById(Category id);

	List<Integer> findAllById(Iterable<Category> ids);

	<S extends Integer> S save(S entity);

}
