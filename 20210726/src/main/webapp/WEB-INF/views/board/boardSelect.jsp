<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>공지 상세 보기</title>
	<script type="text/javascript">
		function getPath(n) {
			if(n == 1) {
				getPath = "updateForm.do";
			} else {
				getPath = "deleteBoard.do";
			}
			frm.submit();
		}
	</script>
</head>
<body>
	<div align="center">
		<div><h1>게시글 상세 보기</h1></div>
		<div>
			<table border="1" style="border-collapse: collapse;">
				<tr>
					<th width="100">글번호</th>
					<td width="70" align="center">${ board.bId }</td>
					<th width="100">작성자</th>
					<td width="150" align="center">${ board.bWriter }</td>
					<th width="100">작성일자</th>
					<td width="150" align="center">${ board.bDate }</td>
					<th width="100">조회수</th>
					<td width="70" align="center">${ board.bHit }</td>
				</tr>
				<tr>
					<th width="100">글제목</th>
					<td colspan="7">${ board.bTitle }</td>
				</tr>
				<tr>
					<th width="100">글내용</th>
					<td colspan="7">
						<textarea rows="7" cols="110">${ board.bContent }</textarea>
					</td>
					
				</tr>
			</table>
		</div><br>
		<div>
			<button type="button" onclick="location.href='boardList.do'">목록</button>&nbsp;&nbsp;&nbsp;
			<button type="button" onclick="getPath(1)">수정</button>&nbsp;&nbsp;&nbsp;
			<button type="button" onclick="getPath(2)">삭제</button>
		</div>
		<form id="frm" name="frm" action="" method="post">
			<input type="hidden" id="bId" name="bId" value="${ board.bId }">
		</form>
	</div>
</body>
</html>