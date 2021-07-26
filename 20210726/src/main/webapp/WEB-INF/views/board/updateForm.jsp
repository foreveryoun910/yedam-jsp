<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>게시글 수정</title>
	<script type="text/javascript">
		function getRecord(n) {
			frm.bId.value = n; // 폼이 가지고 있는 bId 변수에 넘어온 value값을 n에 대입
			frm.submit();
		}
	</script>
</head>
<body>
	<div align="center">
		<div>
			<h1>게시글 수정</h1>
		</div>
		<form id="frm" name="frm" action="updateBoard.do" method="post">
			<div>
				<table border="1" style="border-collapse: collapse;">
					<tr>
						<th width="100">글번호</th>
						<td width="70" align="center">${ board.bId }
						<input type="hidden" id="bId" name="bId" value="${ board.bId }">
						</td>
						<th width="100">작성자</th>
						<td width="150" align="center">${ board.bWriter }</td>
						<th width="100">작성일자</th>
						<td width="150" align="center">${ board.bDate }</td>
						<th width="100">조회수</th>
						<td width="70" align="center">${ board.bHit }</td>
					</tr>
					<tr>
						<th width="100">글제목</th>
						<td colspan="7"><input type="text" id="bTitle" name="bTitle"
							size="106" required="required" value="${ board.bTitle }"></td>
					</tr>
					<tr>
						<th width="100">글내용</th>
						<td colspan="7"><textarea rows="7" cols="110" id="bContent"
								name="bContent" required="required">${ board.bContent }</textarea>
						</td>

					</tr>
				</table>
			</div>
			<br>
			<div>
				<button type="submit">수정</button>
				&nbsp;&nbsp;&nbsp;
				<button type="reset">취소</button>
				&nbsp;&nbsp;&nbsp;
				<button type="button" onclick="location.href='boardList.do'">목록</button>
			</div>
		</form>
	</div>
</body>
</html>