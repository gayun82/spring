<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body align="center">
	<div><h1>로그인</h1></div>
	<div align="center">
		<form id="frm" action="memberLogin.do" method="post">
			<div>
				<table border="1">
					<tr>
						<th width="150">아이디</th>
						<td width="200">
							<input type="text" id="member_id" name="member_id">
						</td>
					</tr>
					<tr>
						<th>패스워드</th>
						<td>
							<input type="password" id="member_password" name="member_password">
						</td>
					</tr>
				</table>
			</div><br>
			<input type="submit" value="로그인">
			<input type="reset" value="취소"> 
		</form>
	</div>
</body>
</html>