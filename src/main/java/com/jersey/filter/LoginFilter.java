package com.jersey.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;


public class LoginFilter extends OncePerRequestFilter {
	
	private static final Logger logger = Logger.getLogger(LoginFilter.class); 
    
	public static void responseJson(JSONObject jsonObj, HttpServletResponse response){
		PrintWriter out = null;
	    try {
	    	response.setContentType("application/json");
	        out = response.getWriter();
	        JSONObject returnJson =  JSONObject.fromObject(jsonObj);
	        logger.info(null != returnJson ? returnJson.toString() : null);
	        out.print(returnJson);
	        out.flush();
	        out.close();
	    } catch (IOException e) {
	    	logger.error("responseJson Exception:", e);
	    }
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		ServletRequest requestWrapper = new BodyReaderHttpServletRequestWrapper(request);
        String body = HttpHelper.getBodyString(requestWrapper);
		logger.debug("body: " + body);
		if (StringUtils.isEmpty(body)) {
			JSONObject json = new JSONObject();
			json.put("id", "aa");
			responseJson(json, response);
			return;
		}
		filterChain.doFilter(requestWrapper, response);
	}
	
}
