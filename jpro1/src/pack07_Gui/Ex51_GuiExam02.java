package pack07_Gui;

import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Ex51_GuiExam02 extends JFrame implements ActionListener {
	int num1, num2, num3;
	JRadioButton cj, avg, pg;
	JTextField name, guk, yung, su;
	// ButtonGroup buttonGroup = new ButtonGroup();
	JButton btOk, btReset;
//	Label lb = new Label();
	JLabel lbResult1, lbResult2, lbResult3, lbResult4;
	
	double sum;
	double a_vg;
	String a;

	public Ex51_GuiExam02() {
		super("성적 출력");
		layoutinit();

		setBounds(200, 200, 300, 300);
		setVisible(true);

		addWindowListener(new WindowAdapter() {
		});

	}

	private void layoutinit() {
		setLayout(new GridLayout(5, 1));

		// 1행_이름
		JLabel lb1 = new JLabel("이름 : ");
		name = new JTextField("", 5);
		JPanel panel1 = new JPanel();
		panel1.add(lb1);
		panel1.add(name);
		add(panel1);

		// 2행_국어, 영어, 수학
		JLabel lb2 = new JLabel("국어 : ");
		JLabel lb3 = new JLabel("영어 : ");
		JLabel lb4 = new JLabel("수학 : ");
		guk = new JTextField("", 5);
		yung = new JTextField("", 5);
		su = new JTextField("", 5);

		JPanel panel2 = new JPanel();
		panel2.add(lb2);
		panel2.add(guk);
		panel2.add(lb3);
		panel2.add(yung);
		panel2.add(lb4);
		panel2.add(su);
		add(panel2);

		// 3행_총점, 평균, 평가
		JPanel panel3 = new JPanel();
		lbResult1 = new JLabel("총점 : ");
		lbResult2 = new JLabel("평균 : ");
		lbResult3 = new JLabel("평가 : ");
		panel3.add(lbResult1);
		panel3.add(lbResult2);
		panel3.add(lbResult3);
		add(panel3);

		// 4행_확인, 초기화 Button
		btOk = new JButton("확인");
		btOk.addActionListener(this);
		btReset = new JButton("초기화");
		btReset.addActionListener(this);

		JPanel panel5 = new JPanel();
		panel5.add(btOk);
		panel5.add(btReset);
		add(panel5);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btOk) {
			if (name.getText().equals("")) {
				lbResult4.setText("이름을 입력하세요");
				name.requestFocus();
				return;
			}

			// 국어 입력
			if (e.getSource().equals("")) {
				if (guk.getText().equals("")) {
					lbResult4.setText("국어 접수 입력");
					guk.requestFocus();
					return;
				}
				try {
					num1 = Integer.parseInt(guk.getText());
				} catch (Exception e2) {
					lbResult4.setText("입력하세요");
					guk.requestFocus();
					return;
				}

			}

			// 영어 입력
			if (yung.getText().equals("")) {
				lbResult4.setText("영어 점수 입력");
				yung.requestFocus();
				return;
			}
			try {
				num2 = Integer.parseInt(yung.getText());
			} catch (Exception e2) {
				lbResult4.setText("입력하세요");
				yung.requestFocus();
				return;
			}

			// 수학 입력
			if (su.getText().equals("")) {
				lbResult4.setText("수학 점수 입력");
				su.requestFocus();
				return;
			}
			try {
				num3 = Integer.parseInt(su.getText());
			} catch (Exception e2) {
				lbResult4.setText("입력하세요");
				su.requestFocus();
				return;
			}

			// 계산
			int result;
			
		}

	}

	public static void main(String[] args) {
		new Ex51_GuiExam02();

	}

}
