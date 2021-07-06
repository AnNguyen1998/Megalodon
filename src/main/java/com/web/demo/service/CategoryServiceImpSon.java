package com.web.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.demo.entity.Category;
import com.web.demo.repository.CategoryRepositorySon;

@Service
public class CategoryServiceImpSon  implements CategortyServiceSon{
	@Override
	public List<Category> findAll() {
		return cate.findAll();
	}

	@Autowired
	CategoryRepositorySon cate;
	
}
