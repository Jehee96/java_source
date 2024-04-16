package pack03;

import java.awt.Frame;

public class MyFrame02 extends Frame{
	public MyFrame02() {
		// 생성자
		super("상속 사용");
	}
	
	void display() {
		setSize(500, 300);
//		super.setSize(500, 300);
		setLocation(700, 450);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		// 상속으로 Frame 띄우기
//		MyFrame02 frame = new MyFrame02();
//		frame.display();
		new MyFrame02().display(); // 두줄을 한줄로 바꾸깅
	}
}
