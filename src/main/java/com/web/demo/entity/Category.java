package com.web.demo.entity;
// Generated Jun 29, 2021, 8:56:47 AM by Hibernate Tools 5.0.6.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Category generated by hbm2java
 */
@Entity
@Table(name = "category", catalog = "megalodondb")
public class Category implements java.io.Serializable {

	private Integer idCategory;
	private String nameCategory;
	private Set<GameCategory> gameCategories = new HashSet<GameCategory>(0);

	public Category() {
	}

	public Category(String nameCategory, Set<GameCategory> gameCategories) {
		this.nameCategory = nameCategory;
		this.gameCategories = gameCategories;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "Id_category", unique = true, nullable = false)
	public Integer getIdCategory() {
		return this.idCategory;
	}

	public void setIdCategory(Integer idCategory) {
		this.idCategory = idCategory;
	}

	@Column(name = "Name_category")
	public String getNameCategory() {
		return this.nameCategory;
	}

	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}

//	@OneToMany(fetch = FetchType.EAGER, mappedBy = "category")
//	public Set<GameCategory> getGameCategories() {
//		return this.gameCategories;
//	}

	public void setGameCategories(Set<GameCategory> gameCategories) {
		this.gameCategories = gameCategories;
	}

}
