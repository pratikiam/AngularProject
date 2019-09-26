package config;


import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CustomURLFilter implements Filter {

	 private static final Logger LOGGER = LoggerFactory.getLogger(CustomURLFilter.class);

	 @Override
	 public void init(FilterConfig filterConfig) throws ServletException {
	  LOGGER.info("########## Initiating CustomURLFilter filter ##########");
	 }

	 @Override
	 public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

	  HttpServletRequest request = (HttpServletRequest) servletRequest;
	  HttpServletResponse response = (HttpServletResponse) servletResponse;
	  StringBuffer jb = new StringBuffer();
	  String line = null;
	  try {
		  //  System.out.println("Data of request "+request.getReader());
	    BufferedReader reader = request.getReader();
	    while ((line = reader.readLine()) != null)
	    	System.out.println("Data of request "+line.toString());
	      jb.append(line);
	  } catch (Exception e) {e.printStackTrace();  }


	/*  StringBuffer jb = new StringBuffer();
	  String line = null;
	  try {
	    BufferedReader reader = request.getReader();
	    while ((line = reader.readLine()) != null)
	      jb.append(line);
	  } catch (Exception e) { report an error }

	  try {
	    JSONObject jsonObject =  HTTP.toJSONObject(jb.toString());	    
	  } catch (JSONException e) {
		  e.printStackTrace();
	    // crash and burn
	    throw new IOException("Error parsing JSON request string");
	  }
	  
	  LOGGER.info("This Filter is only called when request is mapped for /customerImages resource"+request.
			  getContentType()+ " " +request.getReader().readLine());

	  //call next filter in the filter chain
*/	  filterChain.doFilter(request, response);
	 }

	 @Override
	 public void destroy() {

	 }
	}