package pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Cart")
public class Cart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		int price = Integer.parseInt(request.getParameter("price"));
		
		HttpSession session = request.getSession(true);
		
		// 상품 담을 ArrayList
		ArrayList<Goods> glist = (ArrayList<Goods>)session.getAttribute("list");
		
		// 최초의 상품을 만들 때 glist를 만든다.
		if (glist == null) glist = new ArrayList<Goods>(); // Goods 객체를 담을 glist생성. 두번째 상품은 바로 밑의 라인으로 떨어짐
		glist.add(new Goods(name, price)); 	 // 첫번째 상품을 만들어서 컬렉션에 담음
		session.setAttribute("list", glist); // 세션에 넣음
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter(); // HttpServletResponse로 PrintWriter를 만들어 웹으로 출력
		out.println("<html><body>👉" + name + "구입했습니다");
		out.println("<br>[<a href='myShop.html'>계속 쇼핑</a>]");
		out.println("[<a href='Buy'>결제하기</a>]<br>");
		
		out.println("<p><table width='80%'>");
		out.println("<tr><th>상품명</th><th>가격</th></tr>");
		for(int i = 0; i < glist.size(); i++) {
			Goods goods = glist.get(i); // 컬렉션에 있는 내용을 꺼냄
			out.println("<tr><td>" + goods.getName() + "</td>");
			out.println("<td>" + goods.getPrice() + "</td></tr>");
		}
		out.println("</table>");
		out.println("</body></html>");
		out.close();
	}
}