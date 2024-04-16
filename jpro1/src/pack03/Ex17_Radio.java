package pack03;

public class Ex17_Radio extends Ex17_jepum {
	public Ex17_Radio() {
		System.out.println("라디오 생성자");
	}
	
	@Override	// 추상 메소드 오버라이딩
	public void volumeControl() {	// jepum 16, 17line 참조
		// 오버라이딩 강요 당함
		System.out.println("라디오 소리 조정");
	}
	
	@Override
	public void volumeShow() {
		// 오버라이딩 선택
		System.out.println("소리 크기는 적당히 : 부모 메소드 내용 대신 새로운 내용으로 대체");
	}
}
