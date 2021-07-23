<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원조회</title>
</head>
<body>
	<div align="center">
		<div>
			<h1>회원조회</h1>
		</div>
		<div>
			<form id="frm" name="frm" action="memberSearch.do" method="post">
				<table border="1">
					<tr>
						<th width="250">조회할 회원 아이디 입력</th>
						<td width="150"><input type="text" id="id" name="id">
						</td>
						<td width="100"><input type="submit" value="검색"></td>
					</tr>
				</table><br>
				<button type="button" onclick="location.href='main.do'">홈으로 돌아가기</button>
			</form>
		</div>
	</div>
</body>
</html>