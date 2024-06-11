<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
// 입력 자료를 전송 받아 Insert하는 로직. Servlet으로 만들어도 괜찮다.
request.setCharacterEncoding("utf-8");
//String sang = request.getParameter("sang"); <- 대신 FormBean 사용
//...
%>
<jsp:useBean id="SangpumBean" class="pack.SangpumBean" />
<jsp:setProperty property="*" name="SangpumBean" />
<%
// 수신 데이터 검증이 필요하다.
%>
<jsp:useBean id="ConnClass03" class="pack.ConnClass03" />

<%
ConnClass03.insertData(SangpumBean);

// 상품 추가 후 상품 목록 보기로 이동 (url주소 바꾸기)
response.sendRedirect("jsp16_Paging.jsp");

// 주의 : 추가, 수정, 삭제 후 목록보기 할 때는 fowarding 하지 않는다.(새로고침 시 동일 상품 계속 추가됨)
//request.getRequestDispatcher("jsp16_Paging.jsp").forward(request, response);
%>