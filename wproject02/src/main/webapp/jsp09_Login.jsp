<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 로직용(로그인 성공 유무) -->
<%
String id = request.getParameter("id");
String password = request.getParameter("password");

// Authentication(인증) : 실제는 DB 정보를 읽어서 확인
String validId = "ok";
String validPassword = "123";

if(id != null && password != null && id.equalsIgnoreCase(validId) && password.equals(validPassword)) {
	// 인증이 유효하다면 세션을 생성
	HttpSession ses = request.getSession();
	ses.setAttribute("userid", id); // 세션 생성 후 Session ID를 클라이언트 컴퓨터의 쿠키로 저장.
	
	// 인증에 성공한 경우 보여줄 페이지로 이동
	response.sendRedirect("jsp09_Success.jsp"); // success.html <<forwarding
}else{
	// 인증에 실패한 경우 처리 작업(페이지 호출)
	out.println("<html><body>");
	out.println("<h3>로그인 실패</h3>");
	out.println("<a href='jsp09_SessionLogin.html'>다시 시도</a>");
	out.println("</body></html>");
}


%>