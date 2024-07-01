package pack.controllar;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pack.model.HobbyModel;

//@WebServlet("/hobby.do")
//@WebServlet({"/hobby.do", "/hobby02.do", "*.kor"})
public class HobbyControllar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HobbyModel model;
	
	public void init(ServletConfig config) throws ServletException {
		model = new HobbyModel();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String hobby = request.getParameter("hobby");
		
		// Model을 통해 결과를 얻음
		ArrayList<String> list = model.getHobby(hobby);
		//System.out.println(list.size());
		request.setAttribute("datas", list);
		String viewName = "/WEB-INF/views/show.jsp";

		request.getRequestDispatcher(viewName).forward(request, response);
	}

}
