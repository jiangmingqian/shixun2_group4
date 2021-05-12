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
<script language="JavaScript" src="js/project.js"></script>
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
  	<ul class="level">
  		<li>Admin
  			<ul class=tow>
  				<li ><a>修改密码</a></li>
  				<li><a href="/testplatform/LogoutServlet">退出</a></li>
  			</ul>
  		</li>
  	</ul>
  </div>
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
  <div class="top">
    <input type="text" id="url" value="请输入项目名"/>
    <input type="submit" value="搜索" id="button1"/>
    <input type="submit" value="新建" id="button2" onclick='alertFun()'/>
  </div>
  <table class="table1">
   <tr bgcolor=#f5f5f5 height="45">
    <th>序号</th>
    <th>项目名</th>
    <th>创建者</th>
    <th>创建日期</th>
    <th>操作</th>
   </tr>
   </table>
    <form id="formInfo">
   	<p style="margin-top:50px;font-size:16px;float:left;margin-left:20px">序号:</p>
   	<br></br>
   	<input type='text' name='id' style='margin-left:-10px'/>
   	<br></br>
   	<p style="margin-top:50px;font-size:16px;float:left;margin-left:7px">项目名:</p>
   	<br></br>
   	<input type='text' name='projectName' style='margin-top:-48px'/>
   	<br></br>
   	<p style="margin-top:50px;font-size:16px;float:left;margin-left:7px">创建者:</p>
   	<br></br>
   	<input type='text' name='creator' style='margin-top:-40px'/>
   	<br></br>
   	<p style="margin-top:50px;font-size:16px;float:left;margin-left:2px">创建日期:</p>
   	<br></br>
   	<input type='text' name='date' style="margin-top:-50px;margin-right:-3px">
   	<br></br>
   	<div id='confirm' onclick='createTable()' class='buttons'>确定</div>
   	<div id='cancel' onclick='cancelTable()' class='buttons'>取消</div>
   </form>
  </div>

</body>
</html>
