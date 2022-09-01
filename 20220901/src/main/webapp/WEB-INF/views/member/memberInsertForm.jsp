<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>멤버 등록</h1>
<div>
	<form id="frm" action="memberInsert.do" method="post">
		<div>
		 <table border="1">
			<tr>
				<td>아이디</td>
				<td>
					<input type="text" id="memberId" name="memberId">
				</td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td>
					<input type="password" id="memberPassword" name="memberPassword">
				</td>
			</tr>
			<tr>
				<td>이름</td>
				<td>
					<input type="text" id="memberName" name="memberName">
				</td>
			</tr>
			<tr>
				<td>권한</td>
				<td>
					<select id="memberAuthor" name="memberAuthor">
								<option>-------</option>
								<option value="ADMIN">관리자</option>
								<option value="USER">회원</option>
					</select>
				</td>
			</tr>
		 </table>
		 <br>
		</div>
		<input type="submit" value="등록">
		<input type="reset" value="취소">
		
	</form>
</div>

</body>
</html>