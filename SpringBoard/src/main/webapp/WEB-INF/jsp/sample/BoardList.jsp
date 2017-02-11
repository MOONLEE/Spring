<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/WEB-INF/include/include-header.jspf"%>
<title>게시판 목록</title>

<script type="text/javascript">
	$(document).ready(function() {

	});

	function writeBoard() {
		var comSubmit = new ComSubmit();
		comSubmit.setUrl("<c:url value='/sample/writeBoard.do' />");
		comSubmit.submit();
	}
</script>

</head>
<body>
	<h1>게시판</h1>
	<table class="board_view">
		<colgroup>
			<col width="10%" />
			<col width="*" />
			<col width="10%" />
			<col width="20%" />
			<col width="10%" />
		</colgroup>
		<thead>
			<tr>
				<th scope="col">순서</th>
				<th scope="col">제목</th>
				<th scope="col">조회수</th>
				<th scope="col">작성일시</th>
				<th scope="col">작성자</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${fn:length(list) > 0}">
					<c:forEach items="${list}" var="row">
						<tr>
							<th>${row.BOARD_SEQ}</th>
							<th>${row.TITLE}</th>
							<th>${row.HIT_CNT}</th>
							<th>${row.CRT_DTM}</th>
							<th>${row.CRT_ID}</th>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<tr>
						<td colspan="5">조회된 결과가 존재하지 않습니다.</td>
					</tr>
				</c:otherwise>
			</c:choose>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="5">
					<input type="button" class="btn" onclick="writeBoard()" value="글쓰기">
				</td>
			</tr>
		</tfoot>
	</table>
	<%@ include file="/WEB-INF/include/include-body.jspf"%>

</body>
</html>