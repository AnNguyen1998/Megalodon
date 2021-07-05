package com.web.demo.entity;
// Generated Jul 5, 2021, 11:28:02 AM by Hibernate Tools 5.0.6.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ActiveGameId generated by hbm2java
 */
@Embeddable
public class ActiveGameId implements java.io.Serializable {

	private int idUsers;
	private int idGame;
	private Integer status;

	public ActiveGameId() {
	}

	public ActiveGameId(int idUsers, int idGame) {
		this.idUsers = idUsers;
		this.idGame = idGame;
	}

	public ActiveGameId(int idUsers, int idGame, Integer status) {
		this.idUsers = idUsers;
		this.idGame = idGame;
		this.status = status;
	}

	@Column(name = "Id_users", nullable = false)
	public int getIdUsers() {
		return this.idUsers;
	}

	public void setIdUsers(int idUsers) {
		this.idUsers = idUsers;
	}

	@Column(name = "Id_game", nullable = false)
	public int getIdGame() {
		return this.idGame;
	}

	public void setIdGame(int idGame) {
		this.idGame = idGame;
	}

	@Column(name = "Status")
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ActiveGameId))
			return false;
		ActiveGameId castOther = (ActiveGameId) other;

		return (this.getIdUsers() == castOther.getIdUsers()) && (this.getIdGame() == castOther.getIdGame())
				&& ((this.getStatus() == castOther.getStatus()) || (this.getStatus() != null
						&& castOther.getStatus() != null && this.getStatus().equals(castOther.getStatus())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getIdUsers();
		result = 37 * result + this.getIdGame();
		result = 37 * result + (getStatus() == null ? 0 : this.getStatus().hashCode());
		return result;
	}

}
