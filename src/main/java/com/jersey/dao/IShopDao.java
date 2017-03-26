package com.jersey.dao;

import com.jersey.domain.Shop;

public interface IShopDao {
	
	Shop getShopByShopId(String shopId);
	
}
