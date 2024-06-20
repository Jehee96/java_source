<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>

<jsp:useBean id="bean" class="pack.SangpumBean" />
<jsp:setProperty property="*" name="bean"/>
<jsp:useBean id="ConnP" class="pack.ConnPooling" scope="page" />

<%
//boolean b = ConnP.updateDataOk(bean);
if(ConnP.updateDataOk(bean))
	response.sendRedirect("jsp17_DBCP.jsp"); // 수정 후 상품 목록보기로 돌아감.
else
	response.sendRedirect("jsp17_Fail.html");
%>