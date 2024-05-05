package pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Db_Test04 {
	private Connection conn; // Connection은 하나만
	private Statement stmt; // Statement : sql 실행할 수 있고 여러개 가능
	private ResultSet rs;

	public Db_Test04() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://localhost:3306/test";
			conn = DriverManager.getConnection(url, "root", "123");

			stmt = conn.createStatement();

			boolean b = false;
			
			
			// execute : executeQuey(), executeUpdate()를 하나로 처리.
			
			// update
			b = stmt.execute("update sangdata set sang = '마우스' where code = 4");
			System.out.println("update b : " + b);
			int result = stmt.getUpdateCount();	// update된 갯수를 셈
			System.out.println("result : " + result);
			if(result >= 1) {
				System.out.println("작업 성공");
			}else {
				System.out.println("작업 실패");
			}
			
			
			
			// select
			b = stmt.execute("select * from sangdata");
			System.out.println("select b :" + b);
			rs = stmt.getResultSet(); // 이렇게 할 때 execute값은 getResultSet로 받아야 한다.
			while (rs.next()) {
				System.out.println(
						rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));
			}

		} catch (Exception e) {
			System.out.println("Db_Test05 실패 : " + e);
			return;
		}
	}

	public static void main(String[] args) {
		new Db_Test04();

	}

}
