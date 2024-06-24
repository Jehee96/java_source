package pack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TestJSTL")
public class TestJSTL extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = "신기해";
		request.setAttribute("name", name);
		
		Person person = new Person();
		person.setName("한국인");
		request.setAttribute("person", person);
		
		Student student = new Student();
		student.setAge(22);
		request.setAttribute("student", student);
		
		String[] ani = {"댕댕이", "애옹이", "앵무"};
		request.setAttribute("animal", ani);
		
		String[] foods = {"당근", "감자", "카레"};
		List<Object> list = new ArrayList<Object>();
		list.add(ani);
		list.add(foods);
		request.setAttribute("list", list);
		
		// 이렇게 해버리면 TestJSTL.jsp?name=name 이 부분만 넘어가버려서 안됨
		//response.sendRedirect("testJSTL.jsp?name=name&person=person&list=list");
		
		// request와 response의 순서는 바꾸지 말아라!
		request.getRequestDispatcher("testJSTL.jsp").forward(request, response);
		
		
	}

}
