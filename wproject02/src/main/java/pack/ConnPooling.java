package pack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import javax.swing.text.AbstractDocument.BranchElement;

public class ConnPooling {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private DataSource ds;
	
	public ConnPooling() {
		// JNDI (Java Naming and Directory Interface)
		// 이름지정 및 디렉토리 서비스에서 제공하는 데이터 및 객체를 참조(lookup)하기 위한 자바 API이다. 
		// 일반적으로 자바 애플리케이션을 외부 디렉터리 서비스(DB server,LDAP server..)에 연결할 때 쓰이는데
		// 그중에서도 데이터베이스 연결에 가장 많이 쓰인다.
		try {
			// context.xml에 설정된 DB 연결정보 읽기. Pool에서 Connection 개체를 읽음.
			Context context = new InitialContext();
			ds = (DataSource)context.lookup("java:comp/env/jdbc_maria"); // JNDI
		} catch (Exception e) {
			System.out.println("DB 연결 실패 : " + e);
		}
	}

	public ArrayList<SangpumDTO> getdataAll() {
		ArrayList<SangpumDTO> list = new ArrayList<SangpumDTO>();
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement("select * from sangdata");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				SangpumDTO dto = new SangpumDTO();
				dto.setCode(rs.getString(1));
				dto.setSang(rs.getString(2));
				dto.setSu(rs.getString(3));
				dto.setDan(rs.getString(4));
				list.add(dto);
			}
			
			
		} catch (Exception e) {
			System.out.println("getdataAll error : " + e);
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
				
			} catch (Exception e2) {
			
			}
		}
		return list;
	}
	
	
	public boolean insertData(SangpumBean bean) {
		boolean b = false;
		
		try {
			conn = ds.getConnection();
			
			// 신상 번호 구하기
			String sql = "select max(code) as max from sangdata";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			int maxCode = 0;
			if(rs.next()) {
				maxCode = rs.getInt("max");
			}
			maxCode++; // 신상 번호. 번호에 1 누적
			
			// 추가 작업
			sql = "insert into sangdata(code, sang, su, dan) values(?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, maxCode);
			pstmt.setString(2, bean.getSang());
			pstmt.setString(3, bean.getSu());
			pstmt.setString(4, bean.getDan());
			int result = pstmt.executeUpdate(); // insert 성공하면 true(1), 실패하면 false(0)
			if(result == 1) b = true;
			
		} catch (Exception e) {
			System.out.println("insertData error :" + e);
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
				
			} catch (Exception e2) {
			
			}
		}
		return b;
	}
	
	public SangpumDTO updateData(String code) { // 수정할 번호
		SangpumDTO dto = null;
		
		/*
		 * try {
		 * String sql = "select * from sangdata where code=?";
		 * conn = ds.getConnection();
		 * pstmt = conn.prepareStatement(sql);
		 * pstmt.setString(1, code);
		 * rs = pstmt.executeQuery();
		 * if(rs.next()) { // 자료가 있을 수도, 없을 수도 있음. 없으면 null을 만남
		 * dto = new SangpumDTO();
		 * dto.setCode(rs.getString("code"));
		 * dto.setSang(rs.getString("sang"));
		 * dto.setSu(rs.getString("su"));
		 * dto.setDan(rs.getString("dan"));
		 * }
		 * 
		 * } catch (Exception e) {
		 * System.out.println("updateData error : " + e);
		 * }finally {
		 * try {
		 * if(rs != null) rs.close();
		 * if(pstmt != null) pstmt.close();
		 * if(conn != null) conn.close();
		 * 
		 * } catch (Exception e2) {
		 * 
		 * }
		 * }
		 * return dto;
		 */ // --------- 여기까지 수정을 위해 자료를 읽어오는 과정 ---------
		
		String sql = "select * from sangdata where code=?";
		try(Connection conn = ds.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, code);
			ResultSet rs = pstmt.executeQuery();// 자료가 있을 수도, 없을 수도 있음. 없으면 null을 만남
				
				if(rs.next()){
					dto = new SangpumDTO();
					dto.setCode(rs.getString("code"));
					dto.setSang(rs.getString("sang"));
					dto.setSu(rs.getString("su"));
					dto.setDan(rs.getString("dan"));
			 }
			 
			 } catch (Exception e) {
				 System.out.println("updateData error : " + e);
			 }
			 return dto;
	}
	
	public boolean updateDataOk(SangpumBean bean) {
		boolean b = false;
		String sql = "update sangdata set sang=?, su=?, dan=? where code=?";
		
		try(Connection conn = ds.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, bean.getSang());
			pstmt.setString(2, bean.getSu());
			pstmt.setString(3, bean.getDan());
			pstmt.setString(4, bean.getCode());
			
			// 82번 줄의 추가작업 코드를 줄이면 이렇다!
			if(pstmt.executeUpdate() > 0) b = true;
			
		} catch (Exception e) {
			 System.out.println("updateDataOk error : " + e);
		 }
		return b;
	}
	
	public boolean deleteData(String code) {
		boolean b = false;
		String sql = "delete from sangdata where code=?";
		
		try(Connection conn = ds.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, code);
			
			// 82번 줄의 추가작업 코드를 줄이면 이렇다!
			if(pstmt.executeUpdate() > 0) b = true;
			
		} catch (Exception e) {
			 System.out.println("updateDataOk error : " + e);
		 }
		return b;
	}
}
	
