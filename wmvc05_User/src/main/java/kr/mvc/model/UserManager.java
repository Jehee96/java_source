package kr.mvc.model;

import java.util.ArrayList;

import kr.mvc.controller.UserForm;

// 여러 개의 DAO 클래스 관리가 목적이다. (싱글톤패턴)
public class UserManager {
	private static UserManager manager = new UserManager();
	
	public static UserManager instance() {
		return manager;
	}
	
	private UserDAOModel getUserDAOModel() {
		return new UserDAOModel();
	}
	
	public boolean login(String user_id, String user_password) {
		UserDTO dto = getUserDAOModel().findUser(user_id);
		if(dto == null) return false;
		
		if(dto.getPassword().equals(user_password)) {
			return true;
		}else {
			return false;
		}
	}
	
	public ArrayList<UserDTO> getUserAll() {
		return getUserDAOModel().getUserDataAll();
	}
	
	public int insert(UserForm userForm) {
		return getUserDAOModel().insertData(userForm);
	}
	
	public UserDTO findUser(String userid) {
		return getUserDAOModel().findUser(userid);
	}
	
	
	
	public void userUpdate(UserDTO user) {
		getUserDAOModel().updateUser(user);
	}
}
