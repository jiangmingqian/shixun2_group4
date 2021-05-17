<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用例集管理</title>
<link href="${ctx}/css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="js/usecases.js"></script>
</head>

<body class="body1">
 <div class="div1">
  <image src="${ctx}/images/logo.png" class="image1"></image>
  <image src="${ctx}/images/slogan.png" class="image2"></image>
  <image src="${ctx}/images/admin.png" style="float:right;width:28px;margin-right:50px;margin-top:6px">
   <div  class="admin" style="float:left;margin-left:480px">
  	<ul class="level">
  		<li>Admin
  			<ul class=tow>
  				<li ><a href="#">修改密码</a></li>
  				<li><a href="#">退出</a></li>
  			</ul>
  		</li>
  	</ul>
  
  </div>

 </div>
 <div class="div2">
 </div>
 <div class="left" style="background: #f0f9fd;">
  <div class="homepage">
   <image src="${ctx}/images/shou.png" class="i3"></image>
   <div class="shouye"><a href="${ctx}/home.jsp">首页</a></div>
  </div>
  <div class="homepage">
   <div class="shouye1"><a href="${ctx}/project.jsp">项目管理</a></div>
  </div>
  <div class="homepage">
   <div class="shouye1"><a href="${ctx}/port.jsp">接口管理</a></div>
  </div>

  <div class="homepage">
   <div class="shouye1"><a href="${ctx}/usecase.jsp"  onclick="test();return false;">保存用例管理</a></div>
  </div>
  
  <div class="homepage">
   <div class="shouye1"><a href="${ctx}/usecases.jsp">执行结果公示</a></div>
  </div>

 </div>
<div class="right">
  <div class="top">
    <input type="text" id="url" value="请输入项目名"/>
    <input type="submit" value="搜索" id="button1"/>
    <input type="submit" value="新建" id="button2" onclick='alertFun()'/>
    <input type="button" value="获取get" id="button3" onclick="get()" style="margin-top:15px;margin-right:80px"/>
	<input type="button" value="获取post" id="button4" onclick="post()" style="margin-top:-28px;float:right;margin-right:250px"/>
  </div>
  <table class="table1">
   <tr bgcolor=#f5f5f5 height="45">
    <th>
    <form method="post" action="">
    <input type="checkbox" name="num1">
    </form>
    </th>
    <th>序号</th>
    <th>用例名</th>
    <th>请求方法</th>
    <th>URL</th>
    <th>参数</th>
    <th>结果</th>
    <th>执行者</th>
    <th>执行日期</th>
   </tr>
    <c:forEach var="s" items="${list1}">
   	<tr>
   		<td><input type="checkbox" name="num1"></td>
   		<td>${s.id}</td>
   		<td>${s.casename}</td>
   		<td>${s.reqway}</td>
   		<td>${s.url}</td>
   		<td>${s.para}</td>
   		<td>${s.cases}</td>
   		<td>${s.owner}</td>
  		<td>${s.date}</td>
   	
   	</tr>
   </c:forEach>
       <c:forEach var="b" items="${list2}">
   	<tr>
   		<td><input type="checkbox" name="num1"></td>
   		<td>${b.id}</td>
   		<td>${b.casename}</td>
   		<td>${b.reqway}</td>
   		<td>${b.url}</td>
   		<td>${b.para}</td>
   		<td>${b.cases}</td>
   		<td>${b.owner}</td>
  		<td>${b.date}</td>
   	
   	</tr>
   </c:forEach>
   </table>
   	<form id="formInfo">
			<p style="margin-top: 50px; font-size: 16px; float: left; margin-left: 20px">序号:</p>
			<br></br> 
			<input type='text' name='id' style="margin-left:-15px"> 
			<br></br>
			<p style="margin-top: 50px; font-size: 16px; float: left; margin-left: 7px">用例集:</p>
			<br></br> 
			<input type='text' name='projectName' style="margin-top:-40px"> 
			<br></br>
			<p style="margin-top: 50px; font-size: 16px; float: left; margin-left: 7px">创建者:</p>
			<br></br> 
			<input type='text' name='creator' style="margin-top:-30px"> 
			<br></br>
			<p style="margin-top: 50px; font-size: 16px; float: left; margin-left: 2px">创建日期:</p>
			<br></br> 
			<input type='text' name='date' style="margin-top:-40px;margin-right:5px"> 
			<br></br>
			<div id='confirm' onclick='createTable()' class='buttons'>确定</div>
			<div id='cancel' onclick='cancelTable()' class='buttons'>取消</div>
	</form>
   <input type="button" id="all" value="全选" onclick='selectAll()' /> 
   <input type="button" id="nall" value="全不选" onclick='selectAno()' style="float:left;border:1px solid grey;border-radius:5px;height:28px;width:65px;margin-top:15px;margin-left:25px"/> 
   <div  class="operation">
  	<ul calss="op1">
  		<li id="li1" style="font-size:15px">更多操作
  			<ul>
  				<li><a href="#">批量删除</a></li>
  			</ul>
  		</li>
  	</ul>
  
  </div>
  </div>
    
</body>
</html>