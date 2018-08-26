package com.howtodospring.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbl_item")
public class Item {
    @Column(name ="item_id")
    @GeneratedValue
	private Long id;
    @Column(name = "itm_name")
	private String itm_name;
	@ManyToOne
	@JoinColumn(name ="user_id")
	private Account account;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getItm_name() {
		return itm_name;
	}
	public void setItm_name(String itm_name) {
		this.itm_name = itm_name;
	}
	
}
