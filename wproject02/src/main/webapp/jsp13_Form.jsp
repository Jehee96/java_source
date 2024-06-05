<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");

//String name = request.getParameter("name"); // 과거에는 이랬다.
%>

<jsp:useBean id="bean" class="pack.ExamBean"/>
<!--
<jsp:setProperty property="name" name="bean" /> // 수신값이 적을 때
  -->
  
<!-- property="*" : 수신된 값이 자동으로 ExamBean의 멤버필드로 저장된다. 약속이 맞지 않으면 자동으로 처리되지 않는다. -->
<jsp:setProperty property="*" name="bean"/>
  
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
FormBean에 등록된 자료 출력하기<br><br>
이름 : <jsp:getProperty property="name" name="bean"/><br>
국어 : <jsp:getProperty property="kor" name="bean"/>&nbsp;&nbsp;
영어 : <jsp:getProperty property="eng" name="bean"/>&nbsp;&nbsp;
수학 : <jsp:getProperty property="mat" name="bean"/><br>

<jsp:useBean id="process" class="pack.ExamProcess" />
<jsp:setProperty property="bean" name="process" value="<%=bean %>"/> <!-- setBean 부르기 -->
총점 : <jsp:getProperty property="tot" name="process"/>
<br>
평균 : <jsp:getProperty property="avg" name="process"/>
</body>
</html>