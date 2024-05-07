package lambda;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JButton;
import javax.swing.JFrame;

public class My_Lambda04_Event {
	public static void main(String[] args) {
		JFrame frame = new JFrame("람다 연습");
		JButton button1 = new JButton("Click1");	// 이벤트 처리
		JButton button2 = new JButton("Click2");	// 이벤트 처리
		JButton button3 = new JButton("Click3");	// Collection 처리
		
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 전통적인 방법
				System.out.println("전통적 방법으로 이벤트 처리");
				
			}
		});
		// 람다 사용
		button2.addActionListener(e -> System.out.println("람다로 이벤트 처리"));
		button3.addActionListener(e -> callMathod());
		
		frame.add("North", button1);
		frame.add("Center", button2);
		frame.add("South", button3);
		frame.setBounds(200, 200, 300, 300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	static void callMathod() {
		// System.out.println("a");
		ArrayList<Jikwon> jikwons = new ArrayList<My_Lambda04_Event.Jikwon>();
		jikwons.add(new Jikwon(3, "홍길동"));
		jikwons.add(new Jikwon(1, "고길동"));
		jikwons.add(new Jikwon(2, "나길동"));
		
		System.out.println("정렬 전 : ");
//		for(Jikwon j:jikwons) {
//			System.out.println(j.number + " " + j.name);
//		}
//		accept(Jikwon j) {
//			(System.out.println(j.number + " " + j.name);
//		}
		
		jikwons.forEach(j -> System.out.println(j.number + " " + j.name));
		
		System.out.println("Collections.sort 사용");
		// 특정 메소드의 매개변수로 람다식 사용
		Collections.sort(jikwons, new Comparator<Jikwon>() { //Comparator<T>도 function interface이다.
			public int compare(Jikwon o1, Jikwon o2) {
				return o1.number - o2.number;
			}
		});
		System.out.println("정렬 후 1: ");
		jikwons.forEach(jik -> System.out.println(jik.number + " " + jik.name));
		
		System.out.println("정렬 후 2(람다 사용): ");
		Collections.sort(jikwons, (o1, o2) -> o1.number - o2.number);
		jikwons.forEach(jik -> System.out.println(jik.number + ", " + jik.name));
	}
	
	// 내부 클래스
	static class Jikwon {	// DTO or VO
		// 디폴트값
		int number;
		String name;
		
		public Jikwon(int number, String name) {
			this.number = number;
			this.name = name;
		}
	}
}
