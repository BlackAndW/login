package com.wuzizhong.test.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.wuzizhong.test.Service.RegisterService;
import com.wuzizhong.test.Service.Impl.RegisterServiceImpl;
import com.wuzizhong.test.entity.User;

/**
 * Servlet implementation class BServlet
 */
public class BServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RegisterService registerService = new RegisterServiceImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String username = req.getParameter("username");
		String password = req.getParameter("password");
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		int state = registerService.checkResult(user);
		
		if (state == 0) {
			resp.sendRedirect("login.jsp");
		}else if (state == 1) {
			String msg = "用户名已被注册";
			req.setAttribute("msg", msg);
			req.getRequestDispatcher("register.jsp").forward(req, resp);
		}else if (state == 2) {
			String msg = "密码已被注册";
			req.setAttribute("msg", msg);
			req.getRequestDispatcher("register.jsp").forward(req, resp);
		}
	}

}
