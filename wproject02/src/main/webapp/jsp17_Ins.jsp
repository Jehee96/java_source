<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
%>

<!-- 이 두줄을 써주면 SangpumBean에 있는 것들이 setter를 타고 자동으로 넘어온다. -->
<jsp:useBean id="bean" class="pack.SangpumBean" />
<jsp:setProperty property="*" name="bean" />
<jsp:useBean id="ConnPooling" class="pack.ConnPooling"/>

<%
boolean b = ConnPooling.insertData(bean);

if(b)
	response.sendRedirect("jsp17_DBCP.jsp"); // 추가 후 상품 보기
else
	response.sendRedirect("jsp17_Fail.html");
%>