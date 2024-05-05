package pack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.Period;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


// Connection 객체는 필요할 때만 연결하고 끊는 것이 원칙이나, 그렇지 않은 경우도 있다. (예외상황)
public class Db_Test05_RecMove extends JFrame implements ActionListener {
	// 버튼 4개(처음, 이전, 다음, 마지막)
	JButton btnF = new JButton("|<<");
	JButton btnP = new JButton("<");
	JButton btnN = new JButton(">");
	JButton btnL = new JButton(">>|");
	
	// 직원자료 표시(번호, 이름)
	JTextField txtNo = new JTextField("", 5);
	JTextField txtName = new JTextField("", 10);
	Connection con;
	Statement stmt;
	ResultSet rs;
	
	public Db_Test05_RecMove() {
		super("레코드 이동");
		
		layInit();
		accDB();
		
		setBounds(200, 200, 300, 250);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if(e.getSource() == btnF) rs.first();
			else if (e.getSource() == btnP) rs.previous();
			else if (e.getSource() == btnN) rs.next();
			else if (e.getSource() == btnL) rs.last();
			
			display();
		} catch (Exception e2) {
			
		}
	}
	
	private void display() {
		try {
			txtNo.setText(rs.getString("jikwon_no"));
			txtName.setText(rs.getString("jikwon_name"));
		} catch (Exception e) {
			
		}
	}
	
	
	private void layInit() {
		JPanel panel1 = new JPanel();	// Flow Layout_배치관리자
		panel1.add(new JLabel("직원 자료"));
		txtNo.setEditable(false);	// 편집 불가
		txtName.setEnabled(false);	// 비활성화(기능을 아예 죽여버림)
		panel1.add(txtNo);
		panel1.add(txtName);
		add("North", panel1);	// panel을 프레임에
		
		JPanel panel2 = new JPanel();
		panel2.add(btnF);
		panel2.add(btnP);
		panel2.add(btnN);
		panel2.add(btnL);
		add("Center", panel2);
		
		// 레코드 이동
		// 누르면 actionPerformed로 이동
		btnF.addActionListener(this);
		btnP.addActionListener(this);
		btnN.addActionListener(this);
		btnL.addActionListener(this);
	}
	
	private void accDB() {
		// 생성자를 통해 한번만 드라이버 로딩
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			
			processDB();
		} catch (Exception e) {
			System.out.println("accDB error : " + e);
		}
	}
	
	
	// 커서를 계속 물고있어야 하는데 끊어버리면 포인터의 위치가 처음으로 돌아가기 때문에 끊으면 안된다.
	private void processDB() {
		try {
			// 연결 객체 만들기
			String url = "jdbc:mariadb://localhost:3306/test";
			con = DriverManager.getConnection(url, "root", "123");
			
			// 잡아주고
			stmt = con.createStatement();
			
			// 읽는다
			rs = stmt.executeQuery("select jikwon_no, jikwon_name from jikwon");
			rs.next();
			display();	// 뜨자마자 직원 정보가 보인다.
		} catch (Exception e) {
			System.out.println("processDB error : " + e);
		}
	}
	
	public static void main(String[] args) {
		new Db_Test05_RecMove();

	}

}
