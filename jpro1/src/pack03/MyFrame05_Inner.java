package pack03;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyFrame05_Inner extends Frame {
//	private Wevent wevent = new Wevent(); 이렇게 쓰나
//	private Wevent wevent;
	private int x, y; // mouseClicked 에서 발생한 x, y 좌표를 기억
	private String[] names= {"정재형", "이원재", "지명기", "김성하", "김서현"};
	
	public MyFrame05_Inner() {
		setTitle("내부 클래스");
		
		setSize(300, 250);
		setLocation(200, 200);
		setVisible(true);
		
//		wevent = new Wevent(); 		//이렇게 쓰나 똑같은 코드임.
//		addWindowListener(wevent);	// Frame이 가지고 있는 메소드
		// 이렇게 써도 같음
		addWindowListener(new Wevent());
		addMouseListener(new Mevent());
	}
	
	// MyFrame05_Inner 안에서만 사용 가능한 클래스
	class Wevent extends WindowAdapter {	// MyFrame05_Inner의 멤버들
		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	}
	
	class Mevent extends MouseAdapter {		// 내부 클래스
		@Override
		public void mouseClicked(MouseEvent e) {
//			setTitle("클릭");
			
			// 무브 이벤트(좌표값)
//			int x = e.getX();	//  지역변수에 값 치환
//			int y = e.getY();
			
			x = e.getX();
			y = e.getY();
			setTitle("x:" + x + ", y:" + y);
			
			paint(getGraphics());	// 자동 호출되는 paint()를 명시적으로 호출 가능
			repaint();	// Graphics 객체를 가진 paint()를 호출. refresh가 됨
		}
		
	}
	
	@Override
		public void paint(Graphics g) {	// 자동 호출이 기본
			// Graphics : Frame이 제공하는 그림 그리기 객체
//			g.drawString("홍길동", 130, 125);
		
			g.setFont(new Font("굴림", Font.ITALIC, (int)(Math.random() * 50 + 8)));
			
			int n = (int)(Math.random() * 5);
//			g.drawString("홍길동", x, y);
			g.drawString(names[n], x, y);
			
	}
	
	public static void main(String[] args) {
		new MyFrame05_Inner();
	}
		
}
