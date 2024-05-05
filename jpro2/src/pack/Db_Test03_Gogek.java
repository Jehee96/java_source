package pack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Db_Test03_Gogek extends JFrame implements ActionListener {
	JButton btnA = new JButton("전체");
	JButton btnM = new JButton("남자");
	JButton btnF = new JButton("여자");
	JTextArea txtResult = new JTextArea();

	Connection con;
	Statement stmt;
	ResultSet rs;

	public Db_Test03_Gogek() {
		setTitle("고객 자료");

		layInit();
		accDB();

		setBounds(200, 200, 300, 250);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void layInit() { // 디자인
		JPanel jPanel = new JPanel();
		jPanel.add(btnA);
		jPanel.add(btnM);
		jPanel.add(btnF);

		// 보여주기만 하면 되기 때문에. read only
		txtResult.setEditable(false);
		JScrollPane pane = new JScrollPane(txtResult);
		add("Center", pane);
		add("North", jPanel);

		btnA.addActionListener(this);
		btnM.addActionListener(this);
		btnF.addActionListener(this);

	}

	private void accDB() {
		// 생성자를 통해 한번만 드라이버 로딩
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (Exception e) {
			System.out.println("accDB error : " + e);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {	// 버튼 이벤트. 
		// DB 연결은 필요시 접속하고 작업이 끝나면 반드시 연결을 해제한다! 안그러면 DB서버에 부하가 걸린다.
		try {
			String url = "jdbc:mariadb://localhost:3306/test";
			con = DriverManager.getConnection(url, "root", "123");
			stmt = con.createStatement();

			// 이렇게 하면 SQL문을 쓸 수 있다.
			String sql = "select gogek_no, gogek_name, gogek_jumin from gogek";

			if (e.getSource() == btnA) { // 전체

			} else if (e.getSource() == btnM) { // 남자
				sql += " where gogek_jumin like '%-1%'"; // where 앞에는 반드시 띄어쓰기!! 문장이 이어져야 하기때문
				// sql += " where substr(gogek_jumin, 8, 1) = 1";
			} else if (e.getSource() == btnF) { // 여자
				sql += " where gogek_jumin like '%-2%'";
			}

			txtResult.setText(null);		// null 자리에 ""를 줘도 됨. 버튼 누를 때마다 그 버튼에 맞는 정보를 가져와야 하기 때문에 비우는 작업
			rs = stmt.executeQuery(sql); 	// 정보 가져오기
			int count = 0;
			txtResult.setText("고객번호\t고객명\t주민번호\n");

			while (rs.next()) {
				String imsi = rs.getString("gogek_no") + "\t" + rs.getString("gogek_name") + "\t"
						+ rs.getString("gogek_jumin") + "\n";

				txtResult.append(imsi);
				count++;
			}
			txtResult.append("인원수 : " + count);

		} catch (Exception e2) {
			System.out.println("actionPerformed error : " + e);
		} finally {
			// 쓰고나면 반납하는 부분
			try {
				rs.close();
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {

			}
		}

	}

	public static void main(String[] args) {
		new Db_Test03_Gogek();

	}

}
