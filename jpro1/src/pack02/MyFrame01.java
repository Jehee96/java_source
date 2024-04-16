package pack02;

import java.awt.Frame;

// 자바가 제공하는 Frame 클래스로 창 띄우기 : 포함 관계
public class MyFrame01 {
	private String title = "포함 관계";
	private Frame frame;
	
	public MyFrame01() {				// 생성자에 너무 많은 내용이 들어있으면 좋지 않다.
		frame = new Frame(title);
	}
	private void display() {
		frame.setSize(500, 300);		// 프레임 사이즈
		frame.setLocation(700, 450);	// 너비와 높이(모니터 어디에 뜰건지) <<정중앙 ㅋㅋ
		frame.setVisible(true);			// 창 띄워!!!
	}
	public static void main(String[] args) {
		MyFrame01 frame01 = new MyFrame01();
		frame01.display();
	}
}
