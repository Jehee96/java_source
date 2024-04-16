package pack03;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

// 인터페이스를 이용한 이벤트 처리 연습
public class MyFrame03 extends Frame implements WindowListener, MouseListener {
	public MyFrame03() {
		// 생성자
		super("상속 사용");
		super.setTitle("상속 사용");
		
		display();
		
		// 현재 Frame에 이벤트 리스너를 장착
		super.addWindowListener(this);	// 고로 아규먼트 값에 this를 쓰면 MyFrame03을 가리킨다.
		addMouseListener(this);
	}
	
	void display() {
		setSize(500, 300);
//		super.setSize(500, 300);
		setLocation(700, 450);
		setVisible(true);
	}
	
	// WindowListener가 가진 추상메소드 오버라이딩
	@Override
	public void windowActivated(WindowEvent e) {
	}

	@Override
	public void windowClosed(WindowEvent e) {
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
//		System.out.println("종료");
//		setTitle("안녕 종료는 아직...");
		System.exit(0);		// << 탈출구
		
	}
	
	// 창 이벤트
	@Override
	public void windowDeactivated(WindowEvent e) {
	}

	@Override
	public void windowDeiconified(WindowEvent e) {	// 창 열기 할 때 반응
		System.out.println("windowDeiconified");
	}

	@Override
	public void windowIconified(WindowEvent e) {	// 창 닫기 할 때 반응
		System.out.println("windowIconified");
	}
	
	@Override
	public void windowOpened(WindowEvent e) {
		System.out.println("windowOpened");
	}
	
	// 마우스 이벤트
	@Override
	public void mouseClicked(MouseEvent e) {
//		System.out.println("클릭 성공 후 점심 먹기");
//		setBackground(new Color(163, 160, 237));
//		System.out.println((int)(Math.random() * 255));
		int r = (int)(Math.random() * 255);
		int g = (int)(Math.random() * 255);
		int b = (int)(Math.random() * 255);
		setBackground(new Color(r, g, b));
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		
	}
	
	public static void main(String[] args) {
		new MyFrame03();
	}
}