package pack.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.catalina.tribes.group.InterceptorPayload;
import org.eclipse.jdt.internal.compiler.ast.ParameterizedSingleTypeReference;

public class MemberMgr {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private DataSource ds;
	
	public MemberMgr() {
		try {
			Context context = new InitialContext();
			ds = (DataSource)context.lookup("java:comp/env/jdbc_maria");
		} catch (Exception e) {
			System.out.println("DB 연결 실패 : " + e);
		}
	}
	
	// 동이름으로 우편자료 검색
	public ArrayList<ZipcodeDTO> zipcodeRead(String dongName) {
		ArrayList<ZipcodeDTO> list = new ArrayList<ZipcodeDTO>();
		
		try {
			conn = ds.getConnection();
			String sql = "select * from ziptab where area3 like ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dongName + "%");
			rs = pstmt.executeQuery();
			
			while(rs.next()) { //순서o 중복 허용
				ZipcodeDTO dto = new ZipcodeDTO();
				dto.setZipcode(rs.getString("zipcode"));
				dto.setArea1(rs.getString("area1"));
				dto.setArea2(rs.getString("area2"));
				dto.setArea3(rs.getString("area3"));
				dto.setArea4(rs.getString("area4"));
				list.add(dto);
			}
			
			
		} catch (Exception e) {
			System.out.println("zipcodeRead error : " + e);
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) { }
			
			}
		return list;
	}
	
	
	// ID Check
	public boolean idCheckProcess(String id) {
		boolean b = false;
		try {
			conn = ds. getConnection();
			String sql = "select id from member where id=?";		 // 방법01 : ID 끌고 오기
			//String sql = "select count(*) from member where id=?"; // 방법02 : ID 갯수 세어보기
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			b = rs.next(); // 자료 있으면 true, 없으면 false
			
		} catch (Exception e) {
			System.out.println("idCheckProcess error : " + e);
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) { }
			
			}
		return b;
	}
	
	
	// INSERT
	public boolean memberInsert(MemberBean mBean) {
		boolean b = false;
		//System.out.println(mBean.getId() + " " + mBean.getName());
		
		try {
			String sql = "insert into member values(?,?,?,?,?,?,?,?)";
			conn =ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mBean.getId());
			pstmt.setString(2, mBean.getPasswd());
			pstmt.setString(3, mBean.getName());
			pstmt.setString(4, mBean.getEmail());
			pstmt.setString(5, mBean.getPhone());
			pstmt.setString(6, mBean.getZipcode());
			pstmt.setString(7, mBean.getAddress());
			pstmt.setString(8, mBean.getJob());
			
			if(pstmt.executeUpdate() > 0) b = true; // insert에 성공하면 mBean은 true가 된다.
			
		} catch (Exception e) {
			System.out.println("memberInsert error : " + e);
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) { }
				
			}
	return b;
	}
	
	@SuppressWarnings("finally")
	public boolean loginCheck(String id, String passwd) {
		boolean b = false;
		
		try {
			conn = ds.getConnection();
			String sql = "select * from member where id=? and passwd=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, passwd);
			rs = pstmt.executeQuery();
			b = rs.next();
			
		} catch (Exception e) {
			System.out.println("loginCheck error : " + e);
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				
			}
		return b;
	}
}
	
	public MemberBean getMember(String id) {
		MemberBean bean = null;
		try {
			conn = ds.getConnection();
			String sql = "select * from member where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				bean = new MemberBean();
				bean.setId(rs.getString("id"));
				bean.setPasswd(rs.getString("passwd"));
				bean.setName(rs.getString("name"));
				bean.setEmail(rs.getString("email"));
				bean.setPhone(rs.getString("phone"));
				bean.setZipcode(rs.getString("zipcode"));
				bean.setAddress(rs.getString("address"));
				bean.setJob(rs.getString("job"));
			}
		} catch (Exception e) {
			System.out.println("getMember error + " + e);
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				
			}
		}
		return bean;
	}
	
	public boolean memberUpdate(MemberBean memberBean, String id) {
		boolean b = false;
		try {
			conn = ds.getConnection(); // DB 꼭 열고 있어놔야 한다
			String sql = "update member set passwd=?,name=?,email=?,phone=?,zipcode=?,address=?,job=? where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberBean.getPasswd());
			pstmt.setString(2, memberBean.getName());
			pstmt.setString(3, memberBean.getEmail());
			pstmt.setString(4, memberBean.getPhone());
			pstmt.setString(5, memberBean.getZipcode());
			pstmt.setString(6, memberBean.getAddress());
			pstmt.setString(7, memberBean.getJob());
			pstmt.setString(8, id);
			if(pstmt.executeUpdate() > 0) b = true;
			
			
		} catch (Exception e) {
			System.out.println("memberUpdate error + " + e);
			
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

	
	// 관리자 로그인용
	public boolean adminLoginCheck(String adminid, String adminpasswd) {
		boolean b = false;
		try {
			conn = ds.getConnection();
			String sql = "select * from admin where admin_id=? and admin_passwd=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, adminid);
			pstmt.setString(2, adminpasswd);
			rs = pstmt.executeQuery();
			b = rs.next();
			
		} catch (Exception e) {
			System.out.println("adminLoginCheck error + " + e);
			
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
	
	
	// 관리자가 전체 회원자료 읽기
	public ArrayList<MemberBean> getMemberAll() {
		ArrayList<MemberBean> list = new ArrayList<MemberBean>();
		try {
			conn = ds.getConnection();
			String sql = "select * from member order by id asc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberBean dto = new MemberBean();
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setPasswd(rs.getString("passwd"));
				dto.setEmail(rs.getString("email"));
				dto.setPhone(rs.getString("phone"));
				list.add(dto);
			}
			
		} catch (Exception e) {
			System.out.println("getMemberAll error + " + e);
			
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
}
