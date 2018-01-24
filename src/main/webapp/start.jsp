<%@page import="com.ada.test.ThreadTest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String _maxThreads = request.getParameter("maxThreads");
ThreadTest.start(Integer.valueOf(_maxThreads), null);
%>
测试进行中...
<%
out.print(ThreadTest.counter.toString());
%>

<script type="text/javascript">
	setTimeout(refulsh() ,2000);
	
	function refulsh() {
		window.location.herf = "/start.jsp";
	}
</script>


<form action="stop.jsp">
	<button type="submit">停止</button>
</form>