package lambda;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class My_Lambda05_DB {

	public My_Lambda05_DB() {
		// Consumer 인터페이스는 accept()를 갖고 있다.
		// 주로 Collection API의 forEach에서 주로 사용한다.
		abc();

		System.out.println();
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (Exception e) {
			System.out.println("Driver Loading Fail : " + e);
			return;
		}

		queryTable("select * from sangdata", rs -> {
			System.out.println("처리 2");
			try {
				while (rs.next()) {
					System.out.println(rs.getString("code") + " " + rs.getString("sang") +  " " +  rs.getString("su") +  " " + rs.getString("dan"));
				}
			} catch (Exception e) {
				System.out.println("error : " + e);
			}
		});
	}

	private void abc() {
		Consumer<Integer> printInt = i -> System.out.println(i); // 여기서 printInt는 Consumer의 객체이고, i는 매개변수이다.
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		numbers.forEach(printInt);
	}
	private void queryTable(String sql, Consumer<ResultSet> consumer) {
		// try문에 매개변수를 줄 수 있다. try with resources 문법에 준함
		try(Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/test","root","123");
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
				System.out.println("처리 1");
				consumer.accept(rs);
				System.out.println("처리 3");
				
				rs.close();
				pstmt.close();
				conn.close();
				
				
		} catch (Exception e) {
			System.out.println("queryTable error" + e);
		}
	}

	public static void main(String[] args) {
		new My_Lambda05_DB();
	}
	
}
