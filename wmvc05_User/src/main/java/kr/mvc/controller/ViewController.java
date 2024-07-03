package kr.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.mvc.model.UserDTO;
import kr.mvc.model.UserManager;

public class ViewController implements Controller{
	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 상세 보기 처리
		request.setCharacterEncoding("utf-8");
		String userid = request.getParameter("userid");
		
		
		// 모델과 통신
		UserDTO dto = UserManager.instance().findUser(userid); // DB에서 자료를 가지고 옴
		request.setAttribute("user", dto);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("view.jsp"); // 상세 보기를 위한 출력용.. forwarding 해야함
		modelAndView.setRedirect(false);	  //  forwarding = false, redirect = true
		return modelAndView;
	}
}
