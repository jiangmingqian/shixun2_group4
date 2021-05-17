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
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;

import io.restassured.response.Response;
import net.sf.json.JSONObject;



/**
 * Servlet implementation class ServletOfGet
 */
@WebServlet("/get")
public class ServletOfGet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletOfGet() {
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
		String para = request.getParameter("para");
		String urlori = url;
		JSONObject jsono = JSONObject.fromObject(para);
		Iterator<String> iterator = jsono.keys();
		url=url+"?";
	    while(iterator.hasNext())
	    {
	        String key = (String)iterator.next();
	        Object value = jsono.get(key);
	        url=url+key+"="+value+"&";
	    }
	    url=url.substring(0,url.length()-1);
	    CloseableHttpClient client = HttpClients.createDefault();	
		HttpGet get = new HttpGet(url);		
		CloseableHttpResponse resp = client.execute(get);
		HttpEntity entity=resp.getEntity();
		String result;
		try {
			result = EntityUtils.toString(entity,"utf-8");			
			EntityUtils.consume(entity);
			resp.close();
			client.close();
			
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("数据库连接");
			String surl="jdbc:mysql://localhost:3307/testinterface?serverTimezone=UTC";
			String user="root";
			String password="87654321";
			Connection conn=DriverManager.getConnection(surl, user, password);
			System.out.println("连接成功");
			String sql1="select * from getset";
			System.out.println(sql1);
			PreparedStatement pstmt=(PreparedStatement) conn.prepareStatement(sql1);
			ResultSet set = pstmt.executeQuery();
			List<Map<String, Object>> values = handleResultSetToMapList(set);
			Object id = values.get(values.size()-1).get("id");
			Date date = new Date(System.currentTimeMillis());
			long time = date.getTime();
			Date sqlDate = new Date(time);
			String sql="insert into getset(id,casename,reqway,url,para,cases,owner,date) values("+((int)id+1)+",'"+"用例"+((int)id+1)+"','"+"GET"+"','"+urlori+"','"+para+"','"+result+"','"+"Admin"+"','"+sqlDate+"')";
			System.out.println(sql);
			Statement stmt=conn.createStatement();
			stmt.executeUpdate(sql);
			System.out.println("返回信息");
			conn.close();
			System.out.println("关闭数据库连接");

			request.setAttribute("resurl", urlori);
			request.setAttribute("respara", para);
			request.setAttribute("response", result);
			
			request.getRequestDispatcher("port.jsp").forward(request, response);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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