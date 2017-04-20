package com.jersey.filter;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Context;

import org.apache.log4j.Logger;

public class RequestFilter implements ContainerRequestFilter {
	
	private static final Logger logger = Logger.getLogger(RequestFilter.class);

	@Context   
    private HttpServletRequest request;  
    @Context  
    private HttpServletResponse response;  
    
	@Override
	public void filter(ContainerRequestContext context) throws IOException {
		String headerString = context.getHeaderString("content-type");
		logger.debug("request: "+ request);
		logger.debug("response: "+ response);
		logger.debug("uri: " + request.getRequestURI());
		logger.debug("url: " + request.getRequestURL());
		logger.debug("headerString: " + headerString);
	}
}
