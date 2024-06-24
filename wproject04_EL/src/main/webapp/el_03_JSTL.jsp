<%@page import="java.util.Date"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <!-- JSTL은 선언문이 있어야 쓸 수 있음 -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
JSTL은 JavaServer Pages Standard Tag Library의 약어로,
Java 코드를 바로 사용하지 않고 HTML 태그(<>) 형태로 직관적인 코딩을 지원하는 라이브러리이다.
01. Java EE 기반의 웹 애플리케이션 개발 플랫폼을 위한 컴포넌트 모음
02. XML 데이터 처리와 조건문, 반복문, 국제화와 지역화와 같은 일을 처리하기 위한 JSP 태그 라이브러리
03. 자신만의 태그를 추가할 수 있는 기능을 제공한다.
<br>
변수, 제어문 사용이 가능. 일반적으로 EL과 함께 사용한다.
<hr><br>
<h3>변수 처리</h3>
<c:set var="name" value="배고파" scope="page"></c:set> <%-- page외에도 request, session, application 쓸 수 있음 --%>
이름 : <c:out value="${name}" />
<c:set var="na" scope="session">
마라탕
</c:set>
<br>
이름 : <c:out value="${na}" />
<br>
<c:remove var="name"/>
이름 : <c:out value="${name}" />
<br>
<c:remove var="na"  scope="session"/> <%-- scope로 출처가 어디인지 밝혀주면 좋음 --%>
이름 : <c:out value="${na}" />
<br><br>
<c:set var="abc" value="${header['User-Agent']}" scope="page" />
abc값은 (현재 사용중인브라우저 정보) : <c:out value="${abc}" />
<br>
<c:set var="su1" value="10" />
<c:set var="su2" >
20
</c:set>
두 수의 합은 ${su1 + $su2}
<hr>
<h3>조건 판단문 if</h3>
<c:set var="nice" value="star" />

<c:if test="${nice == 'star'}"> <%-- ${nice eq 'star'} --%>
	if 연습 : nice 값은 <c:out value="${nice}" />
</c:if>
<p/>
<br>
<h3>조건 판단문 choose</h3>
<c:choose>
	<c:when test="${nice == 'moon'}">
		달 <c:out value="${nice}"></c:out>
	</c:when>
	<c:when test="${nice == 'moon'}">
		별 <c:out value="${nice}"></c:out>
	</c:when>
	<c:otherwise><b>c:otherwise : 어떠한 조건도 만족하지 않은 경우</b></c:otherwise>
</c:choose>
<br><br><br>
<c:choose>
	<c:when test="${empty param.id}"> <%-- param.id이 없다면이라는 뜻! --%>
		<form>
			아이디 : <input type="text" name="id">
			<input type="submit">
		</form>
	</c:when>
	<c:when test="${param.id == 'admin'}">
		관리자
	</c:when>
	<c:otherwise>
		안녕하세요, <c:out value="${param.id}" />님.
	</c:otherwise>
</c:choose>
<br>
<hr>
<h3>반복문 forEach</h3>
연습01 :
<c:forEach var="i" begin="1" end="10" step="2">
	${i}&nbsp;&nbsp;
</c:forEach>
<br><br>
구구단(3단)<br>
<c:forEach var="i" begin="1" end="9">
	3 * ${i} = ${3 * 1}<br>
</c:forEach>
<br>
<%
HashMap<String, Object> map = new HashMap<>();
map.put("name", "한국인");
map.put("tonday", new Date());
%>

<c:set var="m" value="<%=map %>" /> <%-- 변수 m은 map을 받음! map은 순서없다 --%>
<c:forEach var="i" items="${m}">
	${i.key} - ${i.value}<br>
</c:forEach>

<br>
<hr>
<h3>배열 생성 후 출력</h3>
<c:set var="arr" value="<%=new int[]{1, 2, 3, 4, 5} %>" />
<c:forEach var="a" items="${arr}" begin="2" end="4" step="1">
	${a}&nbsp;
</c:forEach>
<br>
<h3>문자열 분할 후 출력</h3>
<c:forTokens var="animal" items="horse,dog,cat,lion,tiger,pig" delims=","> <%-- 콤마로 구분 --%>
	동물 : ${animal} &nbsp;
</c:forTokens>

<br>
<hr>
<h3>숫자 및 날짜 서식</h3>
<%-- #은 무효의 0은 출력하지 않고, 0은 무효의0도을 0을 출력함 --%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
숫자 : <fmt:formatNumber value="12345.678" type="number" /><br>
숫자 : <fmt:formatNumber value="12345.678" type="number" pattern="#,##0"/><br> <%-- 소숫점 없애기. 반올림 해서 12,346이 됨 --%>
숫자 : <fmt:formatNumber value="12345.678" type="currency"/><br>
숫자 : <fmt:formatNumber value="0.123" type="percent"/><br>
숫자 : <fmt:formatNumber value="12345.678" pattern="#,##0.0" /><br> <%-- 소수 첫째자리까지 출력. 소수점 반올림해서 12,345.7이 됨  --%>
숫자 : <fmt:formatNumber value="12345.678" pattern="0,000.0" /><br>
숫자 : <fmt:formatNumber value="12" pattern="0,000.0" /><br>
<br>
<c:set var="now" value="<%=new Date() %>" />
날짜 : <fmt:formatDate value="${now}" type="date"/><br>
시간 : <fmt:formatDate value="${now}" type="time"/><br>
날짜 및 시간 : <fmt:formatDate value="${now}" type="both"/><br>
날짜 및 시간 : <fmt:formatDate value="${now}" type="both" pattern="yyyy년 MM월 dd일"/>
</body>
</html>