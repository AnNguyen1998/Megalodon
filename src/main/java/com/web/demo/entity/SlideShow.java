package com.web.demo.entity;
// Generated Jul 5, 2021, 11:28:02 AM by Hibernate Tools 5.0.6.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * SlideShow generated by hbm2java
 */
@Entity
@Table(name = "slide_show", catalog = "megalodondb")
public class SlideShow implements java.io.Serializable {
	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "Id_slide_show", unique = true, nullable = false)
	private Integer idSlideShow;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Id_game")
	private Games games;
	@Column(name = "image", length = 45)
	private String image;

	public SlideShow() {
	}

	public SlideShow(Games games, String image) {
		this.games = games;
		this.image = image;
	}


	public Integer getIdSlideShow() {
		return this.idSlideShow;
	}

	public void setIdSlideShow(Integer idSlideShow) {
		this.idSlideShow = idSlideShow;
	}

	
	public Games getGames() {
		return this.games;
	}

	public void setGames(Games games) {
		this.games = games;
	}


	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
