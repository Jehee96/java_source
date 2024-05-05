package pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

// 키보드로 부서번호를 입력받아 해당 부서에 근무하는 직원자료 출력
// 부서번호 : 10 <-
// 사번   이름    부서   직급  연봉
//   1   홍길동  총무부  부장  8900
// ...

// 건수 : *
// Secure 쓰지 말기!
public class Db_Exam01 {
	private Connection con;
	private Statement st;
	private ResultSet rs;

//	SELECT jikwon_no, jikwon_name, buser_name
//	FROM jikwon LEFT OUTER JOIN buser
//	ON jikwon.buser_num = buser.buser_no;

	public Db_Exam01() {
		//

		// 1. Driver File Loading
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (Exception e) {
			System.out.println("로딩 실패 : " + e);
			return;
		}
		// 2. DB Server 연결
		try {
			String url = "jdbc:mariadb://localhost:3306/test";
			con = DriverManager.getConnection(url, "root", "123");
		} catch (Exception e) {
			System.out.println("연결 실패 : " + e.getMessage());
			return;
		}

		// 3. 연결된 DB Server에 SQL 실행
		try {
			// 드라이버 객체로 statement를 인스턴스
			st = con.createStatement();
			Scanner sc = new Scanner(System.in);
			System.out.println("부서번호 입력 : ");
			int bunum = sc.nextInt();
			System.out.println("사번" + " " + "이름" + " " + "부서" + " " + "직급" + " " + "연봉");
			rs = st.executeQuery(
					"Select jikwon_no, jikwon_name, buser_name, jikwon_jik, jikwon_pay from jikwon INNER JOIN buser ON jikwon.buser_num = buser.buser_no where buser_no ="
							+ bunum);

			int count = 0;
			while (rs.next()) {
				int sb = rs.getInt("jikwon_no");
				String name = rs.getString("jikwon_name");
				String num = rs.getString("buser_name");
				String jik = rs.getString("jikwon_jik");
				int pay = rs.getInt("jikwon_pay");

				System.out.println(sb + " " + name + " " + num + " " + jik + " " + pay);
				count++;
			}
			System.out.println("건수 : " + count);

//			String sql = "Select count(*) as 건수 from jikwon where ";
//			rs = st.executeQuery(sql);
//			rs.next();
//			System.out.println("건수 : " + rs.getString("건수"));

		} catch (Exception e) {
			System.out.println("처리 실패 : " + e);
		} finally {
			try {
				rs.close();
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {

			}

		}
	}

	public static void main(String[] args) {
		new Db_Exam01();

	}

}
