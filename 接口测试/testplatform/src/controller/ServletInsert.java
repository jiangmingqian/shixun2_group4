package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletInsert
 */
@WebServlet("/Insert")
public class ServletInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletInsert() {
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
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		System.out.println("执行了insert跳转");
		String id=request.getParameter("sid");
		String casename=request.getParameter("scasename");
		String reway=request.getParameter("sreway");
		String url=request.getParameter("surl");
		String para=request.getParameter("spara");
		String creator=request.getParameter("screator");
		String date=request.getParameter("sdate");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("insert数据库连接");
			String surl="jdbc:mysql://localhost:3307/testinterface?serverTimezone=UTC";
			String user="root";
			String password="87654321";
			Connection conn=DriverManager.getConnection(surl, user, password);
			System.out.println("insert连接成功");
			String sql0="select * from saveset";
			PreparedStatement stmt0=(PreparedStatement) conn.prepareStatement(sql0);
			ResultSet set0 = stmt0.executeQuery();
			List<Map<String, Object>> values0 = handleResultSetToMapList(set0);
			String sql1="insert into saveset(id,casename,reqway,url,para,owner,date) values("+id+",'"+casename+"','"+reway+"','"+url+"','"+para+"','"+creator+"','"+date+"')";
			System.out.println(sql1);
			PreparedStatement stmt1=(PreparedStatement) conn.prepareStatement(sql1);
			if(stmt1 != null) {
				stmt1.executeUpdate();
			}
			String sql="select * from saveset";
			PreparedStatement stmt=(PreparedStatement) conn.prepareStatement(sql);
			ResultSet set = stmt.executeQuery();
			List<Map<String, Object>> values = handleResultSetToMapList(set);
			conn.close();
			ArrayList<CasesComment> p_list = new ArrayList<CasesComment>();
			for(int i = 0; i < values.size(); i++) {
				CasesComment p = new CasesComment((int)values.get(i).get("id"),
					(String)values.get(i).get("casename"),
					(String)values.get(i).get("reqway"),
					(String)values.get(i).get("url"),
					(String)values.get(i).get("para"),
					(String)values.get(i).get("owner"),
					values.get(i).get("date"));
				p_list.add(p);
				
			}
			
			request.setAttribute("plist", p_list);
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
