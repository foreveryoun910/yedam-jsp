<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원가입</title>
</head>
<body>
	<div align="center">
		<div>
			<h1>회 원 가 입</h1>
		</div>
		<div>
			<form id="frm" name="frm" action="memberInsert.jsp" method="post">
				<div>
					<table border="1">
						<tr>
							<th width="200px">아 이 디</th>
							<td width="300px">
								<input type="text" id="id" name="id">
							</td>
						</tr>
						<tr>
							<th width="200px">패스워드</th>
							<td width="300px">
								<input type="password" id="password" name="password">
							</td>
						</tr>
						<tr>
							<th width="200px">이    름</th>
							<td width="300px">
								<input type="text" id="name" name="name">
							</td>
						</tr>
						<tr>
							<th width="200px">나    이</th>
							<td width="300px">
								<input type="text" id="age" name="age">
							</td>
						</tr>
						<tr>
							<th width="200px">취    미</th>
							<td width="300px">
								<label>								
									<input type="checkbox" id="hobby" name="hobby" value="등산">등산
								</label>
								<label>								
									<input type="checkbox" id="hobby" name="hobby" value="바둑">바둑
								</label>
								<label>								
									<input type="checkbox" id="hobby" name="hobby" value="독서">독서
								</label>
										<label>								
									<input type="checkbox" id="hobby" name="hobby" value="여행">여행
								</label>
							</td>
						</tr>																								
					</table>
				</div><br>
				<div>
					<input type="submit" value="회원가입">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="reset" value="취소">
				</div>
			</form>
		</div>
	</div>
</body>
</html>