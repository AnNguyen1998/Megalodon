package com.web.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.demo.entity.Category;
@Repository
public interface CategoryRepositorySon extends JpaRepository<Integer, Category>{

}
