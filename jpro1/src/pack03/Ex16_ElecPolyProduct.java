package pack03;

public class Ex16_ElecPolyProduct {
	// 가전제품이 가져야할 기본 멤버를 선언한 부모 클래스
	private int volume = 0;
	
	public Ex16_ElecPolyProduct() {	// 생성자
		
	}
	
	// 메소드의 이름 강요 용도..? -> 다형성때문에
	public void volumeControl() {	// 추상메소드 (바디가 없음.)
		// 가전제품의 볼륨을 조절하는 기능
		// 자식 클래스가 오버라이딩해서 사용하기를 기대하는 메소드
	}
	
	public void setVolume(int volume) {	// volume값 넣고
		this.volume = volume;
	}
	public int getVolume() {			// volume값 읽음
		return volume;
	}
	
}
