<%@page import="com.ada.test.ThreadTest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String _maxThreads = request.getParameter("maxThreads");
ThreadTest.start(Integer.valueOf(_maxThreads), null);
%>
<h1>测试进行中...</h1>
<%
out.print(ThreadTest.counter.toString());
%>
<!DOCTYPE script PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>

<form action="stop.jsp">
	<button type="submit">停止</button>
</form>

<script type="text/javascript">
	setTimeout("gotoRunning()" ,2000);
	
	function gotoRunning(){
		window.location.href = '/running.jsp';
	}
</script>



</body>
</html>


