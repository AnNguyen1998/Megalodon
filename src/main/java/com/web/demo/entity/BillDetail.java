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
 * BillDetail generated by hbm2java
 */
@Entity
@Table(name = "bill_detail", catalog = "megalodondb")
public class BillDetail implements java.io.Serializable {
	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "Id_bill_detail", unique = true, nullable = false)
	private Integer idBillDetail;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Id_bill")
	private Bill bill;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Id_game")
	private Games games;
	@Column(name = "Price", precision = 18, scale = 0)
	private Long price;

	public BillDetail() {
	}

	public BillDetail(Bill bill, Games games, Long price) {
		this.bill = bill;
		this.games = games;
		this.price = price;
	}

	
	public Integer getIdBillDetail() {
		return this.idBillDetail;
	}

	public void setIdBillDetail(Integer idBillDetail) {
		this.idBillDetail = idBillDetail;
	}

	
	public Bill getBill() {
		return this.bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public Games getGames() {
		return this.games;
	}

	public void setGames(Games games) {
		this.games = games;
	}

	
	public Long getPrice() {
		return this.price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

}
