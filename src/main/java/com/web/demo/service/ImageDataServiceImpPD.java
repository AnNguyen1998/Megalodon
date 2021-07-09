package com.web.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.demo.entity.ImageData;
import com.web.demo.repository.ImageDataRepositoryPD;

/*
 * 
 * @author PhatDat
 */
@Service
public class ImageDataServiceImpPD implements ImageDataServicePD {
	@Autowired
	ImageDataRepositoryPD imageGameRepository;
	
	/*
	 * get a game image
	 * @author PhatDat
	 */
	@Override
	public ImageData getImageGame(int i) {
		
		return imageGameRepository.getById(i);
	}
	
	/*
	 * get list of the game images
	 * @author PhatDat
	 */
	@Override
	public List<ImageData> getImageList(){
		return imageGameRepository.findAll();
	}
	
	/*
	 * get a game's list of images
	 * @author PhatDat
	 */
	@Override
	public List<ImageData> getImageDetailGame(int id){
		return imageGameRepository.findImageGame(id);
	}

	/*
	 * get a game's list of images
	 * @author PhatDat
	 */
	@Override
	public List<ImageData> getRelatedImageList(int i) {
		return imageGameRepository.findRecommendGame(i);
	}
	
	
	
}
