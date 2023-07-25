<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>BoardLogin</title>
</head>
<body>
	<h1>로그인폼</h1>
	<form action="boardlogin" method="post">
		ID <input type=text name="member_id" ><br>
		PW <input type=password name="pw"><br>
		<input type=submit value="로그인">
	</form>
	<h3><a href="/">시작페이지로</a></h3>
</body>
</html>