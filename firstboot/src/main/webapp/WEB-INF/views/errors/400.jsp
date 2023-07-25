<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Error 404</title>
</head>
<body>
	<h1 style="color: red">오류 발생</h1>
	<%
		int code = (Integer)request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		String param = (String)request.getAttribute(RequestDispatcher.FORWARD_QUERY_STRING);
		
		out.println("<h3>[오류코드] " + code + "</h3>");
		out.println("<h3>[파라미터정보]" + param + "</h3>");
		out.println("<h3>요청 파라미터를 확인하세요.</h3>");
	%>
</body>
</html>