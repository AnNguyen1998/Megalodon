package com.web.demo.dto;

import org.springframework.web.multipart.MultipartFile;

import com.web.demo.entity.Games;

public class ImageDataMultiAn implements java.io.Serializable {
	private Integer idImage;
	private Games games;
	private MultipartFile nameImage;
	
	public ImageDataMultiAn() {
	}
	public Integer getIdImage() {
		return idImage;
	}
	public void setIdImage(Integer idImage) {
		this.idImage = idImage;
	}
	public Games getGames() {
		return games;
	}
	public void setGames(Games games) {
		this.games = games;
	}
	public MultipartFile getNameImage() {
		return nameImage;
	}
	public void setNameImage(MultipartFile nameImage) {
		this.nameImage = nameImage;
	}
}
