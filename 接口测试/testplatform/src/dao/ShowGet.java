package dao;

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

import com.alibaba.fastjson.JSON;        
import com.alibaba.fastjson.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;


import io.restassured.response.Response;
import net.sf.json.JSONObject;



/**
 * Servlet implementation class ServletOfGet
 */
@WebServlet("/get1")
public class ShowGet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowGet() {
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
//		String url2 = request.getParameter("url");
//		String para2 = request.getParameter("para");
////		
////		String url = "http://127.0.0.1:8081/hello1";
////		String para = "{}";
//		String urlori = url2;
//		JSONObject jsono = JSONObject.fromObject(para2);
//		Iterator<String> iterator = jsono.keys();
//		url2=url2+"?";
//		
////				assertEquals(response1.getStatusCode(), 200);
//	    while(iterator.hasNext())
//	    {
//	        String key = (String)iterator.next();
//	        Object value = jsono.get(key);
//	        url2=url2+key+"="+value+"&";
//	    }
//	    url2=url2.substring(0,url2.length()-1);
//	    CloseableHttpClient client = HttpClients.createDefault();	
//		HttpGet get = new HttpGet(url2);		
//		CloseableHttpResponse resp = client.execute(get);
//		HttpEntity entity=resp.getEntity();
		String result = null;
		String result1 = null;
		try {
			
			
			
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("数据库连接");
			String surl="jdbc:mysql://localhost:3306/testinterface?serverTimezone=UTC";
			String user="root";
			String password="123456";
			System.out.println("连接成功");
			Connection conn=DriverManager.getConnection(surl, user, password);
			String sql="select * from saveset";
			String sql0="select * from getset";
//			String sql01="select * from postset";
			PreparedStatement stmt=(PreparedStatement) conn.prepareStatement(sql);
			ResultSet set = stmt.executeQuery();
			PreparedStatement stmt0=(PreparedStatement) conn.prepareStatement(sql0);
			ResultSet set0 = stmt0.executeQuery();
//			PreparedStatement stmt01=(PreparedStatement) conn.prepareStatement(sql01);
//			ResultSet set01 = stmt01.executeQuery();
			List<Map<String, Object>> values = handleResultSetToMapList(set);
			List<Map<String, Object>> values0 = handleResultSetToMapList(set0);
//			conn.close();
			Object id = values.get(values.size()-1).get("id");
//			Object id1 = values0.get(values.size()-1).get("id");
			
			Date date = new Date(System.currentTimeMillis());
			long time = date.getTime();
			Date sqlDate = new Date(time);
//			
//			List<String> urList = new ArrayList<>();
//			List<String> paraList = new ArrayList<>();
			
			Statement stmt1=conn.createStatement();
			String sql3="delete from getset";
//			String sql4="delete from postset";
			stmt1.executeUpdate(sql3);
//			stmt1.executeUpdate(sql4);
			for(int i = 0; i <values.size(); i++) {
				
				String reqway = (String)values.get(i).get("reqway");
				String url = (String)values.get(i).get("url");
				String para = (String)values.get(i).get("para");
//				String result1 = (String)values.get(i).get("cases");		
				String urlori = url;
				JSONObject jsono = JSONObject.fromObject(para);
				Iterator<String> iterator = jsono.keys();
				url=url+"?";
				
//						assertEquals(response1.getStatusCode(), 200);
			    while(iterator.hasNext())
			    {
			        String key = (String)iterator.next();
			        Object value = jsono.get(key);
			        url=url+key+"="+value+"&";
			    }
			    url=url.substring(0,url.length()-1);
			    CloseableHttpClient client = HttpClients.createDefault();	
			    
				
				 if (reqway.equals("get")||reqway.equals("GET")||reqway.equals("Get")) {
					 	HttpGet get = new HttpGet(url);		
							
						CloseableHttpResponse resp = client.execute(get);
						
					
						HttpEntity entity=resp.getEntity();
						
						result = EntityUtils.toString(entity,"utf-8");			
								
//						System.out.println(result);
//						JSONObject jsonResult=JSONObject.fromObject(result);
						EntityUtils.consume(entity);
						
						
						resp.close();
						
						client.close();
					 	
					 	
						String sql2="insert into getset(id,casename,reqway,url,para,cases,owner,date) values("+(i+1)+",'"+"用例"+(i+1)+"','"+"get"+"','"+url+"','"+para+"','"+result+"','"+"Admin"+"','"+sqlDate+"')";
						System.out.println(sql2);
						stmt1.executeUpdate(sql2);
						
						
						request.setAttribute("resurl", url);
						request.setAttribute("respara", para);
						request.setAttribute("response", result);
//						request.getRequestDispatcher("usecases.jsp").forward(request, response);
					}
				 
//				 if (reqway.equals("post")||reqway.equals("POST")||reqway.equals("Post")) {
////					urList.add(url);
////					paraList.add(para);
////					for (int j = 0; j < urList.size(); j++) {
////						String url1 = urList.get(j);
////						String para1 = paraList.get(j);
//					 HttpPost post = new HttpPost(url);
//						post.setHeader("Content-Type", "application/json");
//						
//						post.setEntity(new StringEntity(JSON.toJSONString(jsono)));
//						CloseableHttpResponse resp = client.execute(post);
//						HttpEntity entity=resp.getEntity();
//						String result11;
//						
//							result11 = EntityUtils.toString(entity,"utf-8");			
//
////							System.out.println(result);
////							JSONObject jsonResult=JSONObject.fromObject(result);
//							EntityUtils.consume(entity);
//							resp.close();
//							client.close();
//						String sql2="insert into postset(id,casename,reqway,url,para,cases,owner,date) values("+(i+1)+",'"+"用例"+(i+1)+"','"+"post"+"','"+url+"','"+para+"','"+result11+"','"+"Admin"+"','"+sqlDate+"')";
//						System.out.println(sql2);
//						
//						
//						stmt1.executeUpdate(sql2);
//						request.setAttribute("resurl", urlori);
//						request.setAttribute("respara", para);
//						request.setAttribute("response", result11);
////						request.getRequestDispatcher("port.jsp").forward(request, response);
//					}
				 
				
		
			
//			request.getServletContext().setAttribute("urls", urList);
//			request.getServletContext().setAttribute("paras", paraList);
			}
	
			System.out.println("返回信息");
			conn.close();
			System.out.println("关闭数据库连接");	
			
//			request.getRequestDispatcher("port.jsp").forward(request, response);
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
