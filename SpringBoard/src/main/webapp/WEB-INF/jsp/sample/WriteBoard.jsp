<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/WEB-INF/include/include-header.jspf"%>
<title>게시글 쓰기</title>

<script type="text/javascript">
	$(document).ready(function() {

	});

	function saveContents() {
		var comSubmit = new ComSubmit("frm");
		comSubmit.setUrl("<c:url value='/sample/saveBoard.do' />");
		comSubmit.submit();
	}

	function getList() {
		var comSubmit = new ComSubmit();
		comSubmit.setUrl("<c:url value='/sample/service/openSampleBoardList.do' />");
		comSubmit.submit();
	}
</script>


</head>
<body>
	<form name="frm" id="frm">
		<h1>글작성</h1>
		<table class="board_view">
			<colgroup>
				<col width="20%" />
				<col width="40%" />
				<col width="40%" />
			</colgroup>
			<tbody>
				<tr>
					<th>제목</th>
					<td colspan="2"><input name="TITLE" id="TITLE" value=""></td>
				</tr>
				<tr>
					<td colspan="3" class="view_text"><textarea style="width:95%;" name="CONTENT"
							id="CONTENT" rows="20"></textarea></td>

				</tr>
				<tr>
					<td colspan="2"><input type="button" class="btn" onclick="saveContents()"
						value="저장"> <input type="button" class="btn" onclick="getList()" value="취소">
					</td>
				</tr>
			</tbody>
		</table>
	</form>
	<%@ include file="/WEB-INF/include/include-body.jspf"%>

</body>
</html>