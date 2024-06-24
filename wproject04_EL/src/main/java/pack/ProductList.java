package pack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ProductList")
public class ProductList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Product> products = new ArrayList<Product>();
		products.add(new Product("메가리카노", 7000.0, "양 많음", new Date()));
		products.add(new Product("콘푸라이트바", 2500.0, "맛있음", new Date()));
		products.add(new Product("이클립스", 5200.0, "시원함", new Date()));
		products.add(new Product("곤약젤리", 3300.0, "먹기 힘듬", new Date()));
		
		request.setAttribute("products", products);
		request.getRequestDispatcher("pshow.jsp").forward(request, response);
	}

}
