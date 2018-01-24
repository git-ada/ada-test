<%@page import="com.ada.test.ThreadTest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
body button input{
	font-size: 20px;
}

</style>
</head>
<body>
<% if(ThreadTest.running){%>
<script type="text/javascript">
	window.location.herf = "/start.jsp";
</script>
<%} else{ %>

	<form action="stop.jsp">
		进程数 <input name="maxThreads" >
		<button type="submit">开始</button>
	</form>
<%}%>


</body>
</html>