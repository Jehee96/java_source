package pack01;

public class Ex03_Programmer {  // 1. 멤버필드
//	public String nickName = " "; = nickName = 공백
	public String nickName; 	// 초기 값은 null <-참조형
//	private int age = 0;
	private int age;			// 초기 값은 0 <- 기본형
	String spec = "자바"; 
	
	public static String motto = "자바에 미쳐 버리자";	// 정적 변수
	public final String campName = "에이콘 아카데미"; 	// 상수. final = 수정 불가
	
	public Ex03_Programmer() {	// 2. 생성자
		System.out.println("난 생성자야. 역할은 객체 생성시 초기화를 담당해");
		System.out.println("초기화 없을 때는 생략 가능");
		age = 29;
//		displayData();
//		campName = "도토리"; 	// error
		System.out.println("캠프 이름은 : " + campName);
		}
	public void displayData() { // 3. 메소드 		(displayData()는 Ex03_Programmer의 멤버이다.)
		System.out.println("별명은 " + nickName + ", 나이는 " + age + "살, 보유 기술은 " + spec);
		 
		// 메소드가 다른 메소드 호출 가능
		System.out.println("보유기술 재 확인 : " + showSpec());
	}
	private String showSpec() {
		String msg = "프로그래밍 언어 : " + spec;
		return msg + "(커피 아님)"; // retrun 반환값은 무조건 하나임.
	}
	
	// private age에 대한 getter, setter 만들기
	public void setAge(int age) {
		// age = age; 				// int age에게 33의 값을 줘야 하는데 자기 자신에게 값을 줘서 29로 나이가 고정되어버림.
		this.age = age; 			// 지역변수 age를 전역변수 age에게 값을 줌
	}
	
	public int getAge() {
		return age;
	}
	
	static public void goodMethod() {
		System.out.println("스테틱 메소드임을 널리 알리노라");
		System.err.println(motto);
//		System.out.println(age);	// error. static 메소드는 일반 멤버 호출 불가. static은 static만 호출 가능.
	}
	public void niceMethod() {
		System.out.println(age); 	// 일반 메소드는 일반 멤버 호출 가능
		System.out.println(motto);	// 일반 메소드는 static 멤버 호출 가능
	}
}
