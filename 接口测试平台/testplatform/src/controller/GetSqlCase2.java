package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.dreamhead.moco.parser.model.RequestSetting;

/**
 * Servlet implementation class GetSQLCase
 */
@WebServlet("/GetSqlCase2")
public class GetSqlCase2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetSqlCase2() {
        super();
        // TODO Auto-generated constructor stub
    }
    private List<String> getColumnLabels(ResultSet resultSet)
			throws SQLException {
		List<String> labels = new ArrayList<String>();
 
		ResultSetMetaData rsmd = (ResultSetMetaData) resultSet.getMetaData();
		for (int i = 0; i < rsmd.getColumnCount(); i++) {
			labels.add(rsmd.getColumnLabel(i + 1));
		}
 
		return labels;
	}
    public List<Map<String, Object>> handleResultSetToMapList(
			ResultSet resultSet) throws SQLException {
		List<Map<String, Object>> values = new ArrayList<Map<String, Object>>();
 
		List<String> columnLabels = getColumnLabels(resultSet);
		Map<String, Object> map = null;
 
		while (resultSet.next()) {
			map = new HashMap<String, Object>();
 
			for (String columnLabel : columnLabels) {
				Object value = resultSet.getObject(columnLabel);
				map.put(columnLabel, value);
			}
			values.add(map);
		}
		return values;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String surl="jdbc:mysql://localhost:3306/testinterface?serverTimezone=UTC";
		String user="root";
		String password="123456";
		Connection conn;
		try {
			conn = DriverManager.getConnection(surl, user, password);
			System.out.println("数据库连接成功");
			String sql1="select * from getset";
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(sql1);
			List<Map<String, Object>> values = handleResultSetToMapList(resultSet);
			conn.close();

			request.setAttribute("id", values.get(values.size()-1).get("id"));
			request.setAttribute("casename", values.get(values.size()-1).get("casename"));
			request.setAttribute("reqway", values.get(values.size()-1).get("reqway"));
			request.setAttribute("url", values.get(values.size()-1).get("url"));
			request.setAttribute("para",values.get(values.size()-1).get("para"));
			request.setAttribute("cases", values.get(values.size()-1).get("cases"));
			request.setAttribute("owner", values.get(values.size()-1).get("owner"));
			request.setAttribute("date", values.get(values.size()-1).get("date"));
			request.setAttribute("list1", values);
			request.getRequestDispatcher("usecases.jsp").forward(request, response);
			resultSet.close();
			conn.close();
			System.out.println("关闭数据库连接");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
	}

}

