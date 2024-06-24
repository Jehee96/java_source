<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>EL 연산자 / 내장객체 경험</h2>
<h4>--- 연산자 ---</h4>
\${3 + 4} ==> ${3 + 4}<br>
\${5 / 4} ==> ${5 / 4} <%-- ${5 div 4} --%><br>
\${5 % 4} ==> ${5 % 4}, %{5 mod 4}<br>

\${5 > 4} ==> ${5 > 4}, ${5 gt 4}, ${5 lt 4}<br>
\${5 >= 4} ==> ${5 >= 4}, ${5 ge 4}, ${5 le 4}<br>

<!-- 관계연산자 -->
\${5 < 4 and 3 > 2} ==> ${5 < 4 and 3 > 2}, ${5 < 4 or 3 > 2}<br>

<!-- 삼항연산자 -->
\${5 >= 4?10:10+5} ==> ${5 >= 4?10:10+5}<br>
<br>
<hr>
<h4>--- 내장 객체 ---</h4>
<%
request.setAttribute("aa", "air");
session.setAttribute("bb", "burger");
application.setAttribute("cc", "cat");
%>

<h4>생존 범위 관련 내장객체 출력</h4>
jsp : <%=request.getAttribute("aa") %> EL : ${requestScope.aa}, ${aa}<br>
jsp : <%=session.getAttribute("bb") %> EL : ${sessionScope.bb}, ${bb}<br>
jsp : <%=application.getAttribute("cc") %> EL : ${applicationScope.cc}, ${cc}<br>
<br>
JSP의 Header : <%=request.getHeader("host")%><br>
EL의 Header : ${header.host}, ${header["host"]}<br>
<br>
<h4>컬렉션 객체 값 출력</h4>
<%
ArrayList<String> list = new ArrayList<>();
list.add("치킨버거");
list.add("새우버거");
list.add("불고기버거");
request.setAttribute("list", list);

ArrayList<String> list02 = new ArrayList<>();
list02 = (ArrayList)request.getAttribute("list");
out.println(list02.get(1));
%>
<br>
EL로 출력 : ${list[0]}, ${list[1]}
<br><br>
<h4>-- HTML 문서 자료 받기 --</h4>
<a href="el_02.html">el_02.html 호출</a><br><br>
이름 : ${param.name} ${param["name"]}<br>
성격 : ${paramValues.sung[0]} ${paramValues.sung["1"]}



















</body>
</html>