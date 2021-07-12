package com.web.demo.service;

import java.util.List;
import java.util.Optional;

import com.web.demo.entity.ImageData;

public interface GameImageServiceSon {

	List<ImageData> findAll();

	Optional<ImageData> findById(Integer id);

}
