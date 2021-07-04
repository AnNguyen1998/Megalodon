package com.web.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.demo.entity.SlideShow;

public interface SlideShowService {

	List<SlideShow> findAll();

	<S extends SlideShow> S save(S entity);

	Optional<SlideShow> findById(Integer id);

}
