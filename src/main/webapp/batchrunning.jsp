<%@page import="com.ada.test.ThreadTest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h1>测试进行中...</h1>
<%
out.print(BatchInsertTestCase.counter.toString());
%>
<style type="text/css">
body button {
	font-size: 20px;
}
</style>
<script type="text/javascript">
	setTimeout("window.location.href = '/batchrunning.jsp'" ,2000);
</script>

<br/>
<br/>
<form action="batchstop.jsp">
	<button type="submit">停止</button>
</form>