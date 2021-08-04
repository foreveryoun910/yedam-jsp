<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SNS 조회</title>
</head>
<body>
	<div align="center">
		<div><h1>게시글 조회</h1></div>
		<div>
			${list[0].STitle}
		</div>
		<div><h5>댓글</h5></div>
		<div>
			<c:forEach var="reply" items="${list}">
				${reply.CNo} : ${reply.CSubject}
			</c:forEach>
		</div>
	</div>
</body>
</html>