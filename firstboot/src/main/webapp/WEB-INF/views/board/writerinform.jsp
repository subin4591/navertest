<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>WriterInform</title>
	<script src="/js/jquery-3.6.4.min.js"></script>
	<script>
		$(document).ready(function() {
			
		});
	</script>
</head>
<body>
	<h1>작성자 정보</h1>
	<h3>[번호] ${ writerDto.seq }</h3>
	<h3>[제목] ${ writerDto.title }</h3>
	<h3>[내용] ${ writerDto.contents }</h3>
	<h3>[글암호] ${ writerDto.pw }</h3>
	<h3>[ID] ${ writerDto.member.member_id }</h3>
	<h3>[PW] ${ writerDto.member.pw }</h3>
	<h3>[이름] ${ writerDto.member.name }</h3>
	<h3>[E-mail] ${ writerDto.member.email }</h3>
	<h3>[Phone] ${ writerDto.member.phone }</h3>
	<h3>[가입일] ${ writerDto.member.regtime }</h3>
</body>
</html>