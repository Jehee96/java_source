package pack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pack.other.ServletEx02_Other;

@WebServlet("/ServletEx02")
public class ServletEx02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletEx02_Other other;

	public void init(ServletConfig config) throws ServletException {
		// 서버는 init() 메소드를 호출해서 Servlet을 초기화 한다.
		// 한번만 생성해야함
		other = new ServletEx02_Other("고길동");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");	// Mime Type과 문자 코드를 적어줌
		PrintWriter out = response.getWriter(); // HttpServletResponse로 PrintWriter를 만들어 웹으로 출력
		out.println("<html><body>");
		out.println("<h1>Servlet 문서 Ex02</h1>");
		
		// 지역변수 출력
		int a = 10, b = 20;
		out.println("a : " + a + "b : " + b);

		// 현재 클래스의 메소드 호출
		int tot = calcData(a, b);
		out.println("<br>두 수의 합은 " + tot);
		
		// 클래스 호출
	    // 여기서 new를 쓰면 클라이언트 요청이 들어올 때마다 생성되기 때문에 쓰지말아야 한다.
		//ServletEx02_Other other = new ServletEx02_Other("홍길동");
		String ne = other.getName();
		out.println("<br>이름은 " + ne);
		
		out.println("</body></html>");
		out.close();
	}

	private int calcData(int a, int b) {
		int imsi = a + b;
		return imsi;
	}
}
