<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList" %>
<%@page import="hx.com.modle.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>test</title>

</head>
<body>
	<form action="add" method="post">
	要添加的名字<input type='text' name='name'><br>
			<input type = 'submit' value = '提交'>
	</form>
	<br>
	<form action="delete" method="post">
	要删除的id<input id="delete" type='text' name='userId'><br>
			<input id="deleteTest" type = 'submit' value = '提交'>
	</form>
	<br>
	<div>修改名字</div>
	<form action="update" method="post">
		用户名id<input type='text' name='id'><br>
		新的用户名<input type='text' name='name'><br>
			<input type = 'submit' value = '提交'>
	</form>
	<br>
	<div>根据名字查询用户</div>
	<form action="findUserByName" method="post">
		用户名<input id="ajax" type='text' name='name'><br>
			<input type = 'submit' value = '提交'>
	</form>
	<br>
	<div>根据用户名字查询用户列表</div><br>
	<table id="myTable">
	</table><br>
	<div>所有用户列表</div>
	<table>
	<%
	ArrayList<User> list = (ArrayList<User>)request.getAttribute("list");
	if(list.size()!=0)
		for(User user:list)
		{
		%>
		<tr>
			
			<td>用户id：</td><td><%=user.getId() %></td>
			<td>用户名：</td><td><%=user.getName() %></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js"></script>
<script src="/test-ssh/javascript/validateId.js" ></script>
<script src="/test-ssh/javascript/dynamicQuery.js" ></script>
</html>