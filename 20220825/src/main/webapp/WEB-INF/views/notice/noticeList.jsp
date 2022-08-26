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
<div align="center">
	<div><h1>공지사항 목록</h1></div>
	<div>
		<table border="1">
			<thead>
				<tr>
					<th width="100">순번</th>
					<th width="150">작성자</th>
					<th width="250">제목</th>
					<th width="150">작성일자</th>
					<th width="100">조회수</th>
					<th width="70">첨부파일</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${empty notices }">
					<tr>
						<td colspan="6" align="center">
						   게시글이 존재하지 않습니다.
						</td>
					</tr>
				</c:if>
				<c:forEach items="${notices }" var="N">
					<tr class="colored" onclick="noticeCall(${N.NOTICE_ID})">
						<td align="center">${N.NOTICE_ID}</td>
						<td align="center">${N.NOTICE_WRITER }</td>
						<td>&nbsp;${N.NOTICE_TITLE }</td>
						<td align="center">${N.NOTICE_DATE }</td>
						<td align="center">${N.NOTICE_HIT }</td>
						<c:choose>
							<c:when test="${not empty N.NOTICE_ATTECH }"> 
								<td align="center">@</td>
							</c:when>
							<c:otherwise>
								<td align="center"></td>
							</c:otherwise>
						</c:choose>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div>
		<form id="frm" method="post">
			<input type="hidden" id="noticeId" name="noticeId">
		</form>
	</div>
</div>

<script type="text/javascript">
	function noticeCall(id){
		frm.noticeId.value=id;
		frm.action = "noticeSelect.do";
		frm.submit();
	}
</script>
</body>
</html>