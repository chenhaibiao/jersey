package com.jersey.filter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import javax.servlet.ServletRequest;

import org.apache.log4j.Logger;

public class HttpHelper {
	
	private static Logger logger = Logger.getLogger(HttpHelper.class);

	/**
	 * 获取请求的body
	 * @param request
	 * @return
	 */
	public static String getBodyString(ServletRequest request){
		StringBuilder sb = new StringBuilder();
		InputStream inputStream = null;
		BufferedReader reader = null;
		String line = "";
		try {
			inputStream = request.getInputStream();
			reader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
			while ((line = reader.readLine()) != null){
				sb.append(line);
			}
		}catch (IOException e){
			logger.error("HttpHelper.getBodyString.IOException1:",e);
		}finally {
			if (inputStream != null) {  
                try {  
                    inputStream.close();  
                } catch (IOException e) {  
                	logger.error("HttpHelper.getBodyString.IOException2:",e);  
                }  
            }  
            if (reader != null) {  
                try {  
                    reader.close();  
                } catch (IOException e) {  
                	logger.error("HttpHelper.getBodyString.IOException3:",e);  
                }  
            }  
		}
		return sb.toString();
	}
}
