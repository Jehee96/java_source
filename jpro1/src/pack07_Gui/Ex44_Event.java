package pack07_Gui;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Ex44_Event extends Frame implements ActionListener {
	private Button btn1 = new Button("button1");
	private Button btn2 = new Button("button2");
	private Button btn3 = new Button("button3");
	private Button btn4 = new Button("button4");
	private Button btn5 = new Button("button5");
	
	
	
	public Ex44_Event() {
		super("이벤트 연습");
		
		addLayout();
		setBounds(200, 200, 400, 400);
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	private void addLayout() {
		add("East", btn1);	// Frame은 BorderLayout이 기본
		add("West", btn2); 	
		add("Center", btn3);
		add("South", btn4);
		add("North", btn5);
		
		btn1.addActionListener(this);	// 방법01 : 현재 클래스에 implements ActionListener를 사용
		btn2.addActionListener(this);

		btn3.addActionListener(new EventTest());	// 방법02 : 내부 클래스 사용 implements
		
		btn4.addMouseListener(new EventTest2()); 	// 방법03 : 내부 클래스 사용 extend

		btn5.addMouseListener(new MouseAdapter() {	// 방법04 : 내부 무명 클래스 사용
			@Override
			public void mouseClicked(MouseEvent e) {
				// 여기는 btn5번을 클릭하면 수행되는 메소드
				setTitle("버튼 5 클릭 클릭");
			}
		});
	}
	
	@Override
	public void actionPerformed(ActionEvent e) { // 버튼 1번을 누르면 얘한테 온다.
		// 여기는 btn1, btn2를 클릭하면 수행되는 메소드
		// 두 개의 버튼을 구분지어줘야 한다.
		
		System.out.println(e.getActionCommand());
		System.out.println(e.getSource());
		if(e.getSource() == btn1) {	// 객체 비교 (==를 쓴다)
			setTitle("버튼 1 클릭");
		}else if(e.getSource() == btn2) {
			setTitle("버튼 2 click");
		}
	}
	
	
	class EventTest implements ActionListener {	// 내부 클래스
		@Override
		public void actionPerformed(ActionEvent e) {
			// 여기는 btn3번을 클릭하면 수행되는 메소드
			setTitle("버튼 3을 누르다니..");
		}
	}
	
	
	class EventTest2 extends MouseAdapter {
		// 여기는 btn4번을 클릭하면 수행되는 메소드
		@Override
		public void mouseClicked(MouseEvent e) {
			setTitle("버튼 마우스 이벤트로 btn4 처리");
		}
	}
	
	
	public static void main(String[] args) {
		// 이벤트 처리 정리
		new Ex44_Event();
		
		}
}
