<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Error 500</title>
</head>
<body>
	<h1 style="color: red">오류 발생</h1>
	<%
		int code = (Integer)request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		
		out.println("<h3>[오류코드] " + code + "</h3>");
		out.println("<h3>서버 내부 오류</h3>");
		out.println("<h3>" + exception + "</h3>");
	%>
</body>
</html>