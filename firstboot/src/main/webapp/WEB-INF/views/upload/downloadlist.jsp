<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>DownloadList</title>
</head>
<body>
	<h1>다운로드 목록</h1>
	<c:forEach items="${ fileArr }" var="filename">
		<h3><a href="filedownloadresult?filename=${ filename }">${ filename }</a> 다운로드</h3>
	</c:forEach>
</body>
</html>