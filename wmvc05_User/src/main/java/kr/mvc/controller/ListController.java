package kr.mvc.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.mvc.model.UserDTO;
import kr.mvc.model.UserManager;

public class ListController implements Controller {
	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ArrayList<UserDTO> list = UserManager.instance().getUserAll();
		request.setAttribute("list", list);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("list.jsp"); // forwarding 사용해서 부름
		modelAndView.setRedirect(false);	  // 해서 false
		
		return modelAndView;
	}
}