package com.wuzizhong.test.Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wuzizhong.test.Service.LoginService;
import com.wuzizhong.test.Service.Impl.LoginServiceImpl;
import com.wuzizhong.test.entity.User;

/**
 * Servlet implementation class AServlet
 */
public class AServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	LoginService loginservice = new LoginServiceImpl();
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        ��ҳ���ȡ�û���������
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        
//      ��ֵ��װ��user����
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        
//      ����service���������ݷ���ֵѡ����ת·��
        try {
			Map<String, Object> User = new HashMap<>();
			User = loginservice.check(user);
			if (User.get("msg") == "") {
				HttpSession session = req.getSession();
				session.setAttribute("UserInfo", User);
				resp.sendRedirect("Page/UserPage.jsp");
			}else {
				req.setAttribute("msg", User.get("msg"));
				req.getRequestDispatcher("login.jsp").forward(req, resp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

}
