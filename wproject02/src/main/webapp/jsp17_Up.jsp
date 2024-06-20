<%@page import="pack.SangpumDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<!-- code 가져오기 -->
<% String code = request.getParameter("code"); %>

<!-- 부분 데이터 가져오기 -->
<jsp:useBean id="ConnPooling" class="pack.ConnPooling"></jsp:useBean>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
SangpumDTO dto = ConnPooling.updateData(code);
if(dto == null) {
%>
	<script type="text/javascript">
		alert("등록된 상품코드가 아닙니다.\n수정 불가!");
		//history.back(); : 이전으로 돌아가기
		location.href="jsp17_DBCP.jsp"; // null일 경우 돌아간다.
	</script>

<%
	return;
}
%>

** 상품 수정 **<br>
<!-- 자료 수정하면 jsp17_Upok.jsp로 이동 -->
<form action="jsp17_Upok.jsp" method="post">
코드 : <%=dto.getCode() %><br>
<!-- 코드 수정 X. 이렇게 해야 code, sang, su, dan이 다 넘어감. -->
<input type="hidden" name="code" value="<%=dto.getCode()%>">
품명 : <input type="text" name="sang" value="<%=dto.getSang() %>"><br>
수량 : <input type="text" name="su" value="<%=dto.getSu() %>"><br>
단가 : <input type="text" name="dan" value="<%=dto.getDan() %>"><br>
<br>
<input type="submit" value="자료 수정">
<input type="button" value="수정 취소" onclick="javascript:location.href='jsp17_DBCP.jsp'">
</form>
</body>
</html>