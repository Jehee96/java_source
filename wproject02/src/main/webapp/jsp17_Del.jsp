<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% String code = request.getParameter("code"); %>
<jsp:useBean id="ConnP" class="pack.ConnPooling" scope="page" />

<%
//boolean b = ConnP.updateDataOk(bean);
if(ConnP.deleteData(code))
	response.sendRedirect("jsp17_DBCP.jsp"); // 삭제 후 상품 목록보기로 돌아감.
else
	response.sendRedirect("jsp17_Fail.html");
%>