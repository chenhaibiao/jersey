package com.jersey.controller;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.jersey.dao.IShopDao;
import com.jersey.domain.Shop;

@Path("/shop/")  
public class ShopController {
	
	private static final Logger logger = Logger.getLogger(ShopController.class);
	
	@Autowired
	@Qualifier("shopDao")
	private IShopDao shopDao;
	
	@POST  
    @Path("shopDetail")
	@Consumes(MediaType.APPLICATION_JSON) 
    @Produces(MediaType.APPLICATION_JSON)  
	public Shop shopDetail(@Context HttpServletRequest request, JSONObject json) {
		logger.debug("shopDetail");
		if (null == json){
			logger.info("json is null");
		} else {
			logger.debug("json: " + json.toString());
		}
		Shop shop = new Shop(); // shopDao.getShopByShopId(jsonObj.getString("shopId"));
		return shop;
	}
	
}
