package kr.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.mvc.model.UserDTO;
import kr.mvc.model.UserManager;

public class UpdateController implements Controller {
	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String email = request.getParameter("email");

		UserDTO user = new UserDTO();
		user.setUserid(userid);
		user.setPassword(password);
		user.setName(name);
		user.setEmail(email);
		
		
		UserManager.instance().userUpdate(user);
		
		
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("list.jsp"); // <<<<<<<<<<<<< 404 <<<<<<<<<<<<<<<<<<
		modelAndView.setRedirect(true);
		
		return modelAndView;
	}
}
