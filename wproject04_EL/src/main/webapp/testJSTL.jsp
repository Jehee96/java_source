<%@page import="pack.Student"%>
<%@page import="pack.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<b>전통적 방법 :</b> 안녕 <%=request.getAttribute("name") %><br>
<%
out.println(request.getAttribute("name"));
%><br>
<br><br>
<b>EL :</b> 반가워 ${name} ${requestScope.name}
<br>
<h2>👥 Person과 Student</h2><br>
<b>전통적 :</b> <%Person p = (Person)request.getAttribute("person"); %>
		 		<%=p.getName() %>
		 		<%Student s = (Student)request.getAttribute("student"); %>
		 		<%=s.getAge() %>
<br>
<b>EL :</b> ${person.name} &nbsp;&nbsp;&nbsp; ${student.age}
<br><br>
<h2>❗ 조건판단문 if</h2>
<b>동물 : </b>${animal[0]} ${animal[1]} ${animal["2"]}
<br><br>
<c:if test="${list != null}">
	<c:forEach var="a" items="${list}">
		${a[0]}, ${a[1]}, ${a[2]}
	</c:forEach>
</c:if>
<br><br>
<c:if test="${list != null}">
	<c:forEach var="a" items="${list}">
		<c:forEach var="b" items="${a}">
			${b}
		</c:forEach>
		<br>
	</c:forEach>
</c:if>
<br><br>

<c:choose>
	<c:when test="${list eq null}">자료없음</c:when>
	<c:otherwise>자료있음</c:otherwise>
</c:choose>
<hr>

<b>예외처리</b><br>
<c:catch var="myErr">
	<%
	int a = 10 / 0;
	out.println("a : " + a);
	%>
</c:catch>
<c:if test="${myErr != null}">
	에러 발생 : ${myErr.message} <!-- == myErr.getMessage() -->
</c:if>
<hr>
<b>계속</b>
<br><br>다른 문서 포함<br>
<b>include 지시어 사용 :</b> <%@include file="poham.jsp" %>
<br>
<b>JSTL 사용 :</b> <c:import url="poham.jsp" />
<hr>
<%--
<c:import url="https://www.daum.net" />
 --%>
<c:set var="url" value="https://www.naver.com"/>
<c:import url="${url}" var="u" />
<c:out value="${url}" /> 
<c:out value="${u}" /> <%--소스를 찍음 --%>
</body>
</html>