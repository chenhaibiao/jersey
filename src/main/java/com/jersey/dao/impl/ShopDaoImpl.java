package com.jersey.dao.impl;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.jersey.dao.IShopDao;
import com.jersey.domain.Shop;

@Repository("shopDao")
public class ShopDaoImpl implements IShopDao {
	
	private static final Logger logger = Logger.getLogger(ShopDaoImpl.class);
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public Shop getShopByShopId(String shopId) {
		return sqlSessionTemplate.selectOne("Shop.getShopByShopId", shopId);
	}

}
