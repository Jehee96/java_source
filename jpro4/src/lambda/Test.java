package lambda;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Test {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;

	public Test() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://localhost:3306/test";
			con = DriverManager.getConnection(url, "root", "123");

			String sql = "";

			Scanner sc = new Scanner(System.in);
			System.out.println("부서번호 입력 : ");
			int bunum = sc.nextInt();
			System.out.println("사번" + " " + "이름" + " " + "직급" + " " + "성별");
			sql = "select * from jikwon"; // SQL 객체 만들기
			pstmt = con.prepareStatement(sql); // SQL문은 PreparedStatement에 한번만 주면 된다.
			rs = pstmt.executeQuery();

			while (rs.next()) {
				System.out.println(
						rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(4) + " " + rs.getString(7));
				
				String temp = "";
				int count = 0;
				while (rs.next()) {
					int sb = rs.getInt("jikwon_no");
					String name = rs.getString("jikwon_name");
					String jik = rs.getString("jikwon_jik");
					String gen = rs.getString("jikwon_gen");

					System.out.println(sb + " " + name + " " + jik + " " + gen);
//					count++;
				}
				System.out.println("인원수는 : " + count + "\t연봉 평균은 :");
			}

		} catch (Exception e) {
			System.out.println("error : " + e);
		} finally {
			try {
				rs.close();
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {

			}
		}
	}

	public static void main(String[] args) {
		new Test();

	}

}
