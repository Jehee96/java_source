<%@page import="java.util.Map"%>
<%@page import="pack.order.OrderMgr"%>
<%@page import="pack.order.OrderBean"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Hashtable"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<jsp:useBean id="cartMgr" class="pack.order.CartMgr" scope="session" />
<jsp:useBean id="orderMgr" class="pack.order.OrderMgr" />
<jsp:useBean id="productMgr" class="pack.product.ProductMgr" />

<%
//Hashtable hCart = cartMgr.getCartList(); // 카트에 있는거 다 꺼내오기
//Enumeration enu = hCart.keys();
Hashtable<String, OrderBean>hCart = (Hashtable<String, OrderBean>)cartMgr.getCartList();

if(hCart.isEmpty()) {
%>
	<script>
		alert("주문 내역이 없습니다.");
		location.href="orderlist.jsp";
	</script>
<%
}else {
	/* while(enu.hasMoreElements()) {
		OrderBean orderBean = (OrderBean)hCart.get(enu.nextElement());
		orderMgr.insertOrder(orderBean);	 // 주분정보를 DB에 저장
		productMgr.reduceProduct(orderBean); // 주분 수량 만큼 재고량 빼기 작업
		cartMgr.deleteCart(orderBean);
	} */
	
	for(Map.Entry<String, OrderBean> entry:hCart.entrySet()) {
		OrderBean orderBean = entry.getValue();
		orderMgr.insertOrder(orderBean);	 // 주분정보를 DB에 저장
		productMgr.reduceProduct(orderBean); // 주분 수량 만큼 재고량 빼기 작업
		cartMgr.deleteCart(orderBean);
	}
%>
	<script>
		alert("주문 처리가 완료되었습니다.");
		location.href="orderlist.jsp";
	</script>
<%
}
%>