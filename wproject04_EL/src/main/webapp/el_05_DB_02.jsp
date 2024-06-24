<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>JSTL로 DB 연동 결과 출력</h2>
<br>

<sql:setDataSource var="ds" url="jdbc:mariadb://localhost:3306/test" driver="org.mariadb.jdbc.Driver" user="root" password="123"/>

<%-- 쿼리 블럭 --%>
<sql:query var="rs" dataSource="${ds}">
	select * from sangdata where code >=? and code <= ?
	<sql:param value="1" /> <%-- 1이상 --%>
	<sql:param value="3" /> <%-- 3이하까지만 나오게 --%>
</sql:query>

<table border="1" style="text-align: center;">
	<tr>
		<th>코드</th><th>상품</th><th>수량</th><th>단가</th>
	</tr>
	<c:forEach var="r" items="${rs.rows}">
	<tr>
		<td>${r.code}</td>
		<td>${r.sang}</td>
		<td>${r.su}</td>
		<td>${r.dan}</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>