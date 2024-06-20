<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
// 로그인, 로그아웃
String memid = (String)session.getAttribute("idkey");
String log = "";

if(memid == null)
	log = "<a href='../member/login.jsp'>로그인</a>";
else
	log = "<a href='../member/logout.jsp'>로그아웃</a>";
	

// 로그인을 했으면 회원수정, 하지 않았으면 회원가입으로 이동
String mem = "";

if(memid == null)
	mem = "<a href='../member/register.jsp'>회원가입</a>";
else
	mem = "<a href='../member/memberupdate.jsp'>회원수정</a>";
%>
<table>
  <tr style="background-color: #7B68EE; text-align: center;">
    <td><%=log %></td>
    <td><%=mem %></td>
    <td><a href="productlist.jsp">상품목록</a></td>
    <td><a href="cartlist.jsp">장바구니</a></td>
    <td><a href="orderlist.jsp">구매목록</a></td>
    <td><a href="../board/boardlist.jsp">게시판</a></td>
  </tr>
</table>
