<%@page import="com.ada.test.cases.BatchInsertTestCase"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
	String _maxThreads = request.getParameter("batchSize");
	BatchInsertTestCase.start();
%>
<h1>测试进行中...</h1>
<%
out.print(BatchInsertTestCase.counter.toString());
%>
<title>批量写入测试</title>

<form action="batchstop.jsp">
	<button type="submit">停止</button>
</form>

<script type="text/javascript">
	setTimeout("gotoRunning()" ,2000);
	
	function gotoRunning(){
		window.location.href = '/batchrunning.jsp';
	}
</script>