<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
// 자바 영역
String name = request.getParameter("writer"); // request : 클라이언트에게 받을 때
String title = request.getParameter("subject");
String age = request.getParameter("age");
String content = request.getParameter("content");

System.out.println(name + " " + title + " " + age + " " + content);
%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- HTML 영역 -->
이름 : <%=name %><br><br/>
제목 : <%=title %><br><br/>
내용 : <%=content%>
</body>
</html>