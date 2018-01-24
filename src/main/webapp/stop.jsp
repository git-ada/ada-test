<%@page import="com.ada.test.ThreadTest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ThreadTest.stop();
%>

<h1>测试已停止...</h1>
<script type="text/javascript">
	setTimeout("window.location.href = '/index.jsp'" ,2000);
</script>