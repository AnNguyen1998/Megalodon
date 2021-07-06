package com.web.demo.dto;

import com.web.demo.entity.GameCategoryId;

public class GameCategoryDtoAn {
	private GameCategoryId id;
	private CategoryDtoAn category;
	public GameCategoryId getId() {
		return id;
	}
	public void setId(GameCategoryId id) {
		this.id = id;
	}
	public CategoryDtoAn getCategory() {
		return category;
	}
	public void setCategory(CategoryDtoAn category) {
		this.category = category;
	}
}
