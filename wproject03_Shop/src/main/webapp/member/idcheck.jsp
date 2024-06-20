<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:useBean id="memberMgr" class="pack.member.MemberMgr" />

<%
String id = request.getParameter("id");
boolean b = memberMgr.idCheckProcess(id); // ID 유무 확인
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ID 검사</title>
<link href="../css/board.css" rel="stylesheet" type="text/css">
<script src="../js/script.js"></script>
</head>
<body style="text-align: center; margin-top: 30px;">
<b><%=id %></b>
<%
if(b) {
%>
	: 이미 사용중인 ID입니다.<p/>
	<a href="#" onclick="opener.document.regForm.id.focus();window.close()">닫기</a> <!-- false >> ID에 포커스 위치 -->
<%}else {%>	
	: 사용 가능한 ID입니다.<p/>
	<a href="#" onclick="opener.document.regForm.passwd.focus();window.close()">닫기</a> <!-- true >> Password에 포커스 위치 -->
<%
}
%>

</body>
</html>