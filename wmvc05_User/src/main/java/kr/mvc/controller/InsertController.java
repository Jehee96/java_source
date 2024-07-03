package kr.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.mvc.model.UserManager;

public class InsertController implements Controller {
	@Override                   // 클라이언트에서 입력한 내용은 request, response를 타고 들어온다!
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		
		UserForm userForm = new UserForm();
		userForm.setUserid(request.getParameter("userid"));
		userForm.setPassword(request.getParameter("password"));
		userForm.setName(request.getParameter("name"));
		userForm.setEmail(request.getParameter("email"));
		
		// Model과 통신
		int result = UserManager.instance().insert(userForm); // UserManager의 insert를 만남
		
		ModelAndView modelAndView = new ModelAndView();
		
		if(result > 0) {
			// insert 후 목록 보기
			modelAndView.setViewName("list.m2");
		}else {
			// insert 실패 시 실패 화면
			modelAndView.setViewName("fail.html");
		}
		
		modelAndView.setRedirect(true);
		return modelAndView;
	}
}
