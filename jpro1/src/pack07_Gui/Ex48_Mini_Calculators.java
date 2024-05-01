package pack07_Gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Ex48_Mini_Calculators extends JFrame implements ActionListener {
	JTextField txtnum1, txtnum2;
	int num1, num2;
	ButtonGroup buttonGroup = new ButtonGroup();
	JRadioButton plus,minus, mul, div;
	JLabel lbResult;
	JButton btClac, btReset, btFin;
	
	public Ex48_Mini_Calculators() {		
		super("미니 계산기");
		layoutInit();
		
		setBounds(300, 350, 300, 300);
		setVisible(true);
		
		// uper.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 이거 쓰면 정말 종료할거냐는 메세지 창 못띄움. 주의
		addWindowListener(new WindowAdapter() {

		});
	}
			
	private void layoutInit() {
		setLayout(new GridLayout(5, 1));
		
		// 1행
		JLabel lb1 = new JLabel("숫자 1 : ");
		txtnum1 = new JTextField("", 20);
		JPanel panel1 = new JPanel();
		panel1.add(lb1);
		panel1.add(txtnum1);
		add(panel1);
		
		// 2행
		JLabel lb2 = new JLabel("숫자 2 : ");
		txtnum2 = new JTextField("", 20);
		JPanel panel2 = new JPanel();
		panel2.add(lb2);
		panel2.add(txtnum2);
		add(panel2);
		
		// 3행
		JLabel lb3 = new JLabel("연산선택 : ");
		plus = new JRadioButton("+", true);
		minus = new JRadioButton("-", false);
		mul = new JRadioButton("*", false);
		div = new JRadioButton("/", false);
		buttonGroup.add(plus);
		buttonGroup.add(minus);
		buttonGroup.add(mul);
		buttonGroup.add(div);
		
		
		JPanel panel3 = new JPanel();
		panel3.add(lb3);
		panel3.add(plus);
		panel3.add(minus);
		panel3.add(mul);
		panel3.add(div);
		add(panel3);
		
		// 4행
		lbResult = new JLabel("결과 : ", JLabel.LEFT);
		add(lbResult);
		
		// 5행
		btClac = new JButton("계산");
		btClac.addActionListener(this);
		btReset = new JButton("초기화");
		btReset.addActionListener(this);
		btFin = new JButton("종료");
		btFin.addActionListener(this);
		
		JPanel panel5 = new JPanel();
		panel5.add(btClac);
		panel5.add(btReset);
		panel5.add(btFin);
		add(panel5);
		
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
	if(e.getSource() == btClac) {
		if(txtnum1.getText().equals("")) {
			lbResult.setText("숫자1 입력");
			txtnum1.requestFocus();
			return;
		}
		try {
			num1 = Integer.parseInt(txtnum1.getText());
		} catch (Exception e2) {
			lbResult.setText("입력하라고");
			txtnum1.requestFocus();
			return;
			// 숫자 1
		}
		if (txtnum2.getText().equals("")) {
				lbResult.setText("숫자2 입력");
				txtnum2.requestFocus();
				return;
		}
		try {
			num2 = Integer.parseInt(txtnum2.getText());
		} catch (Exception e2) {
			lbResult.setText("입력하라고");
			txtnum2.requestFocus();
			return;
			// 숫자 2
		}
		
		// 계산
		int result; // 결과값 받을 변수 선언
		if(plus.isSelected()) lbResult.setText("결과 : " + (num1 + num2));
		else if (minus.isSelected()) lbResult.setText("결과 : " + (num1 - num2));			
		else if (mul.isSelected()) lbResult.setText("결과 : " + (num1 * num2));			
		else {
			if(num1 == 0) {
				lbResult.setText("0은 못 나눠");
				txtnum1.setText("");
				txtnum1.requestFocus();
			}
			else if (num2 ==0) {
				lbResult.setText("0은 못 나눠");
				txtnum1.setText("");
				txtnum1.requestFocus();
			}else {
				lbResult.setText("결과 : " + (double)num1 / (double)num2);
			}
		}
	
	} else if (e.getSource() == btReset) {
		txtnum1.setText("");
		txtnum2.setText("");
		plus.setSelected(true);
		minus.setSelected(false);
		mul.setSelected(false);
		div.setSelected(false);
		txtnum1.requestFocus();
		lbResult.setText("결과 : ");
	} else {
		int result = JOptionPane.showConfirmDialog(this, "진짜 종료하게?", "BYE", JOptionPane.YES_NO_OPTION);
														// 메시지창, 타이틀메시지 순서
		if(result == 0) System.exit(0);
		else return;
		}
	}
	
	public static void main(String[] args) {
		new Ex48_Mini_Calculators();
	}
}
