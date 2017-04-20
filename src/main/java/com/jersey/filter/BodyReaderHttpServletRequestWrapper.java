package com.jersey.filter;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * ServletReques包装类
 * 
 */
public class BodyReaderHttpServletRequestWrapper extends HttpServletRequestWrapper {
	
	private final byte[] body;

	public BodyReaderHttpServletRequestWrapper(HttpServletRequest request) {
		super(request);
		body = HttpHelper.getBodyString(request).getBytes(Charset.forName("UTF-8"));
	}
	
	@Override
	public BufferedReader getReader() throws IOException {
		return new BufferedReader(new InputStreamReader(getInputStream()));
	}
	
	@Override
	public ServletInputStream getInputStream() throws IOException {
		final ByteArrayInputStream bais = new ByteArrayInputStream(body);
		return new ServletInputStream() {
			@Override
			public int read() throws IOException {
				return bais.read();
			}
			@Override
			public boolean isFinished() {
				// Auto-generated method stub
				return false;
			}
			@Override
			public boolean isReady() {
				// Auto-generated method stub
				return false;
			}
			@Override
			public void setReadListener(ReadListener arg0) {
				// Auto-generated method stub
			}
		};
	}

}