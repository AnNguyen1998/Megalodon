package com.web.demo.entity;
// Generated Jul 5, 2021, 11:28:02 AM by Hibernate Tools 5.0.6.Final

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
 * Role generated by hbm2java
 */
@Entity
@Table(name = "role", catalog = "megalodondb")
public class Role implements java.io.Serializable {
	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "Id_role", unique = true, nullable = false)
	private Integer idRole;
	@Column(name = "Name_role", length = 45)
	private String nameRole;
//	private Set<Users> userses = new HashSet<Users>(0);

	public Role() {
	}

	public Role(String nameRole) {
		this.nameRole = nameRole;
//		this.userses = userses;
	}


	public Integer getIdRole() {
		return this.idRole;
	}

	public void setIdRole(Integer idRole) {
		this.idRole = idRole;
	}


	public String getNameRole() {
		return this.nameRole;
	}

	public void setNameRole(String nameRole) {
		this.nameRole = nameRole;
	}

//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
//	public Set<Users> getUserses() {
//		return this.userses;
//	}
//
//	public void setUserses(Set<Users> userses) {
//		this.userses = userses;
//	}

}
