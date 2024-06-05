<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String mbc = request.getParameter("message");
%>

<jsp:useBean id="my" class="pack.Para01_Class"></jsp:useBean>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<b>Bean 연습 : 빈드에 값 전달</b>
<%
// 비권장!!!!
// 우리가 현재까지 알고 있는 기술 사용
my.setMsg(mbc);
out.println("<br>메세지 출력 : " + my.getMsg());
%>
<br>
<!-- JSP에서 만들 때 권장함. -->
<!-- String msg = request.getParameter("msg"); 내부적으로 자동 처리 -->
<jsp:setProperty property="msg" name="my"/> <!-- Setter 부르기 -->
<br>메세지 출럭(Action Tag 사용) : 
<jsp:getProperty property="msg" name="my"/>
</body>
</html>