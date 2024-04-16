package pack01;

import java.awt.Frame;
import java.awt.Label;

//public class Ex07_Production {
//
//	public static void main(String[] args) {
// 연습?
// + name(문자)	
// - price(정수)		
// - weight (실수)		

// + show()
// gettet, setter 작성
// 메소드 오버로딩
// 생성자 오버로딩		
	
		


		public class Ex07_Production extends Frame {

		    public Ex07_Production(String title) {
		        super(title); // 상위 클래스의 생성자를 호출하여 프레임의 제목을 설정합니다.
		        
		        // 레이블 추가
		        Label label = new Label("Hello, AWT Frame!");
		        this.add(label);

		        // 프레임의 크기 설정
		        this.setSize(300, 200);

		        // 프레임을 보이게 설정
		        this.setVisible(true);
		    }

		    public static void main(String[] args) {
		    	Ex07_Production myFrame = new Ex07_Production("My AWT Frame");
		    }
		}
	
	


