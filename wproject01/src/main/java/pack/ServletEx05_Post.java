package pack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/post.do")
public class ServletEx05_Post extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); // 수신 자료 한글 깨짐 방지
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter(); // HttpServletResponse로 PrintWriter를 만들어 웹으로 출력
		out.println("<html><body>");
		out.println("<h2>Post 요청 결과</h2>");
		
		String name = request.getParameter("name");
		String addr[] = request.getParameterValues("addr"); // 매개변수 중복인 경우 배열 처리
		out.println("이름은 " + name + " 주소는 " + addr[0] + " " + addr[1]);
		
		// CheckBox
		try {
			String sports[] = request.getParameterValues("sports");
			out.println("<br>선택한 종목은");
			for(String s:sports) {
				out.println(s + " ");
			}
		} catch (Exception e) {
			out.println("<br>종목 하나 이상을 선택하면 어떨지..");
			return;
		}
		
		// Radio
		String language = request.getParameter("lan");
		out.println("<br>자신있는 언어는 " + language);
		
		// Select
		String tr = request.getParameter("tr");
		out.println("<br>교통수단은 " + tr);
		
		// Hidden : 보이지 않지만 값이 넘어감
		String edu = request.getParameter("edu");
		out.println("<br>교육센터는 " + edu);
		
		out.println("<br><br><a href='postData.html'>자료 다시 입력</a>");
		out.println("</body></html>");
		out.close();
	}

}
