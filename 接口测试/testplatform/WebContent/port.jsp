<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>接口管理</title>
<link href="${ctx}/css/style.css" rel="stylesheet" type="text/css" />

</head>

<body class="body1">
<script  type= "text/javascript">
function test(){
	location.href="getsql.jsp";
}

</script>
 <div class="div1">
  <image src="${ctx}/images/logo.png" class="image1"></image>
  <image src="${ctx}/images/slogan.png" class="image2"></image>

  <image src="${ctx}/images/admin.png" style="float:right;width:28px;margin-right:40px;margin-top:6px">
  <div  class="admin" style="float:left;margin-left:480px">
  	<ul calss="level">
  		<li>Admin
  			<ul class=tow>
  				<li ><a>修改密码</a></li>
  				<li><a href="/testplatform/LogoutServlet">退出</a></li>
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
   <div class="shouye1"><a href="${ctx}/usecase.jsp" onclick="test();return false;">保存用例管理</a></div>
  </div>
 
  <div class="homepage">
   <div class="shouye1"><a href="${ctx}/usecases.jsp">执行结果公示</a></div>
  </div>
 </div>
 <form action="?"  id="form" name="form">
	<div  class="i1">
		<div class="ii1">
		<select class="select" id="select" name="select" onchange="Search();">
		<option id ="get" selected="selected" value="get">GET</option>
		<option id="post" value="post">POST</option>
		</select>
		<input type="text" id="url2" name="url" value=${resurl} >
		<input type="submit" id="send" name="send" value="发送" onClick="chkaction();" />
	 	<input type="submit" id="save" name="save" value="保存" onClick="action_save();" style="float:right;margin-right:10px;top:100px" />		
		</div>
	</div>
	<div class="i2">
		<div class="can1">
		<span id="as">请求参数</span></div>
		<div  class="ii2">
		<textarea name="para">${respara}</textarea>
		</div>
		<div class="can2">
		<span id="bs">返回响应</span></div>
		<div>
		<textarea name="response">${response}</textarea>
	
		</div>
	
	</div>
 </form>
 	
 <script>
 
 function action_save(){ 
	 form.action = "save"; 
	 document.form.submit(); 
	 }
 function chkaction(){ 
	 form.action = form.select.options[form.select.selectedIndex].value; 
	 document.form.submit();        
	 } 
 function Search(){

	 	var s1=document.getElementById("select").options[document.getElementById("select").selectedIndex].value;
	 	console.log(s1);
	 	if(s1=="GET"){
			console.log(123);
			document.getElementById("form").method="get";
			var m1 =document.getElementById("form").method;
			console.log(m1);
	 	}
	 	else if(s1=="POST"){
			console.log(321);
			document.getElementById("form").method="post";
			var m2=document.getElementById("form").method;
			console.log(m2);
	 	}
 }
 function btn(){
	 alert("保存成功");
 }
 </script>
    
</body>
</html>