package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletOfDelete
 */
@WebServlet("/delete")
public class ServletOfDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletOfDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		String deletetId = request.getParameter("deleteid");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("数据库连接");
			String surl="jdbc:mysql://localhost:3307/testinterface?serverTimezone=UTC";
			String user="root";
			String password="87654321";
			Connection conn=DriverManager.getConnection(surl, user, password);
			System.out.println("连接成功");
//			容器
		    Statement state=conn.createStatement();
		    String sql="Delete"+" from saveset"+" where id='"+deletetId+"'";
		    System.out.println(sql);
			PreparedStatement stmt=(PreparedStatement) conn.prepareStatement(sql);
			if(stmt != null) {
				stmt.executeUpdate();
			}
		
			conn.close();
			System.out.println("关闭数据库连接");
			request.getRequestDispatcher("getsql.jsp").forward(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
