<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>공지사항 입력</title>
</head>
<body>
	<div align="center">
		<div><h1>게시글 작성</h1></div>
		<form id="frm" name="frm" action="insertBoard.do" method="post">
				<div>
					<table border="1" style="border-collapse: collapse;">
						<tr>
							<th width="100">작성자</th>
							<td width="100">
								<input type="text" id="bWriter" name="bWriter" size="35" required="required">
							</td>
							<th width="100">작성일자</th>
							<td width="100">
								<input type="date" id="bDate" name="bDate" size="30" >
							</td>
						</tr>
						<tr>
							<th width="100">글제목</th>
							<td colspan="3">
								<input type="text" id="bTitle" name="bTitle" size="68" required="required">
							</td>
						</tr>
						<tr>
							<th width="100">글내용</th>
							<td colspan="3">
								<textarea rows="7" cols="70" id="bContent" name="bContent" required="required" placeholder="내용을 입력하세요."></textarea>
							</td>
							
						</tr>
					</table>
				</div><br>
				<div>
					<button type="submit" onclick="location.href='insertBoard.do'">등록</button>&nbsp;&nbsp;&nbsp;
					<button type="reset">취소</button>&nbsp;&nbsp;&nbsp;
					<button type="button" onclick="location.href='boardList.do'">목록</button>
				</div>
		</form>
	</div>
</body>
</html>