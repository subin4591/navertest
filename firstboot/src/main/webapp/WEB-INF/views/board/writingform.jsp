<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>WritingForm</title>
</head>
<body>
	<form action="boardwrite" method="post">
		제목 <input type="text" name="title"><br>
		내용 <textarea rows="5" cols="50" name="contents">내용을 입력하세요.</textarea><br>
		작성자 <input type="text" name="writer" value="${ sessionid }" readonly><br>
		글암호 <input type="password" name="pw"><br>
		<input type="submit" value="글저장">
	</form>
	<h3><a href="/">시작페이지로</a></h3>
</body>
</html>