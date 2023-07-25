<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Start</title>
	<script src="/js/jquery-3.6.4.min.js"></script>
	<script>
		$(document).ready(function() {
			$("#writinglink").on("click", function(e) {
				let sessionid = <%= session.getAttribute("sessionid") %>;
				if (sessionid == null) {
					e.preventDefault();
					alert("로그인이 필요합니다.");
				}				
			});
		});
	</script>
</head>
<body>
	<h1 style="color: red">[로그인 여부] ${ sessionid }</h1>
	<h1>나의 게시판 시작화면</h1>
	<h2>메뉴</h2>
	<ul>
		<li><a href="boardlist">게시물 리스트</a> (로그인 필요 X)</li>
		<li><a id="writinglink" href="boardwrite">글쓰기</a> (로그인 필요 O)</li>
		<li><a href="boardlogin">로그인</a></li>
		<li><a href="boardlogout">로그아웃</a></li>
	</ul>
</body>
</html>