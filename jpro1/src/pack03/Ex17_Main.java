package pack03;

public class Ex17_Main {

	public static void main(String[] args) {
		// 추상 클래스 연습
//		Ex17_jepum jepum = new Ex17_jepum();	// 추상 클래스는 인스턴스
		Ex17_jepum jepum = null;
		
		Ex17_Radio radio = new Ex17_Radio();	// 강제 실행(?)
		jepum = radio;
		radio.volumeControl();

		System.out.println();
		Ex17_Tv tv = new Ex17_Tv();
		jepum = tv;
		jepum.volumeControl();
		
		System.out.println("-- 배열로 --");
		Ex17_jepum jepumarr[] = {radio, tv};
		for(Ex17_jepum j:jepumarr) {
			j.volumeControl();
		}
	}
}
