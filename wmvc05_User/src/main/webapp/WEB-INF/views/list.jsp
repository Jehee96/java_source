<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="loginCheck.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>🪧 사용자 목록</h3>
<table border="1">
	<tr>
		<th>아이디</th><th>이름</th><th>이메일</th>
	</tr>
	
<c:forEach var="u" items="${list}">
	<tr>
		<td>${u.userid}</td>
		<td><a href="view.m2?userid=${u.userid}">${u.name}</a></td> <!-- 상세보기 -->
		<td>${u.email}</td>
	</tr>
</c:forEach>
</table>
<br><a href="insert.jsp">👉사용자 추가</a>&nbsp;&nbsp;<a href="logout.m2">🖐️로그아웃</a>
</body>
</html>