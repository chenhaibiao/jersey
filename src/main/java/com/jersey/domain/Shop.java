package com.jersey.domain;

import java.io.Serializable;

public class Shop implements Serializable {

	/** 
	 * @Fields serialVersionUID
	 */ 
	private static final long serialVersionUID = 1L;
	
	private String shopId = null;
	private String name = null;
	
	public String getShopId() {
		return shopId;
	}
	public void setShopId(String shopId) {
		this.shopId = shopId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
