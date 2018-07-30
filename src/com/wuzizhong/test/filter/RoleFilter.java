package com.wuzizhong.test.filter;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class RoleFilter
 */
public class RoleFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("filter init");
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		@SuppressWarnings("unchecked")
		Map<String, Object> map = (Map<String, Object>) request.getSession().getAttribute("UserInfo");
		if(map != null) {
			String role = (String)map.get("Role");
			if (role.equals("user")) {
				filterChain.doFilter(request, response);
			} else if (role.equals("admin")) {
				request.getRequestDispatcher("/Page/AdminPage.jsp").forward(request, response);
			}
		}else {
			response.sendRedirect("../login.jsp");
		}
	}

	@Override
	public void destroy() {

	}

}
