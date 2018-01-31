<%@page import="com.ada.test.cases.BatchInsertTestCase"%>
<%@page import="com.ada.test.ThreadTest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	BatchInsertTestCase.stop();
%>

<h1>测试已停止...</h1>
<script type="text/javascript">
	setTimeout("window.location.href = '/batchindex.jsp'" ,2000);
</script>