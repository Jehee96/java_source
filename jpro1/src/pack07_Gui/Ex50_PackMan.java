package pack07_Gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

public class Ex50_PackMan  extends JFrame implements KeyListener{
	// Image클래스
	Image image;			// 캐릭터 이미지
	int x = 100, y = 100;	// 캐릭터 좌표
	int selImage = 1;
	
	
	public Ex50_PackMan() {
		super("상하좌우 화살표를 사용하세요.");
		
		// 타이틀의 아이콘 이미지 바꾸기.                 // 이미지 경로는 절대경로임!!
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Workstation\\Acorn\\jsou\\jpro1\\src\\pack07_Gui\\pack1.jpg"));
		
		setLayout(null);	 // 배치관리자 없음
		setResizable(false); // 창 크기조절 불가.
		
		setBounds(200, 200, 300, 300);
		setBackground(Color.WHITE);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		addKeyListener(this);
		
		x = super.getWidth() / 2; // Frame의 너비 절반
		y = super.getHeight() /2 ;// Frame의 높이 절반
	}
	
	@Override
	public void paint(Graphics g) {
		// Frame에 뭔가를 그려주는 메소드로 자동 호출
		switch(selImage) {
		case 1:
			image = Toolkit.getDefaultToolkit().getImage("C:\\Workstation\\Acorn\\jsou\\jpro1\\src\\pack07_Gui\\pack1.jpg");
			break;
		case 2:
			image = Toolkit.getDefaultToolkit().getImage("C:\\Workstation\\Acorn\\jsou\\jpro1\\src\\pack07_Gui\\pack2.jpg");
			break;
		case 3:
			image = Toolkit.getDefaultToolkit().getImage("C:\\Workstation\\Acorn\\jsou\\jpro1\\src\\pack07_Gui\\pack3.jpg");
			break;
		case 4:
			image = Toolkit.getDefaultToolkit().getImage("C:\\Workstation\\Acorn\\jsou\\jpro1\\src\\pack07_Gui\\pack4.jpg");
			break;
		case 5:
			image = Toolkit.getDefaultToolkit().getImage("C:\\Workstation\\Acorn\\jsou\\jpro1\\src\\pack07_Gui\\pack5.jpg");
			break;
		case 6:
			image = Toolkit.getDefaultToolkit().getImage("C:\\Workstation\\Acorn\\jsou\\jpro1\\src\\pack07_Gui\\pack6.jpg");
			break;
		case 7:
			image = Toolkit.getDefaultToolkit().getImage("C:\\Workstation\\Acorn\\jsou\\jpro1\\src\\pack07_Gui\\pack7.jpg");
			break;
		case 8:
			image = Toolkit.getDefaultToolkit().getImage("C:\\Workstation\\Acorn\\jsou\\jpro1\\src\\pack07_Gui\\pack8.jpg");
			break;
		}
		
		
		g.clearRect(0, 0, getWidth(), getHeight());	// 화면 전체를 선택 후 clear : 잔상 해결(이미지 배경 cut)
		
		
		// 이미지를 잘라서 정 중앙에 와있는것처럼 보이게 함.
		g.drawImage(image, x - image.getWidth(this) / 2, y - image.getHeight(this) / 2, this);
	}
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		// 키를 눌렀을 때 이벤트가 벌어짐
		int key = e.getKeyCode();
		//System.out.println("key : " + key); // 아스키코드값으로 콘솔에 찍힘
		
		// 오른쪽 화살표
		if(key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_NUMPAD6) { // VK_NUMPAD6 : 오른쪽 화살표
			// System.out.println("Go");
			selImage = (selImage == 1)?2:1;	// 삼항연산자 ?참, :거짓
			// x = x + 10;
			x = (x < getWidth())?x +=10:-image.getWidth(this);
		}
		// 왼쪽 화살표
		else if(key == KeyEvent.VK_LEFT || key == KeyEvent.VK_NUMPAD4) {	
		selImage = (selImage == 3)?4:3;
		x = (x > 0)?x -=10:getWidth()+image.getWidth(this);
	}
		
		// 윗쪽 화살표
		else if(key == KeyEvent.VK_UP || key == KeyEvent.VK_UP) {	//VK_UP
			selImage = (selImage == 7)?8:7;
			y = (y > 0)?y -=10:getHeight()+image.getHeight(this);
		}
		// 아랫쪽 화살표
		else if(key == KeyEvent.VK_DOWN || key == KeyEvent.VK_DOWN) {	//VK_DOWN
			selImage = (selImage == 5)?6:5;
			y = (y < getHeight())?y +=10:image.getHeight(this);
		}
		
		repaint(); // paint를 호출함. (새로고침)
}
	@Override
	public void keyReleased(KeyEvent e) {}
	@Override
	public void keyTyped(KeyEvent e) {}
	
	
	public static void main(String[] args) {
		// 키보드 이벤트 연습
		new Ex50_PackMan();

	}

}
