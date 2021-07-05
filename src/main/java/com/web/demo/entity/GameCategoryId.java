package com.web.demo.entity;
// Generated Jul 5, 2021, 11:28:02 AM by Hibernate Tools 5.0.6.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * GameCategoryId generated by hbm2java
 */
@Embeddable
public class GameCategoryId implements java.io.Serializable {

	private int idGame;
	private int idCategory;

	public GameCategoryId() {
	}

	public GameCategoryId(int idGame, int idCategory) {
		this.idGame = idGame;
		this.idCategory = idCategory;
	}

	@Column(name = "Id_game", nullable = false)
	public int getIdGame() {
		return this.idGame;
	}

	public void setIdGame(int idGame) {
		this.idGame = idGame;
	}

	@Column(name = "Id_category", nullable = false)
	public int getIdCategory() {
		return this.idCategory;
	}

	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof GameCategoryId))
			return false;
		GameCategoryId castOther = (GameCategoryId) other;

		return (this.getIdGame() == castOther.getIdGame()) && (this.getIdCategory() == castOther.getIdCategory());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getIdGame();
		result = 37 * result + this.getIdCategory();
		return result;
	}

}
