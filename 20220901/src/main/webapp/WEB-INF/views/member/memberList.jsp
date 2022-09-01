<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원목록</h1>
<c:forEach items="${members}" var="m">
	아이디: ${m.memberId}
	패스워드: ${m.memberPassword}
	이름: ${m.memberName}
	권한: ${m.memberAuthor}<br>


</c:forEach>
<br>
<a href="memberInsertForm.do">회원 등록</a>
</body>
</html>