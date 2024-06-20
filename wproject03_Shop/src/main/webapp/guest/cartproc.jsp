<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:useBean id="cartMgr" class="pack.order.CartMgr" scope="session"/> <!-- cartMgr이 세션이 살아있는 동안 유지 -->
<jsp:useBean id="order" class="pack.order.OrderBean" />
<jsp:setProperty property="*" name="order"/>

<%
String orderFlag = request.getParameter("flag"); // 구매목록 보기, 수정, 삭제 판단용
String id = (String)session.getAttribute("idkey");

out.print(order.getProduct_no() + ", 주문 수량 : " + order.getQuantity());

if(id == null) {
	response.sendRedirect("../member/login.jsp"); // 회원 로그인을 안한 경우
}else{
	if(orderFlag == null) {
		// cart에 주문 상품 담기
		order.setId(id); 		// order : id, quantity, product_no가 들어가있음
		cartMgr.addCart(order); // 후에 oBean이 받음. 카트 주문상품 담기
%>		
		<script>
		alert("장바구니에 담았습니다.");
		location.href="cartlist.jsp"; // 장바구니에 등록된 주문 상품 목록 보기로 이동.
		</script>
<%
	}else if(orderFlag.equals("update")) {
		order.setId(id);
		cartMgr.updateCart(order);
%>
		<script>
		alert("장바구니의 내용을 수정했습니다.");
		location.href="cartlist.jsp";
		</script>
<%	
	}else if(orderFlag.equals("del")) {
		cartMgr.deleteCart(order);
%>	
		<script>
		alert("해당 상품의 주문을 삭제했습니다.");
		location.href="cartlist.jsp";
		</script>
<%	
	}
}
%>