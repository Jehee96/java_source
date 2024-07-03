package kr.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.mvc.model.UserManager;

// Controller의 파생 클래스
public class LoginController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// id와 pw를 가지고 들어온다.
		String id = request.getParameter("userid");
		String pwd = request.getParameter("password");
		
		// 모델(비즈니스 로직)과 통신. DB는 UserManager를 타고 들어가야 한다.
		UserManager manager = UserManager.instance();
		boolean b = manager.login(id, pwd);
		
		ModelAndView modelAndView = new ModelAndView();
		if(b) {
			// 로그인에 성공 자격을 갖춤
			HttpSession session = request.getSession(true);
			session.setAttribute("userid", id); // userid가 session에 담김
			modelAndView.setViewName("list.m2"); // Redirect 사용.
			// Redirec 방식으로 요청하는 이유는 파일명(list.m2)을 가지고 다시 UserServlet 파일을 실행하는데 이용할 경로를 가지고 있어야 로그인한 후 list.m2로 가능??한가만가 
		}else {
			modelAndView.setViewName("fail.html"); // Redirect 사용.
		}
		modelAndView.setRedirect(true);
		return modelAndView;
	}
}
