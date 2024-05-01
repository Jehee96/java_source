package pack07_Gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.nio.channels.spi.AbstractInterruptibleChannel;

//	1) AWT(Abstract Window Toolkit)란?
//	- GUI프로그래밍(윈도우 프로그래밍)을 위한 도구이다.
//	- Java로 구현하지 않고 OS의 컴포넌트를 그대로 사용(OS 종속적)

//	2) Swing
//	- AWT를 확장한 GUI프로그래밍 도구
//	- AWT보다 더 많은 종류의 컴포넌트 제공
//	- OS의 컴포넌트를 사용하지 않고 Ja로 구현

//	3) AWT의 구성
//	- AWT관련 패키지는 모두 java.awt로 시작
//	- AWT컴포넌트의 최상위 조상은 java.awt.Component 클래스(메뉴 관련 컴포넌트 제외)

//	4) Container
//	- 다른 컴포넌트를 포함할 수 있는 컴포넌트
//	- 독립적인 컨테이너: 독립 사용 가능, 다른 컴포넌트나 종속적 컨테이너를 포함 가능
//	- 종속적인 컨테이너: 독립 사용 불가(다른 컨테이너에 포함)
//	- add()를 사용해서 추가
//	- 컨테이너에 담기는 컴포넌트는 컨테이너의 설정을 따름(변경 가능)


// LayOutManager 참조 : https://m.blog.naver.com/so_yuns/222172786073
// Frame : BorderLayout이 기본이다.
// Panel : FlowLayout이 기본이다.
// 둘 다 컴포넌트임.

public class Ex43_Frame_Layout extends Frame implements ActionListener{ // Frame도 컨테이너이다. (가장 큰 그릇)
	Panel pn1 = new Panel(); 				   // 컨테이너(Visual Object을 담는 그릇)의 일종
	Panel pn2 = new Panel();
	Panel pn3 = new Panel();
	Panel pn4 = new Panel();
	Panel pn5 = new Panel();
	Panel pn6 = new Panel();
	
	TextField txtBun, txtIrum;
	Button btnGo;
	CardLayout card = new CardLayout();
	
	public Ex43_Frame_Layout() {
		// 배치 관리자로 화면 디자인 연습
		setLayout(new GridLayout(2, 1)); // Frame의 Layout을 변경 (2행 1열)
		
		// 첫 번째 행 디자인
		Label lbl1 = new Label("bunho : "); // 메세지 컴포넌트
		txtBun = new TextField("10", 20); 	// 키보드로 자료 입력 가능
		pn1.add(lbl1); 						// Panel에 Label 객체 담기
		pn1.add(txtBun); 					// Penel에 txtField 객체 담기
		pn1.setBackground(Color.YELLOW);	// Penel 배경색 변경
		// super.add(pn1);						// Framd에 Penel을 담기
		
		Label lbl2 = new Label("irum : "); // 메세지 컴포넌트
		txtIrum = new TextField("이기자", 30); 	// 키보드로 자료 입력 가능
		pn2.add(lbl2); 						// Panel에 Label 객체 담기
		pn2.add(txtIrum); 					// Penel에 txtField 객체 담기
		pn2.setBackground(Color.CYAN);
		
		pn3.setLayout(card);				// pn3 : FlowLayout을 CardLayout으로 변경
		pn3.add("first", pn1);				// pn3에 first라는 이름으로 pn1을 담음
		pn3.add("second", pn2);				// pn3에 second라는 이름으로 pn2을 담음
		btnGo = new Button("ok");
		btnGo.addActionListener(this);		// 버튼 이벤트 감지
		
		pn4.add(pn3); // pn4 : FlowLayout
		pn4.add(btnGo);
		super.add(pn4);
		
		
		// 두 번째 행 디자인
		pn5.setLayout(new BorderLayout()); // pn5 : FlowLayout을 BorderLayout으로 변경
		pn5.setBackground(new Color(123, 123, 123));
		pn5.add("East", new Label("kbs")); // 앞에는 키워드임. 동쪽에 kbs를 넣으라는 뜻
		pn5.add("West", new Label("mbc"));
		pn5.add("South", new Label("sbs"));
		pn5.add("North", new Label("ytn"));
		pn5.add("Center", new Label("tvn"));
		
		super.add(pn5);
		
		super.setTitle("레이아웃 연습");
		super.setBounds(200, 200, 400, 300);
		super.setVisible(true);
		
		super.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	@Override
		public void actionPerformed(ActionEvent e) {
			// 버튼 이벤트 처리 메소드
			// 버튼을 클릭하면 pn1과 pn2를 교체
			// System.out.println("good");
			// System.out.println(e.getActionCommand());
			if(e.getActionCommand().equalsIgnoreCase("ok")) {
				btnGo.setLabel("go");
				card.show(pn3, "second"); // pn3에 담긴 pn2를 보여줘
			}else {
				btnGo.setLabel("ok");
				card.show(pn3, "first");  // pn3에 담긴 pn1를 보여줘
			}
		
		}
	
	
	public static void main(String[] args) {
		new Ex43_Frame_Layout();
	}

}
