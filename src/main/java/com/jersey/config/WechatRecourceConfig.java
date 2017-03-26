package com.jersey.config;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

public class WechatRecourceConfig extends ResourceConfig {

	/**
	 * Register JAX-RS application components.
	 */
	public WechatRecourceConfig() {
		/**
		 * 用 Jackson JSON 的提供者来解释 JSON
		 */
		register(JacksonFeature.class);
		/**
		 * Spring filter 提供了 JAX-RS 和 Spring 请求属性之间的桥梁
		 */
		register(RequestContextFilter.class);
		
		/**
		 * 包路径下符合要求的类将被发布成webservice  
		 */
		packages("com.jersey.controller");

	}
}
