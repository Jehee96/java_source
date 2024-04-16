package pack01;

import javax.sound.midi.Soundbank;

public class Ex03_Main {

	public static void main(String[] args) {
		// 클래스 기본 연습 중
		Ex03_Programmer programmer = new Ex03_Programmer();
		programmer.displayData();
		
		System.out.println();
		programmer.nickName = "지렁이";
		programmer.setAge(33);
		System.out.println("나이는 " + programmer.getAge());
		programmer.displayData();
		
		System.out.println("--------------");
		Ex03_Programmer tom = new Ex03_Programmer();
		tom.nickName = "톰 아저씨";
		tom.setAge(44);
		tom.displayData();
		
		System.out.println("--------------");
		Ex03_Programmer james = new Ex03_Programmer();
		james.nickName = "제임스형";
		james.setAge(59);
		james.displayData();
		
		System.out.println(); // System 클래스 = out 필드 <<static관련
		System.out.println("너의 모토는 " + james.motto);
		
		// static 멤버는 클래스 이름.멤버 하고 사용한다(권장) //바로바로 부를 수 있는 장점이 있음.
		// System.out.println("너의 모토는 " + Ex03_Programmer.motto);
		Ex03_Programmer.goodMethod();
		}
}
