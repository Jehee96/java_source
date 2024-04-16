package pack03;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

// 어댑터 클래스를 이용한 이벤트 처리 연습
// WindowAdapter 추상 클래스는 WindowListener 인터페이스를 구현한 클래스이다,
// WindowListener의 추상 메소드가 WindowAdapter에서 일반 메소드로 오버라이드(재정의)
public class MyFrame04Adapter extends WindowAdapter {	// 단일상속이라 콤마(,)를 사용한 다중상속은 안됨..
	private Frame frame;
	
	public MyFrame04Adapter() {
		frame = new Frame("Adapter 연습");
		
		frame.setSize(350, 300);
		frame.setLocation(850, 600);;
		frame.setVisible(true);
		
		frame.addWindowListener(this);
		// WindowListener를 WindowAdapter가 가지고 있다. 그런 WindowAdapter를 extends를 했으므로 현재 클래스에서 WindowListener를 부를 수 있다.
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
	// 선택적으로 필요한 메소드를 오버라이딩 할 수 있다.
		System.exit(0);
	}
	
	
	public static void main(String[] args) {
		new MyFrame04Adapter();
	}
}