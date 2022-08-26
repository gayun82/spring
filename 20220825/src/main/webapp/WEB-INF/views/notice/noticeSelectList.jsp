<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 목록</title>
<!-- <script src="resources/js/jquery-3.6.0.min.js"></script> -->
</head>
<body>
	<div align="center">
	 <div><h1>공지사항 목록</h1></div>
	 <div>
	 	<table>
	 		<tr>
	 			<td width="70">
	 				<select id="key" name="key">
	 					<option value="1">제목</option>
	 					<option value="2">내용</option>
	 					<option value="3">작성자</option>
	 				</select>
	 			</td>
	 			<td width="100">
	 				<input type="text" id="val" name="val">
	 			</td>
	 			<td width="100" align="center">
	 				<button type="button" onclick="searchCall()">검색</button>
	 			</td>
	 		</tr>
	 	</table>
	 	
	 </div>
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


<script type="text/javascript">
	function noticeCall(id){
		frm.noticeId.value=id;
		frm.action = "noticeSelect.do";
		frm.submit();
	}
	
	 function searchCall(){//ajax 검색처리
		 let key = document.getElementById('key').value;
		 let val = document.getElementById('val').value;
		 
		 fetch("ajaxSearch.do",{
			 method      : 'post',
			 headers :{
				 'Content-Type' : 'application/x-www-form-urlencoded',
			 },
			 body     : "key="+key+"&val="+val
		 }).then(response => response.json())//결과를 제이슨타입으로 변환
		   .then((date) => htmlView(date)) //html convert method가 필요하다
	 } 
			//json형태로 값을 전달할 때	
			headers:{
				'Content-Type' : 'application/json',
			},
			body : JSON.stringify({'key':key, 'val':val})
	
	 
	/*  function searchCall(){
		 let key = document.getElementById('key').value;
		 let val = document.getElementById('val').value;
		 $.ajax({
				url : "ajaxSearch.do",
				type : "post",
				data : {"key":key, "val":val},
				dataType : "json",
				success : function(response){
					console.log(response);
					htmlView(response);
					},
				error : function(){

				}
			});
	 } */
	 function htmlView(data){
		 //html로 변환해서 원하는 위치에 출력하도록 구현한다.
	 }
</script>
</body>
</html>