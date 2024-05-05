package pack;
// 환경은 pom.xml이 정해준다.


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Iterator;

// 관계형데이터베이스(RDBMS 사용)
// MariaDB(원격 DB 서버) 연동 프로그래밍
public class Db_Test01 {
	private Connection conn;
	private Statement stmt;
	private ResultSet rs; // 커서가 있는 행만 참조할 수 있다.

	public Db_Test01() {
		// 1. Driver file loading
		// 외부에서 가져온 파일 -> 빌드패쓰
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (Exception e) {
			System.out.println("로딩 실패 : " + e);
			return;
		}
		// 2. DB Server와 연결
		try {
			String url="jdbc:mariadb://localhost:3306/test";
			conn = DriverManager.getConnection(url, "root", "123");
		} catch (Exception e) {
			System.out.println("연결 실패 : " + e.getMessage());
			return;
		}
		// 3. 연결된 DB Server에 SQL 실행
		try {
			// sangdata 테이블 자료 읽기
			stmt = conn.createStatement(); // 드라이버 객체로 statement를 인스턴스
			
			rs = stmt.executeQuery("Select code, sang, su, dan from sangdata"); // 전체를 포함하는 *도 좋지만 칼럼명으로 쓰는게 더 좋다.
			// rs = stmt.executeQuery("Select * from sangdata");
			// System.out.println(rs.next());	// cursor (레코드 포인터) 이동 // 장갑
			// System.out.println(rs.getString("sang"));
			
			while (rs.next()) {	// 자료가 있는동안 반복!
				String code = rs.getString("code"); 	// 코드(상품번호)를 String으로 반환
				String sangname = rs.getString("sang"); // 상품이름
				int su = rs.getInt("su");	// 수량
				int dan = rs.getInt("dan");	// 단가
				System.out.println(code + " " + sangname + " " + su + " " + dan);
			}
			
			
			
			System.out.println("-----------------");
			rs.close();	// ResultSet을 닫고, 아래에서 다시 열기
			// 1. code, 2. sang, 3. su, 4. dan
			rs = stmt.executeQuery("Select code as 코드, sang as상품명, su, dan from sangdata");
			while (rs.next()) {	// 자료가 있는동안 반복!
				String code = rs.getString("코드");
				String sangname = rs.getString(2);	// 컬럼은 순서가 1부터 부여됨
				int su = rs.getInt("su");
				int dan = rs.getInt("dan");
				System.out.println(code + " " + sangname + " " + su + " " + dan);
			}
			
			
			
			// String sql = "select count(*) as 건수 from sangdata";
			String sql = "select count(*) from sangdata";
			rs = stmt.executeQuery(sql);
			rs.next();
			// System.out.println("건수 : " + rs.getString("건수"));
			// System.out.println("건수 : " + rs.getString("count(*)"));
			System.out.println("건수 : " + rs.getString(1));
			
		} catch (Exception e) {
			System.out.println("처리 실패 : " + e);
		}finally {
			try {
				rs.close();
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {

			}
		}
	
}
	
	public static void main(String[] args) {
		new Db_Test01();

	}
}

