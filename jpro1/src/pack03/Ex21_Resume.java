package pack03;

public interface Ex21_Resume {	// 이력서 표준 양식
	String SIZE = "A4";	// public final static String SIZE = "A4"; (final은 보통 대문자로 씀)
//	int kor = 90;
	
	// 얘네는 추상. 이 메소드만큼은 반드시 쓰도록 이름 강요
	void setIrum(String irum);
	void setPhone(String phone);
	void printData();
	
	// java 1.8 이후에 가능.
	default void display(boolean b) {
		if(b) {
			System.out.println("참");
		}else {
			System.out.println("거짓");
		}
	}
	
	static void play() {
		System.out.println("play 메소드");
	}
}
