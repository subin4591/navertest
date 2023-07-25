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
		String file = (String)request.getAttribute(RequestDispatcher.ERROR_REQUEST_URI);
		
		out.println("<h3>[오류코드] " + code + "</h3>");
		out.println("<h3>[오류파일]" + file + "</h3>");
		out.println("<h3>처리할 메소드나 뷰가 없습니다.</h3>");
	%>
</body>
</html>