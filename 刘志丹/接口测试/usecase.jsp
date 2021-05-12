<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用例管理</title>
<link href="${ctx}/css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="js/usecase.js"></script>
</head>

<body class="body1">
 <div class="div1">
  <image src="${ctx}/images/logo.png" class="image1"></image>
  <image src="${ctx}/images/slogan.png" class="image2"></image>
  <image src="${ctx}/images/admin.png" style="float:right;width:28px;margin-right:60px;margin-top:6px">
  <div  class="admin" style="float:right;margin-right:450px;margin-top:-6px">
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
  <div class="X1">
  </div>
  <div class="homepage">
   <div class="shouye1"><a href="${ctx}/project.jsp">项目管理</a></div>
  </div>
   <div class="X1">
  </div>
  <div class="homepage">
   <div class="shouye1"><a href="${ctx}/port.jsp">接口管理</a></div>
  </div>
   <div class="X1">
  </div>
  <div class="homepage">
   <div class="shouye1"><a href="${ctx}/usecase.jsp" onclick="test();return false;">保存用例管理</a></span></div>
  </div>
   <div class="X1">
  </div>
  <div class="homepage">
   <div class="shouye1"><a href="${ctx}/usecases.jsp">执行结果公示</a></div>
  </div>
   <div class="X1">
  </div>
 </div>
<div class="right">
  <div class="top">
   <form action="Search"  id="sear">
     <input type="text" name="pname" style="float:left;margin-top:15px" value=${pname}>
     <input type="submit" value="搜索" id="button1"/>
   </form>
     <input type="submit" value="新建" id="button2" onclick='alertFun()'/>
   <form action="Insert" method="post" id="formInfo" >
		<p style="margin-top: 10px; font-size: 16px; float: left; margin-left: 7px">序号:</p>
		<br></br> 
		<input type='text' name='sid' style="margin-right:2px;margin-top:-25px;height:18px" value=${id}> 
		<br></br>
		<p style="margin-top:10px; font-size: 16px; float: left; margin-left: 7px;margin-top:-5px">用例名:</p>
		<br></br> 
		<input type='text' name='scasename' style="margin-top:-40px;height:18px;margin-right:2px" value=${casename}> 
		<br></br>
		<p style="margin-top: 50px; font-size: 16px; float: left; margin-left: 2px;margin-top:-10px">请求方法:</p>
		<br></br> 
		<input type='text' name='sreway' style="margin-right:-5px;margin-top:-40px;height:18px" value=${reway}> 
		<br></br>
		<p style="margin-top: 50px; font-size: 16px; float: left; margin-left: 7px;margin-top:-5px">URL:</p>
		<br></br> 
		<input type='text' name='surl' style="margin-top:-40px;margin-right:2px;height:18px" value=${url}> 
		<br></br>
		<p style="margin-top: 50px; font-size: 16px; float: left; margin-left: 7px;margin-top:-5px">参数:</p>
		<br></br> 
		<input type='text' name='spara' style="margin-top:-40px;margin-right:5px;height:18px" value=${para}> 
		<br></br>
		<p style="margin-top: 50px; font-size: 16px; float: left; margin-left: 7px;margin-top:-5px">创建者:</p>
		<br></br> 
		<input type='text' name='screator' style="margin-top:-40px;margin-right:5px;height:18px" value=${creator}> 
		<br></br>
		<p style="margin-top: 50px; font-size: 16px; float: left; margin-left: 7px;margin-top:-5px">创建日期:</p>
		<br></br> 
		<input type='text' name='sdate' style="margin-top:-40px;margin-right:5px;height:18px" value=${date}> 
		<br></br>
		<input type="submit" id='confirm' value="确定"  onclick='createTableCase()' style='width:60px;margin-right:110px;height:30px;background-color:#eee'/>
		<div id='cancel' onclick='cancelTableCase()' class='buttons' >取消</div>
	</form>
	<form action="delete" method="post" id="deleteformInfo" style="display:none">
	  <p style="font-size: 16px; float: left;margin-left:5px;margin-top:10px">请输入你要删除的id:</p>
	  <br></br>
	  <input type='text' name='deleteid' style="float:left;height:20px;margin-left:20px" value=${deleteid}> 
	  <br></br>
	  <input type="submit" id='deleteconfirm' value="确定"  onclick='confirm()' style='width:60px;height:30px;background-color:#eee;magin-top:170px;float:left;margin-left:20px'/>
	  <input type='button' id='deletecancel' value="取消" onclick='cancel()'  style='width:60px;height:30px;background-color:#eee;magin-top:70px;float:left;margin-left:60px'/>
	</form>
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
    <th>创建者</th>
    <th>创建日期</th>
    <th>操作</th>
   </tr>
   </tr>
   	<tr>
		<td><input type="checkbox" name="num1"></td>
		<td name="aid" value="sort">${cid}</td>
		<td name="acasename">${cname}</td>
		<td name="areqway">${cmethod}</td>
		<td name="aurl">${curl}</td>
		<td name="asumway">${cpara}</td>
		<td name="aowner">${cowner}</td>
		<td name="adate">${cdate}</td>
		<td>
			<a href="javascript:void(0);" onclick="alertFun()">编辑</a>
			<a href="javascript:void(0);" onclick="del(this)">删除</a>
	</tr>
  
	
	<c:forEach var="p" items="${plist}">
   	<tr>
   		<td><input type="checkbox" name="num1"></td>
   		<td>${p._id}</td>
   		<td>${p._name}</td>
   		<td>${p._method}</td>
   		<td>${p._url}</td>
   		<td>${p._param}</td>
   		<td>${p._owner}</td>
  		<td>${p._date}</td>
   		<td>
			<a href="javascript:void(0);" onclick="alertFun()">编辑</a>
			<a href="javascript:void(0);" onclick="del(this)">删除</a>   			
   		</td>
   	</tr>
   </c:forEach>
   <c:forEach var="s" items="${list}">
   	<tr>
   		<td><input type="checkbox" name="num1"></td>
   		<td>${s.id}</td>
   		<td>${s.casename}</td>
   		<td>${s.reqway}</td>
   		<td>${s.url}</td>
   		<td>${s.para}</td>
   		<td>${s.owner}</td>
  		<td>${s.date}</td>
   		<td>
			<a href="javascript:void(0);" onclick="alertFun()">编辑</a>
			<a href="javascript:void(0);" onclick="del(this)">删除</a> 			
   		</td>
   	</tr>
   </c:forEach>
   </table>
 
    <input type="button" id="all" value="全选" onclick='selectAll()' /> 
	<input type="button" id="nall" value="全不选" onclick='selectAno()' style="float:left;border:1px solid grey;border-radius:5px;height:28px;width:65px;margin-top:15px;margin-left:25px"/>    <div  class="operation">
  	<ul calss="op1">
  		<li id="li1" style="font-size:15px">更多操作
  		<form action="?"  id="form" name="form">
  		  	<ul>
  				<li><input type="submit" id="alldelete" value="批量删除" onclick='deleteAll()' /></li>
  				<li><input type="submit" id="allrun" value="批量执行" onclick='runAll()' /> </li>
  			</ul>
  		</form>
  		</li>
  	</ul>
  
  </div>
  </div>
    <script>
    function runAll(){ 
    	 form.action = "get1"; 
   	     document.form.submit();   
   	     form.action = "post1"; 
  	     document.form.submit();  
   	 }

 
    
    </script>
</body>
</html>
