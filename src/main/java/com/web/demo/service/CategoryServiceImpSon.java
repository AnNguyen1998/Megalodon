package com.web.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.demo.entity.Category;
import com.web.demo.repository.CategoryRepositorySon;

@Service
public class CategoryServiceImpSon implements CategoryServiceSon{

	@Override
	public <S extends Integer> S save(S entity) {
		return cate.save(entity);
	}

	@Override
	public List<Integer> findAllById(Iterable<Category> ids) {
		return cate.findAllById(ids);
	}

	@Override
	public Optional<Integer> findById(Category id) {
		return cate.findById(id);
	}

	@Autowired
	CategoryRepositorySon cate;
	
	
}
