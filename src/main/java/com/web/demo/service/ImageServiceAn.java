package com.web.demo.service;
/**
 * @author AnNguyen
 */
import org.springframework.web.multipart.MultipartFile;

import com.web.demo.entity.ImageData;

public interface ImageServiceAn {
	public void store(MultipartFile file);

	<S extends ImageData> S save(S entity);

	void deleteById(Integer id);

	ImageData getById(Integer id);
}
