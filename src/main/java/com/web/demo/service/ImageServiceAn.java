package com.web.demo.service;

import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import com.web.demo.entity.ImageData;

public interface ImageServiceAn {
	public void store(MultipartFile file);

	<S extends ImageData> S save(S entity);
}
