<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Detail</title>
	<script src="/js/jquery-3.6.4.min.js"></script>
	<script>
		$(document).ready(function() {
			$("#deletebtn").on("click", function() {
				let inputPw = prompt("암호를 입력하세요");
				let dbPw = ${ dto.pw };
				
				if (inputPw == dbPw) {
					location.href = "boarddelete?seq=${ dto.seq }";	
				}
				else {
					alert("암호를 확인하세요.");
				}
			});
			$("#updatebtn").on("click", function() {
				let inputPw = prompt("암호를 입력하세요");
				let dbPw = ${ dto.pw };
				
				if (inputPw == dbPw) {
					$("form").attr({
						"action": "boardupdate",
						"method": "post"
					});
					$("form").submit();
				}
				else {
					alert("암호를 확인하세요.");
				}
			});
		});
	</script>
</head>
<body>
	<form>
		<table border="3px">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>날짜</th>
			<th>조회수</th>
		</tr>
		<tr>
			<td><input type="text" name="seq" value="${ dto.seq }" style="width: 20px;" readonly></td>
			<td width="200px"><input type="text" name="title" value="${ dto.title }"></td>
			<td width="80px">${ dto.writer }</td>
			<td>${ dto.writetime }</td>
			<td>${ dto.viewcount }</td>
		</tr>
		<tr>
			<td colspan="5">
				<textarea rows=10 cols=70 name="contents">${ dto.contents }</textarea>
			</td>
		</tr>
		</table>
		<input type="button" value="수정" id="updatebtn">
		<input type="button" value="삭제" id="deletebtn">
	</form>
	<h3><a href="boardlist">리스트로</a></h3>
	<h3><a href="/">시작페이지로</a></h3>
</body>
</html>