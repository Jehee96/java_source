package pack06_Thread;

import java.awt.Button;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.time.LocalTime;

public class Ex39_ThreadClock extends Frame implements ActionListener, Runnable { // ActionListener : 버튼용
	Label lblMessage;
	boolean bExit = false;	// 종료를 위한 변수
	Thread thread;
	
	
	public Ex39_ThreadClock() {	// Ex39_ThreadClock 생성자
		lblMessage = new Label("show time", Label.CENTER);	// 창 상단
		super.add("Center", lblMessage);
		
		Button btnClick = new Button("click");	// 버튼창
		super.add("South", btnClick);			// 클릭버튼 아래로
		btnClick.addActionListener(this); 		// implements ActionListener가 가지고 있으므로 현재 클래스에 존재. this
		
		setTitle("스레드 시계");
		setBounds(200, 200, 300, 300);			// 창 위치
		setVisible(true);		// 창 키고
		
		addWindowListener(new WindowAdapter() {	// sper.addWindowListener와 같음
			@Override
			public void windowClosing(WindowEvent e) {
				bExit = true;	// run()의 무한루핑을 탈출하기 위해 true값을 줌
				System.exit(0);	// 창 꺼라
			}
		});
		
		thread = new Thread(this);
		
	}
	
	@Override
		public void actionPerformed(ActionEvent e) {
			// 버튼을 클릭하면 수행될 메소드
			// System.out.println("야호");
			// showData();
		
			// 만약 사용자 정의 스레드가 이미 있다면(버튼 클릭) start()를 호출하지 않음
			if(thread.isAlive()) return; // 1회만 호출됨
			thread.start();
			
		}
	
	@Override
		public void run() {		// 사용자 정의 스레드영역. while이 true가 되면 빠져나간당
			while(true) {
				//if(bExit == true) break;
				if(bExit) break;
				
				showData();
				try {
					Thread.sleep(1000); 	// 1초동안 비활성화
				} catch (Exception e) {
					// TODO: handle exception
				}
				
			}
		}
	
	private void showData() {
		LocalDate date = LocalDate.now();	// singleton 패턴
		int y = date.getYear();
		int m = date.getMonthValue();
		int d = date.getDayOfMonth();
		
		LocalTime time = LocalTime.now();
		int h = time.getHour();
		int mi = time.getMinute();
		int s = time.getSecond();
		
		String ss = y + " - " + m + " - " + d + " " + h + " : " + mi + " : " + s;
		lblMessage.setText(ss);
		lblMessage.setFont(new Font("Times new Roman", Font.BOLD, 20));
	}

	public static void main(String[] args) {
		// 스레드를 이용한 현재 날짜 및 시간 표시
		new Ex39_ThreadClock();

	}

}
