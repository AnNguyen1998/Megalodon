package com.web.demo.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.web.demo.entity.ImageData;
import com.web.demo.repository.ImageRepoAn;
@Service
public class ImageServiceImpAn implements ImageServiceAn {
	
	@Autowired
	ImageRepoAn image;
	
	@Override
	public void store(MultipartFile file) {
		Path path = Paths.get("images");
		try {
            Files.copy(file.getInputStream(), path.resolve(file.getOriginalFilename())
            		,StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
        	e.printStackTrace();
        }
	}

	@Override
	public <S extends ImageData> S save(S entity) {
		return image.save(entity);
	}
	
	

}