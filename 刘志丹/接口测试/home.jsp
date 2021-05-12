<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>项目管理</title>
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
  <div class="right">
  <div class="top2">
   <div class="box1">
     <span style="font-size:20px;">项目</span>
     <span class="count">0</span>
   </div>
   <div class="box2">
     <span style="font-size:20px;">接口</span>
     <span class="count">0</span>
   </div>
   <div class="box3">
    <span style="font-size:20px">用例</span>
     <span class="count">0</span>
   </div>
   <div class="box4">
    <span style="font-size:20px;">用例集</span>
     <span class="count">0</span>
   </div>
  </div>
 </div>
    
</body>
</html>
