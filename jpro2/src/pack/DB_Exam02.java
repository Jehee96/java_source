package pack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class DB_Exam02 extends JFrame implements ActionListener {
	JTextField co = new JTextField("", 5);
	JTextField pum = new JTextField("", 10);
	JTextField su = new JTextField("", 10);
	JTextField dan = new JTextField("", 10);
	JButton btPlus = new JButton("추가");
	JTextArea txtResult = new JTextArea();
	String sql = "";

	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;

	public DB_Exam02() {
		super("상품 처리");

		layoutInit();
		accDB();

		setBounds(300, 300, 600, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	// 레이아웃 디자인
	private void layoutInit() {
		// 1행_코드, 품명, 수량, 단가
		JPanel panel1 = new JPanel();
		panel1.add(new JLabel("코드 : "));
		panel1.add(co);
		panel1.add(new JLabel("품명 : "));
		panel1.add(pum);
		panel1.add(new JLabel("수량 : "));
		panel1.add(su);
		panel1.add(new JLabel("단가 : "));
		panel1.add(dan);
		panel1.add(btPlus);
		add("North", panel1);

		txtResult.setEditable(false);
		JScrollPane pane = new JScrollPane(txtResult);
		add(pane);
		btPlus.addActionListener(this);
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			String code = co.getText();
			String pm = pum.getText();
			String getsu = su.getText();
			String danga = dan.getText();
			
			sql = "insert into sangdata values(?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, code);
			pstmt.setString(2, pm);
			pstmt.setString(3, getsu);
			pstmt.setString(4, danga);
			rs = pstmt.executeQuery();
			
			
			display();
			
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(this, "다시 입력해주세요..");
		}
	}
		
		
	

	private void accDB() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");

			processDb();
		} catch (Exception e) {
			System.out.println("accDB err : " + e);
		}
		display();

	}

	private void processDb() {
		try {
			String url = "jdbc:mariadb://localhost:3306/test";
			con = DriverManager.getConnection(url, "root", "123");

			display();

		} catch (Exception e) {
			System.out.println("processDb error : " + e);
		}
	}

	private void display() {
		try {
			DecimalFormat df = new DecimalFormat("###,###");
			sql = "select * from sangdata";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			int count = 0;
			txtResult.setText("코드  \t 상품명  \t 수량  \t 단가  \t 금액  \n");
			while (rs.next()) {
				txtResult.append(rs.getString("code") + "\t" + rs.getString("sang") + "\t" + rs.getString("su") + "\t"
						+ rs.getString("dan") + "\t" + df.format(rs.getInt("su") * rs.getInt("dan")) + "\n");
				count++;
			}
			txtResult.append("건수 : " + count);
		} catch (Exception e) {
			System.out.println("display() error : " + e);
		}
	}

	public static void main(String[] args) {
		new DB_Exam02();

	}

}
