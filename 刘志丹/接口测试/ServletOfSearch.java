package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.hc.core5.http.ParseException;

/**
 * Servlet implementation class ServletOfSearch
 */
@WebServlet("/Search")
public class ServletOfSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletOfSearch() {
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
		response.setContentType("text/html;charset=utf-8");
		String name = request.getParameter("pname");
		System.out.println("name的值为"+name);
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
		    String sql="SElECT id,casename,reqway,url,para,owner,date"+" from saveset"+" where casename='"+name+"'";
		    ResultSet rs=state.executeQuery(sql);
		    System.out.println("执行了查询操作");
		    List<Map<String, Object>> values = handleResultSetToMapList(rs);
			System.out.println(values);
			request.setAttribute("cid", values.get(0).get("id"));
			request.setAttribute("cname", values.get(0).get("casename"));
			request.setAttribute("cmethod", values.get(0).get("reqway"));
			request.setAttribute("curl", values.get(0).get("url"));
			request.setAttribute("cparam", values.get(0).get("para"));
			request.setAttribute("cowner", values.get(0).get("owner"));
			request.setAttribute("cdate", values.get(0).get("date"));

		    while(rs.next()){   
		        System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+
		        		" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6)+" "+rs.getString(7)+" "+rs.getString(8));
		    }
		
			conn.close();
			System.out.println("关闭数据库连接");
			request.getRequestDispatcher("usecase.jsp").forward(request, response);
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