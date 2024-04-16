package pack01;

public class Ex02_Main {

	public static void main(String[] args) {
		// getter, setter 연습
		System.out.println("프로그램을 실행하다가...");
		
		// Ex02_Car 객체 만들기
		System.out.println();
		Ex02_Car tom = new Ex02_Car();
		tom.showData();  						   // 이름은 홍길동, 속도는 10
		System.out.println("이름은 " + tom.irum);
		tom.irum = "미스터 톰"; 				   // private이 아니므로 접근 가능
		System.out.println("이름은 " + tom.irum);  // 이름은 미스터 톰
		
		System.out.println("겟터, 셋터 확인");
//		tom.speed = 80; 							   // private이므로 접근 불가
//		tom.abcd(80, 123); 							   // int s에 80의 값을 줌. 그리고 그 값을 speed에 넘겨줌. // 예를 들어 비밀번호에 의해 수정 결정
		tom.setSpeed(80);
		tom.showData();
		System.out.println("속도는 " + tom.getSpeed()); // 1번
//		int result = tom.getSpeed(); 					// 2번 또이또이
//		System.out.println("속도는 " + result);
	}
}
