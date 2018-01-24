<%@page import="com.ada.test.ThreadTest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ThreadTest.stop();
%>
测试已停止...
<script type="text/javascript">
	setTimeout(back() ,2000);
	
	function back() {
		window.location.herf = "/index.jsp";
	}
</script>