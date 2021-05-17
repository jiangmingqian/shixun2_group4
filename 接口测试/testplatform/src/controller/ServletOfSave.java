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

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.protocol.Resultset;

/**
 * Servlet implementation class ServletOfSave
 */
@WebServlet("/save")
public class ServletOfSave extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletOfSave() {
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
		String url = request.getParameter("url");
		String param = request.getParameter("para");
		String originurl = url;
		String method = request.getParameter("select");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String surl="jdbc:mysql://localhost:3307/testinterface?serverTimezone=UTC";
			String user="root";
			String password="87654321";
			
			Connection conn=DriverManager.getConnection(surl, user, password);
//			conn.close();
			String sql0="select * from saveset";
			PreparedStatement stmt0=(PreparedStatement) conn.prepareStatement(sql0);
			ResultSet set0 = stmt0.executeQuery();
			List<Map<String, Object>> values0 = handleResultSetToMapList(set0);
			Object id = values0.get(values0.size()-1).get("id");
			Date date = new Date(System.currentTimeMillis());
			long time = date.getTime();
			Date sqlDate = new Date(time);
			String sql1="insert into saveset(id,casename,reqway,url,para,owner,date) values("+((int)id+1)+",'"+"用例"+((int)id+1)+"','"+method+"','"+originurl+"','"+param+"','"+"Admin"+"','"+sqlDate+"')";
			PreparedStatement stmt1=(PreparedStatement) conn.prepareStatement(sql1);
			if(method != null) {
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
