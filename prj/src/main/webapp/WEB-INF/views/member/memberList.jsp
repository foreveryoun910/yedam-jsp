<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원 리스트</title>
	
	<script type="text/javascript">
		function getRecord(n) {
			frm.id.value = n;
			frm.submit();
		}
	</script>
	
	<style>
		tr.h:hover {
			background: gold;
		}
	</style>
</head>
<body>
	<div align="center">
		<div>
			<h1>회원 리스트</h1>
		</div>
		<div>
			<table border="1">
				<tr>
					<th width="100">아이디</th>
					<th width="100">이름</th>
					<th width="100">나이</th>
					<th width="300">취미</th>
				</tr>
				<c:forEach var="member" items="${ list }">
					<tr class="h" onclick="getRecord('${ member.id }')">
						<td>${ member.id }</td>
						<td>${ member.name }</td>
						<td>${ member.age }</td>
						<td>${ member.hobby }</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div>
			<form id="frm" name="frm" action="memberSelect.do" method="post">
				<input type="hidden" id="id" name="id">
			</form>
		</div>
	</div>
</body>
</html>