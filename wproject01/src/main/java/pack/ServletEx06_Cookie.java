package pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletEx06_Cookie")
public class ServletEx06_Cookie extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter(); // HttpServletResponse로 PrintWriter를 만들어 웹으로 출력
		out.println("<html><head><meta charset=\"UTF-8\"></head><body>");
		
		// 쿠키가 있는 경우 로그인한 상태를 알리고 없다면 로그인 화면을 출현
		String id = null;
		String pw = null;
		
		try {
			Cookie[] cookies = request.getCookies(); // 클라이언트의 모든 쿠키 읽기(모든 서버의 쿠키를 읽음. MAX 300개)
			for(int i = 0; i < cookies.length; i++) {
				// 쿠키는 Key:Value 형태로 구성되어 있음
				String name = cookies[i].getName();
				System.out.println("name : " + name);
				
				if(name.equalsIgnoreCase("id")) {
					// 쿠키 값 Decoding(암호 해제)
					id = URLDecoder.decode(cookies[i].getValue(), "utf-8");
				}
				if(name.equalsIgnoreCase("pw")) {
					// 쿠키 값 Decoding(암호 해제)
					pw = URLDecoder.decode(cookies[i].getValue(), "utf-8");
				}
			}
		} catch (Exception e) {
			
		}
		
		if(id != null && pw != null) { // id, pw가 있는 경우
			out.println(id + "님 쿠키를 통해 로그인한 상태입니다.");
			out.println("</body></html>");
			out.close();
			return;
		}
		
		// id, pw가 없는 경우
		out.println("<h2>로그인</h2>");
		out.println("<form method='post'>");
		out.println("ID : <input type='text' name='id'><br>");
		out.println("PW : <input type='text' name='pw'><br>");
		out.println("<input type='submit' value='로그인'>");
		out.println("</form>");
		out.println("</body></html>");
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		//System.out.println(id + " " + pw);
		
		if(id.equals("aaa") && pw.equals("111")) {
			// 쿠키 생성
			try {
				id = URLEncoder.encode(id, "utf-8");	// 암호화
				Cookie idCookie = new Cookie("id", id); // 암호화된 ID로 쿠키 만들기
				idCookie.setMaxAge(60 * 60 * 24 * 365); // 쿠키 유효기간
				
				pw = URLEncoder.encode(pw, "utf-8");
				Cookie pwCookie = new Cookie("pw", pw);
				pwCookie.setMaxAge(60 * 60 * 24 * 365);
				
				// 내보낼 때
				response.addCookie(idCookie);
				response.addCookie(pwCookie);	// 클라이언트 컴퓨터에 쿠키를 저장
				
				out.println("로그인 성공 : 쿠키가 설정되었습니다.");
			} catch (Exception e) {
				
			}
		}else {
			out.println("로그인 실패");
		}
		
		out.println("</html></body>");
		out.close();
	}

}
