package kr.mvc.model;

import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.mvc.controller.UserForm;

//Controller 클래스의 요청을 받아 DB 연동 처리 담당
public class UserDAOModel {
	private SqlSessionFactory factory = SqlMapConfig.getSqlSession();
	
	public UserDAOModel() {
		
	}
	
	public UserDTO findUser(String userid) {
		UserDTO dto = null;
		
		SqlSession session = factory.openSession();
		
		try {
			dto = session.selectOne("findUser", userid);
		} catch (Exception e) {
			System.out.println("findUser error : " + e);
		}finally {
			session.close();
		}
		
		return dto;
	}
	
	
	// list 읽기 (MyBatis는 ArrayList반환 x, List만 반환)
	public ArrayList<UserDTO> getUserDataAll() {
		List<UserDTO> list = null;
		
		SqlSession session = factory.openSession();
		
		try {
			list = session.selectList("selectDataAll");
		} catch (Exception e) {
			System.out.println("getUserDataAll error : " + e);
		}finally {
			session.close();
		}
		
		return (ArrayList<UserDTO>)list;
	}
	
	public int insertData(UserForm userForm) {
		int result = 0;
		SqlSession session = factory.openSession();
		
		try {
			result = session.insert("insertData", userForm);
			session.commit();
		} catch (Exception e) {
			System.out.println("insertData error : " + e);
			session.rollback();
		}finally {
			session.close();
		}
		
		return result;
	}
	
	public int updateUser(UserDTO user) {
		int result = 0;
		SqlSession session = factory.openSession();
		
		try {
			result = session.update("updateUser", user);
			session.commit();
		} catch (Exception e) {
			System.out.println("updateUser error : " + e);
		}finally {
			session.close();
		}
		
		return result;
	}
}