package pack03;

public class Ex16_ElecMain {

	public static void main(String[] args) {
		// 가전제품 부모 클래스 생성 후 volumeControl()을 오버라이딩하여 다형성 구사
		Ex16_ElecPolyProduct product = null;	// 부모 객체로만 의미를 가짐(null이므로 값x)
		
		Ex16_ElecPolyRadio radio = new Ex16_ElecPolyRadio();
		radio.setVolume(7);
		System.out.println(radio.getVolume());
		radio.volumeControl();
		
		System.out.println();
		Ex16_ElecPolyTv tv = new Ex16_ElecPolyTv();
		tv.setVolume(5);
		tv.volumeControl();	// polytv에 int sosiSize = getVolume();<<
		tv.tvShow(); 		// tv 고유 메소드
		
		
		System.out.println("\n ----- 다형성 -----");
		product = radio;	// promotion //오버라이딩된 메소드 사용
		product.volumeControl();
		System.out.println();
		product = tv;		// promotion //오버라이딩된 메소드 사용
		product.volumeControl();
		
	}

}
