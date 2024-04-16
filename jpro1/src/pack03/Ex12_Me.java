package pack03;

public class Ex12_Me extends Ex12_Father {		// 내 클래스
	final int score = 90;	// 멤버필드에 final 하면 값 수정 불가
	
	private int nai;
	
	
	public Ex12_Me() {
//		super(); 	// 생략 가능
		System.out.println("내 생성자");
//		score = 80;	// error
	}
	
	public void biking() {
		System.out.println("자전거로 전국일주");
	}
	
//	public String getHouse() {	// 부모에서 final 했으므로 오버라이딩 불가 (아빠 집 못 물려받음)
//		return "집 : " + house + "채";
//	}
	
}
