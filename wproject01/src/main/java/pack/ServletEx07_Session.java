package pack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ServletEx07_Session")
public class ServletEx07_Session extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Session : 각 클라이언트의 정보를 웹서버에 메모리 확보 후 저장.
		HttpSession session = request.getSession(true);	 // 세션이 있으면 읽고 없으면 세션을 생성한다.
		//HttpSession session = request.getSession(false);// 세션이 있으면 읽고 없으면 세션을 생성하지 않는다.
		session.setMaxInactiveInterval(10); // 1분간 유효. 기본값은 30분
		
		
		if(session != null) {
			session.setAttribute("name", "홍길동");
			// Session 복수 작성 가능. 크기는 동적.
		}
		// Session ID 생성 후 서버 뿐만 아니라 클라이언트 컴퓨터의 Cookie에도 저장됨.
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter(); // HttpServletResponse로 PrintWriter를 만들어 웹으로 출력
		out.println("<html><body>");
		out.println("Session ID : " + session.getId());
		out.println("<br>사용자명 : " + session.getAttribute("name"));
		out.println("</body></html>");
		out.close();
			
	}
}
