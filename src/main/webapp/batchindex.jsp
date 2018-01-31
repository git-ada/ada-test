<%@page import="com.ada.test.cases.BatchInsertTestCase"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>压力测试</title>
<style type="text/css">
body,button,input{
	font-size: 20px;
}
</style>
</head>
<body>
<% if(BatchInsertTestCase.testing){%>
<script type="text/javascript">
	window.location.href = "/batchrunning.jsp";
</script>
<%} else{ %>
	
	<h1>开始测试：</h1>
	<br/>
	<br/>
	<form action="batchstart.jsp">
		<button type="submit">开始</button>
	</form>
<%}%>


</body>
</html>