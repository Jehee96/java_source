package pack01;

public class Ex06_Main {

	public static void main(String[] args) {
		// 같은 패키지에 있는 Ex06_Bank 클래스를 사용
		
		Ex06_Bank kildong = new Ex06_Bank();	// 빈손
		kildong.dePosit(5000);					// 1000원에 5000원을 누적(입금) = 6000
		kildong.withDraw(2000);					// 6000원에서 2000원을 출금 = 4000
		System.out.println("kildong 예금액 : " + kildong.getMoney());
//		kildong.money();						// 에러 : private 멤버이므로 해당 클래스에서만 참조
		System.out.println("a: " + kildong.a);	// default
		System.out.println("a: " + kildong.b);	// public
		
		System.out.println();
		Ex06_Bank dajeong = new Ex06_Bank(2000);// 2000원 추가 (1000원 디폴트)
		dajeong.dePosit(5000);					// 3000원에 5000원을 누적(입금) = 8000
		dajeong.withDraw(2000);					// 8000원에서 2000원을 출금 = 6000
		dajeong.withDraw(12000);				// 출금액이 너무 많아요
		System.out.println("dajeong 예금액 : " + dajeong.getMoney());
		
		System.out.println("\n------- 객체 주소 관련 -------");
		// 각자 다른 주소를 가지고 있음
		System.out.println("kildong 주소 : " + kildong + " " + kildong.hashCode());	// pack01.Ex06_Bank@e6ea0c6 242131142 (10진수로 주소 표현)
		System.out.println("dajeong 주소 : " + dajeong);							// pack01.Ex06_Bank@5577140b (16진수로 주소 표현)
		
		Ex06_Bank tom = null; 	// = Ex06_Bank tom; 인스턴스 값 존재하지 않음
		System.out.println("tom 주소 : " + tom); 				// null
//		System.out.println("tom 예금액 : " + tom.getMoney());	// NullPointerException
		tom = dajeong;	// 주소 치환
		System.out.println("tom 예금액 : " + tom.getMoney());	// 6000
		
		if(dajeong == tom) {
			System.out.println("둘은 같은 주소");
		}else {
			System.out.println("둘은 다른 주소");
		}
		if(dajeong == kildong) {
			System.out.println("둘은 같은 주소임을 알림");
		}else {
			System.out.println("둘은 다른 주소야");
		}
		
		System.out.println(dajeong instanceof Ex06_Bank);	// true
		if(dajeong instanceof Ex06_Bank) {
			// instanceof : 객체 타입 비교 연산자 -true or false값 반환
			System.out.println("Ex06_Bank 타입이 맞아요");
		}else {
			System.out.println("ㅠㅠ Ex06_Bank 타입이 아니군요");
		}
		
		System.out.println("\n----- 스트링(String) 타입의 값 비교 -----");
		String ss1 = "kor";	// String class : 기본형처럼 사용할 수 있도록 자바가 배려함
		// ss2에 kor 값을 넣어줌
		String ss2 = new String();
		ss2 = "kor";
		// new String에 kor값을 밀어 넣음
		String ss3 = new String("kor");
		System.out.println(ss1 + " " + ss2 + " " + ss3);
		
		
		if(ss1 == ss2)
			System.out.println("같음1");	// 결과
		else
			System.out.println("다름1");
		if(ss1 == ss3)
			System.out.println("같음2");	// 결과
		else
			System.out.println("다름2");
		
		// 그러므로 결론은 String은 주소 비교가 아니라 값을 비교하는 것이 목적이므로 equals()사용. (영문 대소문자 구분함)
		if(ss1.equals(ss2))		// 값 비교
			System.out.println("같음3");			
		else
			System.out.println("다름3");
		if(ss1.equals(ss3))
			System.out.println("같음4");			
		else
			System.out.println("다름4");
		
//		equalsIgnoreCase()
		System.out.println();
		if(ss1.equalsIgnoreCase(ss3))	// 값 비교 (영문 대소문자 구분 안함)
			System.out.println("같음5");			
		else
			System.out.println("다름5");
	}
}
