<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>登录</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
	#box{
		height:430px;
		width:410px;
		border:1px #ccc solid ;
		position:absolute;
    	left:800px;
    	top:300px;
    	transform:translate(-100%,-50%);
	}

	table{
		position:relative;
		left:90px;
		top:120px;
		
	}
	input{
		width:180px;
		margin-top:10px;
		border-radius:2px;
	}
	#btn{
	margin-left:38px;
	background-color:#39B3FF;
	color:white;
	}
	#t1{
		position:relative;
		left:150px;
		top:40px;
	}
	#t2{
		position:relative;
		left:-10px;
		top:90px;
	}
</style>
</head>
<body>
<div id="box">
	<img id="t1"src="images/1.png">
	<img id="t2"src="images/2.png">
	<form action="/testplatform/LoginServlet" method="post">
		<table>
			<tr>
				<td>账号:<input type="text" id="userName" name="userName" value=""/></td>
			</tr>
			<tr>
				<td>密码:<input type="password" id="password" name="password" /></td>
			</tr>
			<tr>
				<td><input type="submit" id="btn" value="登录"  /></td>
			</tr>
	
		</table>
	</form>
</div>

</body>
</html>