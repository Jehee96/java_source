package pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServeletBangList")
public class ServeletBangList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public void init(ServletConfig config) throws ServletException {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/test", "root", "123");// 드라이버 연결
			pstmt = conn.prepareStatement("select * from guest order by code desc");
		} catch (Exception e) {
			System.out.println("init error : " + e.getMessage());
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8"); // MIME타입
		PrintWriter out = response.getWriter(); // 출력객체 만들기
		out.println("<html><body>");
		out.println("<h2>* 방명록 글 목록 *</h2>");
		out.println("<table border='1' width='80%'>");
		try {
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				out.println("<tr style='background-color:rgb(230,230,250)'>");
				out.println("<td>번호 : " + rs.getString("code") + "</td>");
				out.println("<td>작성자 : " + rs.getString("name") + "</td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td colspan='2'>제목 : " + rs.getString("subject") + "</td>");
				out.println("</tr>");
				out.println("<tr>");
																						// vertical-align:top; : 스크롤바
				out.println("<td colspan='2' height='100' " + "style='word-break:break-all; vertical-align:top;'>" + rs.getString("content") + "</td>");
				out.println("</tr>");
			}
			
		} catch (Exception e) {
			System.out.println("doGet error : " + e);
		}
		out.println("</table>");
		out.println("<dev style='text-align:center;'>");
		out.println("<br><a href='miniBang.html'>글 쓰기</a>");
		out.println("</dev>");
		out.println("</body></html>");
		out.close();
	}

	public void destroy() {
		try {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}



}
