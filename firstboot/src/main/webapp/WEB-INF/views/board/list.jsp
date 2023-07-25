<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>List</title>
</head>
<body>
	<form action="boardsearchlist">
		<select name="item">
			<option value="all">모두</option>
			<option value="title">제목</option>
			<option value="contents">내용</option>
			<option value="writer">작성자</option>
		</select>
		<input type="text" name="word">
		<input type="submit" value="검색">
	</form><br>
	
	<table border="3">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>날짜</th>
			<th>조회수</th>
		</tr>
		<c:forEach items="${ dtolist }" var="dto">
			<tr>
				<td>${ dto.seq }</td>
				<td width="200px"><a href="boarddetail?seq=${ dto.seq }">${ dto.title }</a></td>
				<td width="80px">${ dto.writer }</td>
				<td>${ dto.writetime }</td>
				<td>${ dto.viewcount }</td>
			</tr>
		</c:forEach>	
	</table>
	
	<%
		int totalBoard = (Integer)request.getAttribute("totalBoard");
		int num = (Integer)request.getAttribute("num");
		int totalPage = 0;
		
		if (totalBoard % num == 0)
			totalPage = totalBoard / num;
		else
			totalPage = totalBoard / num + 1;
		
		for (int p = 1; p <= totalPage; p++) {
			out.println("<a href=\"boardlist?page=" + p + "\">[" + p + "페이지]</a> ");
		}
	%>
	
	<h3><a href="/">시작페이지로</a></h3>
</body>
</html>