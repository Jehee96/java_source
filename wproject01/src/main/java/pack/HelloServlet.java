package pack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/HelloServlet")

//요청이 없어도, 웹서비스가 시작되면 서블릿 수행 // urlPatterns : 요청이 여러개일때
@WebServlet(name = "HelloServlet", urlPatterns = {"/HelloServlet","/good.kor","/dajeong"}, loadOnStartup = 1)
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// 파라미터 순서 절대 바꾸면 안됨!!
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get 요청 성공");
		
		// Servlet (웹용 자바)으로 클라이언트 브라우저에 데이터 전송
		response.setContentType("text/html;charset=utf-8");	// Mime Type과 문자 코드를 적어줌
		PrintWriter out = response.getWriter(); // HttpServletResponse로 PrintWriter를 만들어 웹으로 출력
		out.println("<html><body>");
		out.println("<h1>Servlet 문서</h1>");
		out.println("안녕 반가워");
		out.println("</body></html>");
		out.close();
	}

}
