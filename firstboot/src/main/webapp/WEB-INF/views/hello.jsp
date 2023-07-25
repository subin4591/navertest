<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Hello</title>
	<script src="/js/jquery-3.6.4.min.js"></script>
	<script>
		$(document).ready(function() {
			$("#ajaxbtn").on("click", function() {
				$.ajax({
					url: "helloajax",
					type: "get",
					dataType: "JSON",
					success: function(server) {
						$("#result").html(server.model);
					},
					error: function(error) {
						
					}
				});
			});
		});
	</script>
</head>
<body>
	<h1>hello.jsp 파일입니다.</h1>
	<h2>${ model }</h2>
	
	<img src="/images/html5.jpg"><br>
	<img src="/upload/drinks.jpg"><br>
	
	<input type="button" value="ajax요청버튼" id="ajaxbtn">
	ajax 결과 출력 <h1 id="result"></h1>
</body>
</html>