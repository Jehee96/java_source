<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// Session 읽기
HttpSession ses = request.getSession(false);

// 로그인 성공했을 때
if(ses != null && ses.getAttribute("userid") != null) {
	String userid = (String)ses.getAttribute("userid"); // ok

%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>로그인 성공 페이지</h2>
<p>환영합니다. <%=userid %>님</p>
인증에 성공한 경우 처리할 뭔가를 작업 Authorization(인가)
<br>
쇼핑, 게시판, 방명록, 회의 참여..
<br>
<a href="jsp09_Logout.jsp">로그아웃</a>
</body>
</html>
<% 
}else{
	// 로그인 없이 호출된 경우(로그인 실패)
	response.sendRedirect("jsp09_SessionLogin.html");
}
%>