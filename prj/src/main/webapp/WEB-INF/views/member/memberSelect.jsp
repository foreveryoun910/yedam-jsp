<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원 조회</title>
</head>
<body>
	<div align="center">
		<div><h1>회원 조회</h1></div>
		<div>
			<table border="1">
				<tr>
					<th width="100">아이디</th>
					<th width="100">이름</th>
					<th width="100">나이</th>
					<th width="300">취미</th>
				</tr>
				<tr>
					<td>${ member.id }</td>
					<td>${ member.name }</td>
					<td>${ member.age }</td>
					<td>${ member.hobby }</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>