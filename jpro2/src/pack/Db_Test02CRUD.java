package pack;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class Db_Test02CRUD {
	private Connection conn;	// Connection은 하나만
	private Statement stmt;		// Statement : sql 실행할 수 있고 여러개 가능
	private ResultSet rs;		// ResultSet : 쿼리의 결과를 받아오고 여러개 가능. 커서가 있는 행만 참조할 수 있다.
	private Properties prop = new Properties();
	
	public Db_Test02CRUD() {	// Secure Coding의 하나로 연결정보 별도 저장 후 읽기
		try {
			prop.load(new FileInputStream("C:\\Workstation\\Acorn\\jsou\\jpro2\\src\\pack\\Db_Test02.properties")); // 파일명 확인 잘 안하면 널인셉션나온다!!
			
			Class.forName(prop.getProperty("driver"));
			conn = DriverManager.getConnection(
					prop.getProperty("url"),
					prop.getProperty("user"),
					prop.getProperty("passwd"));
			
			stmt = conn.createStatement();
			
			String sql = "";
			
			// 01. 자료 추가
			// auto commit이 기본
			// sql = "insert into sangdata values(5, '새우깡', 55, 3000)";
			// stmt.executeUpdate(sql);	// insert, update, delete			
			
			// auto commit을 수동으로 전환해 작업 : Transaction 처리가 필요
//			conn.setAutoCommit(false);	// 수동
//			sql = "insert into sangdata values(6, '감자깡', 7, 3000)";
//			stmt.executeUpdate(sql);	// Transaction 시작
//			sql = "insert into sangdata values(7, '고구마깡', 17, 2000)";
//			stmt.executeUpdate(sql);
//			// conn.rollback();			// Transaction 종료. 클라이언트에서 입력한 자료(6~7번)는 취소됨.
//			conn.commit();              // Transaction 종료. 클라이언트에서 입력한 자료(6~7번) 원격 DB에 저장			
//			conn.setAutoCommit(true);	// 자동으로 변환
			
			// 04. 자료 수정
//			sql = "update sangdata set sang = '데일리 콤부차', su = 12, dan = 8000 where code = 5";	// 순서는 바뀌어도 상관 없다.
//			stmt.executeUpdate(sql);
			
			// 05. 자료 삭제
			sql = "delete from sangdata where code = 5";
			// stmt.executeUpdate(sql);
			// insert, update, delete는 수행 후 처리 수 만큼 행의 갯수를 반환한다. (insert, update, delete만 Transaction이 존재한다.)
			// insert는 하나씩만 반환해서 성공하면 1을, 실패하면 0을 반환한다.
			// update, delete는 1 이상의 값이 나올 수 있다.
			int result = stmt.executeUpdate(sql);
			System.out.println("result : " + result);
			
			if (result == 0) System.out.println("삭제 실패");
			
			
			
			// 02. 모든 자료 읽기
			sql = "select * from sangdata order by code desc";
			rs = stmt.executeQuery(sql);	// select
			int cou = 0;
			while (rs.next()) {
				System.out.println(rs.getString("code") + " " +  
							rs.getString("sang") + " " + 
							rs.getString("su") + " " + 
							rs.getString("dan"));
				cou++;
			}
			System.out.println("전체 자료 수 :" + cou);
			
			
			
			// 03. 부분 자료 읽기
			sql = "select * from sangdata where code = 1"; // 1 자리에 스캐너 할 수 있고 gui를 받을 수 있다.
			rs = stmt.executeQuery(sql);
			if(rs.next()) {	// 자료가 1개라 if를 씀!
				System.out.println(rs.getString("code") + " " +  
						rs.getString("sang") + " " + 
						rs.getString("su") + " " + 
						rs.getString("dan"));
			}else {
				System.out.println("해당 자료 없음");
			}
			
			
		} catch (Exception e) {
			System.out.println("error : " + e);
		}finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) rs.close();
				if(conn != null) rs.close();
				
			} catch (Exception e2) {
				
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		new Db_Test02CRUD();
		
	}

}
