package demo;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

@Component
public class SimpleCORSFilter implements Filter {

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletResponse response = (HttpServletResponse) res;
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE, OPTIONS");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
		response.setHeader("Access-Control-Allow-Headers", "Content-Type,application/json");
		response.setHeader("Access-Control-Allow-Headers", "Content-Type,text/plain");
		HttpServletRequest request = (HttpServletRequest) req;
		request.setAttribute("Origin", "");
		request.setAttribute("Access-Control-Request-Method", "POST, GET, PUT, DELETE, OPTIONS");
		request.setAttribute("Access-Control-Request-Headers", "Content-Type,application/json");
		request.setAttribute("Access-Control-Request-Headers", "Content-Type,text/plain");
		chain.doFilter(req, res);
	}

	public void init(FilterConfig filterConfig) {}

	public void destroy() {}

}