<!-- page 지시어는 맨 위에. 이 위에 다른 것들은 적지 않는다. (xml같은 경우 예외) -->
<%@page import="org.eclipse.jdt.internal.compiler.ast.ThisReference"%>
<%@page import="java.time.ZoneId"%>
<%@ page
language="java"
contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" 
import="java.time.LocalDate" 
import="java.sql.*, java.util.*"
session="true"
buffer="8kb"
autoFlush="true"
isThreadSafe="true"
info="jsp 문서 정보를 기술"
errorPage="jsp02_error.jsp"
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>page 지시어 관련</h2>
페이지 지시어는 jsp 문서의 앞에서 꼭 필요한 것만 적어 준다.
<hr>
⏰ 날짜 및 시간 출력<br>
<%
LocalDate localDate = LocalDate.now(ZoneId.of("Asia/Seoul"));
int year = localDate.getYear();
int month = localDate.getMonthValue();
int day = localDate.getDayOfMonth();
out.println("오늘은 " + year + "년 " + month + "월 " + day + "일");
%>
<br><br>
<%= this.getServletInfo() %>
<br><br>
<%
int num1 = 20; // 이 변수는 외부에서 주어지는 값을 기억하기 위함
int num2 = 5;
out.print("나누기 결과 : " + num1 / num2);
%>

</body>
</html>