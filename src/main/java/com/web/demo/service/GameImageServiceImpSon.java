package com.web.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.demo.entity.ImageData;
import com.web.demo.repository.GameImageRepository;

@Service
public class GameImageServiceImpSon implements GameImageServiceSon{
@Override
public Optional<ImageData> findById(Integer id) {
		return gameimage.findById(id);
	}

@Override
public List<ImageData> findAll() {
		return gameimage.findAll();
	}

@Autowired
GameImageRepository gameimage;


}
