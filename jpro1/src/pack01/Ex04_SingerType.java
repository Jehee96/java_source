package pack01;

import java.util.jar.Attributes.Name;

// setter나 생성자에 의해서 값이 변할 수 있다.
public class Ex04_SingerType {				// 가수들이 가져야 할 기본 멤버를 클래스로 작성(설계도)
	private String name = "무명 가수";		// 이름
	private String title = "아 대한민국";	//곡 제목
	// ...
	
	// 생성자를 통해 멤버 변수에 값 저장. 한 번 쓴거 재탕~
	public Ex04_SingerType(String name, String title) {
		// this.name = "bts";
		this.name = name;
		this.title = title;
	}
	
	// 참조용 get
	public String getName() { 				// getter
		return name;
	}

	public String getTitle() {
		return title;
	}
	public void sing() {
		System.out.println(name + " is snging " + title + "...");
	}

	public static void main(String[] args) {
		// 응용 프로그램 시작용 메소드
		// Ex04_SingerType 멤버는 아님
		Ex04_SingerType bts = new Ex04_SingerType("BTS", "Dynamite");
		bts.sing();
		System.out.println("가수 이름 : " + bts.getName());
		System.out.println("곡 제목 : " + bts.getTitle());
		
		System.out.println();
		Ex04_SingerType blackpink = new Ex04_SingerType("BlackPink", "How tou like that");
		blackpink.sing();
		System.out.println("가수 이름 : " + blackpink.getName());
		System.out.println("곡 제목 : " + blackpink.getTitle());
		// bts, blackpink는 같은 singer type이지만 들어있는 값은 다르다.
	}
}