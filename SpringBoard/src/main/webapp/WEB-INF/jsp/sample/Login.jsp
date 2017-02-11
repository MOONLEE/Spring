<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/WEB-INF/include/include-header.jspf"%>
<title>로그인</title>
<script type="text/javascript">
	$(document).ready(function() {

	});
	
	function doLogin() {
		var comSub = new ComSubmit("frm");
		comSub.setUrl("<c:url value='/sample/service/doLogin.do' />");
		comSub.submit();
	}
	
	function doJoin() {
		var comSub = new ComSubmit();
		comSub.setUrl("");
		comSub.submit();
	}	
</script>
</head>
<body>
	<form name="frm" id="frm">
		<table class="board_view">
			<colgroup>
				<col width=30% />
				<col width=* />
			</colgroup>
			<tbody>
				<tr>
					<th>아이디</th>
					<td><input type="text" id="USER_ID" name="USER_ID" value="" /></td>
				</tr>
				<tr>
					<th>패스워드</th>
					<td><input type="password" id="USER_PW" name="USER_PW"
						value="" /></td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="2">
						<input type="button" value="로그인" onclick="doLogin();">
						<input type="button" value="회원가입" onclick="doJoin();">
						</td>
				</tr>
				<c:if test="${resultmap.SUCCESS_YN eq 'N'}">
					<tr>
						<td colspan="2">
							로그인을 실패하였습니다.
						</td>
					</tr>
				</c:if>			
			</tfoot>
		</table>
	</form>

	<%@ include file="/WEB-INF/include/include-body.jspf"%>
</body>
</html>