package kr.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutController implements Controller {
	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(false); // session이 없으면 읽지 않음.
		session.removeAttribute("userid");	// session이 있으면 userid를 읽어 지워버림!
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login.html");
		modelAndView.setRedirect(true);
		
		return modelAndView;
	}
}
