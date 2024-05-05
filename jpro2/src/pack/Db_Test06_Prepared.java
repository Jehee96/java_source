package pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


// PreparedStatement : 선처리 방식이 가능, SQL문에 입력자료 적용시 ?연산자 가능
public class Db_Test06_Prepared {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public Db_Test06_Prepared() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://localhost:3306/test";
			con = DriverManager.getConnection(url, "root", "123");
			
			String sql = "";
			
			// 자료 추가
//			sql = "insert into sangdata values(?, ?, ?, ?)";
//			pstmt = con.prepareStatement(sql);
//			
//			// 여기서 물음표를 채워가야함
//			pstmt.setString(1, "10");
//			pstmt.setString(2, "신상품");
//			pstmt.setInt(3, 12);
//			pstmt.setString(4, "5000");
//			int re = pstmt.executeUpdate();
//			System.out.println("insert 반환 값 : " + re);
			
			
			// 자료 수정 (PK는 수정 대상이 아님.)
//			sql = "update sangdata set sang = ?, su = ? where code = ?";
//			pstmt = con.prepareStatement(sql);
//			
//			pstmt.setString(1, "아메리카노");	// sang 상품명
//			pstmt.setInt(2, 33);				// su   수량
//			pstmt.setInt(3, 10);				// code  PK
//			
//			int re = pstmt.executeUpdate();
//			System.out.println("insert 반환 값 : " + re);
			
			
			// 자료 삭제
			sql = "delete from sangdata where code = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, 10);
			if (pstmt.executeUpdate() >= 1) {
				System.out.println("삭제 성공");
			}else {
				System.out.println("삭제 실패");
			}
			
			
			// 전체 자료 읽기
			sql = "select * from sangdata";		// SQL 객체 만들기
			pstmt = con.prepareStatement(sql);  // SQL문은 PreparedStatement에 한번만 주면 된다.
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				System.out.println(
						rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));
			}
			
			System.out.println();
			// 부분 자료 읽기
			String no = "2";	// 외부에서 받았다고 가정
			
			// 이렇게 쓰면 SQL Injection 공격 대상이 된다.
			// sql = "select * from sangdata where code = " + no;
			
			// Secure Coding GuidLine에 맞춰서 코딩한다면
			sql = "select * from sangdata where code = ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, no);	// 첫번째 ?에 no가 대응
			// 여기서 setString가 DB에 있는 code의 타입과는 상관 없고, no와 매핑되는 타입과 상관이 있다.
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				System.out.println(
						rs.getString("code") + " " + rs.getString("sang") + " " + rs.getString("su") + " " + rs.getString("dan"));
			}
			
			
			
		} catch (Exception e) {
			System.out.println("error : " + e);
		}
	}
	
	
	
	
	public static void main(String[] args) {
		new Db_Test06_Prepared();

	}

}
