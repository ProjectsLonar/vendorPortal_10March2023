package com.lonar.vendor.vendorportal.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorsFilter implements Filter {

    
      @Override
     public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        final HttpServletResponse response = (HttpServletResponse) res;
       // response.setHeader("Access-Control-Allow-Origin", "*");
        //response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
        //response.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type");
        //response.setHeader("Access-Control-Max-Age", "3600");
        
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
        
        response.setHeader("Access-Control-Expose-Headers", "access_token");
        
        response.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type,access_token");
        response.setHeader("Access-Control-Max-Age", "3600");
        
       if ("OPTIONS".equalsIgnoreCase(((HttpServletRequest) req).getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            chain.doFilter(req, res);
        }
    }

    @Override
    public void destroy() {
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
    }
	
	
	/*public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		System.out.println("Filtering on zuul...........................................................");
		HttpServletResponse response = (HttpServletResponse) res;
		HttpServletRequest request = (HttpServletRequest) req;
		
	  response.setHeader("Access-Control-Allow-Origin", "*");
	    response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
		response.setHeader("Access-Control-Max-Age", "3600");
	    response.setHeader("Access-Control-Allow-Headers", "X-Requested-With, Content-Type, Authorization, Origin, Accept, Access-Control-Request-Method, Access-Control-Request-Headers");
	    
	    /*if ("OPTIONS".equalsIgnoreCase(request.getMethod())){ 
	    	response.setStatus(HttpServletResponse.SC_OK); 
	    	return; 
	    } else {
	    	chain.doFilter(req, res); 
	    	}*/
		//chain.doFilter(req, res);
	//}*/

	    
	//public void init(FilterConfig filterConfig) {}

	    
	//public void destroy() {}

	
}