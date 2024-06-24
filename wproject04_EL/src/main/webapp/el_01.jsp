<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL</title>
</head>
<body>
<pre style="font-size: 15px">
🚀 EL(Expression Language)
 - JSP Script 표현식을 대신해 속성 값을 쉽게 출력하기 위한 언어
 - 출력, 반복 처리를 태그 기반으로 제공
 - 웹 디자이너와 프로그래머의 업무분리가 가능
</pre>

<h2>Hello, EL!</h2>
<%
if(request.getParameter("userName") == null) {
%>
	<jsp:forward page="el_01.html" />
<%
}
%>	
사용자가 전송한 userName 출력<br>
1-1) JSP Script 사용 : 
<% out.println(request.getParameter("userName")); %>
<br>
1-2) JSP 표현식 사용 : 
<%=request.getParameter("userName") %>
<br>
2) EL 내장객체 param 사용 : 
${param.userName }
</body>
</html>