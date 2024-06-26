package pack01;			// 성격이 비슷한 패키지를 모아놓음

// 접근 지정자
// - public : 같은 프로젝트 내에서 유효. 패키지가 달라도 됨
// - protected : 같은 프로젝트 내에서 유효. 패키지가 다른 경우 자식 클래스만 유효(상속)
// - default : 같은 패키지 내에서만 유효
// - private : 현재 클래스 내에서만 유효. 다른 클래스에서는 참조 불가


// 전역 변수
public class Ex01_Car { 		// [접근지정자][기타제한자] class 클래스명 ++class 명과 파일명은 같아야함++
	int wheel;					// 멤버 필드(전역 변수) : default 접근 지정자 (초기치로 0을 가짐)
	private int airBag; 		// [접근지정자][기타제한자] 타입 변수명
	private int speed; 			// private 하고 주면 캡슐화가 된다 (EX01_Car)에서만 사용 가능
	public String irum;
	
// 지역 변수	
	public Ex01_Car() {			// 클래스와 이름이 같아야 하고 반환형이 없는 메소드 : 생성자(Constructor)
		System.out.println("생성자 : 객체 생성시 초기화를 담당. 1회 호출됨"); //생성자에 쓸 내용이 없다면 생략 가능. new로 호출
		wheel = 4;
		airBag = 1;
	}
	public void abc() { 		// [접근지정자][기타제한자] 반환타입(형) 메소드명([타입 매개변수...])
		System.out.println("abc 메소드 수행"); // 아무때나 호출 가능
		System.out.println("에어백 수는 " + airBag);
		def();   				// private 멤버는 현재 클래스 내에서만 사용 가능
	}
	public void def() {
		System.out.println("def 메소드 수행");
	}
}
