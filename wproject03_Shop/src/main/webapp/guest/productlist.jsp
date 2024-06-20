<%@page import="pack.product.ProductDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="productMgr" class="pack.product.ProductMgr" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>🧺 상품목록</title>
<link href="../css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../js/script.js"></script>
</head>
<body>
<h1 style="text-align: center">🏪 쇼핑몰 </h1>
<%@ include file="guest_top.jsp" %>
<table>
	<tr>
		<th>🪧 상품명</th><th>🪙 가격</th><th>👷‍♀️ 재고량</th><th>🔍 상세보기</th>
	</tr>
	<%
	ArrayList<ProductDTO> plist = productMgr.getproductAll();
	for(ProductDTO p:plist){
	%>
	<tr style="text-align: center;">
		<td>
			<img src="../upload/<%=p.getImage() %>" width="120" />	
			<%=p.getName() %>
		</td>
		<td><%=p.getPrice() %></td>
		<td><%=p.getStock() %></td>
		<td>
			<a href="javascript:productDetail_guest('<%=p.getNo() %>')">보기</a>
		</td>
	</tr>
	<%
	}
	%>		
	
	
</table>
<%@ include file="guest_bottom.jsp" %>

<!-- productdetail_g.jsp : 상세보기 -->
<form action="productdetail_g.jsp" name="detailFrm" method="post">
	<input type="hidden" name="no" />

</form>
</body>
</html>