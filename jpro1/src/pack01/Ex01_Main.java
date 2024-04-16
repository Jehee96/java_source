package pack01;

public class Ex01_Main {

	public static void main(String[] args) { 	// 응용 프로그램의 시작, 즉 main을 위한 클래스일 뿐.
		System.out.println("이런 저런 작업을 하다가...");
		int a = 1;
		System.out.println("기본형 변수 a가 기억한 값 : " + a);
		
		// 자동차 객체를 만들고 싶어졌다
		Ex01_Car car1 = new Ex01_Car(); 		// 클래스 -----> 인스턴스화 -----> 인스턴스(객체) // 기본 생성자
		// Ex01_Car : 보조기억장치에 있는 Ex01Car.class를 주기억장치로 로딩
		// car1 : 객체 변수 - 객체의 주소를 기억
		// new : 인스턴스화를 키워드
		// Ex01_Car() : 생성자를 호출
		
		System.out.println("Ex01_Car 타입의 생성된 객체 주소 : " + car1); // pack01.Ex01_Car@6504e3b2 : heap영역에 있는 주소 출력
		System.out.println("바퀴 수 : " + car1.wheel); 					  // 바퀴 수 : 0 -> 4 // 생성자를 호출(0에서 4로 초기화)하며 값이 바뀜
		car1.abc(); 	// ← 메소드        ↑ 멤버필드
//		car1.def();     private이므로 호출 불가
		
		System.out.println("--- 객체 하나 더 생성 ---");
		Ex01_Car car2 = new Ex01_Car();
		System.out.println("Ex01_Car 타입의 생성된 객체 주소 : " + car2); // pack01.Ex01_Car@5577140b
		System.out.println("바퀴 수 : " + car2.wheel);
		car2.abc();
		
		System.out.println();
		System.out.println(car1.getClass()); 						// 객체변수 타입 확인
		System.out.println(car2.getClass()); 						// car1, 2 다 class pack01.Ex01_Car타입
		System.out.println(car1.getClass() == car2.getClass()); 	// 타입 비교 = true
		System.out.println(car1 == car2); 							// 주소 비교 = false
	}
}
