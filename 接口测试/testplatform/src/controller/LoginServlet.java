package controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
@WebServlet("/LoginServlet")
public class LoginServlet  extends HttpServlet{
	private static final long serialVersionUID = 1L;
	User user=new User();
    

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
	
		System.out.println(userName);
		System.out.println(password);
		user.setUserName(userName);
		user.setPassword(password);
		
		if("admin".equals(user.getUserName())&&"admin".equals(user.getPassword())) {
			System.out.println("登录成功");
			request.getSession().setAttribute("loginUser", user.getUserName());
			response.sendRedirect(request.getContextPath()+"/home.jsp");
		}
		

	}
	/**
	 * servlet 简单登录
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		
	}


	
	

}
