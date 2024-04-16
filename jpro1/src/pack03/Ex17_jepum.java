package pack03;

// 부모 객체변수만 가질수 있다. 스스로 new 하지도 못한다.
// 클래스, 메소드 둘다 무조건 추상이어야 한다. 둘중 하나만 추상은 x
public abstract class Ex17_jepum {
	// 가전 제품의 원형 클래스 : 추상 클래스
	public int volume = 0;
	
	public Ex17_jepum() {
		System.out.println("추상 클래스 생성자");
	}
	
	public abstract void volumeControl();	// body가 없는 메소드
	// 자식클래스에서 반드시 오버라이딩하도록 **강요**
	
	public void volumeShow() {		// 오버라이딩 해서 쓰든 말든 알아서 **선택**
		System.out.println("소리 크기는 " + volume);
	}
}
