<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="jsp03_top.jsp" %>
<h1>include 연습</h1>
include 지시어 : 여러 JSP 파일에서 공통으로 사용할 부분을 별도 파일로 작성 후 필요할 때 포함해서 쓴다.
<pre>
여기    는
본  문 이   야
</pre>

<%@ include file="jsp03_bottom.jsp" %>
</body>
</html>