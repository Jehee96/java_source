package pack03;

public class Ex25_Person {
	public Ex25_Saram getSaram() {
//		return new Ex25_Saram();

		return new Ex25_Saram()
	{	// 내부 무명 클래스
			public String getIr() {	// Ex25_Saram 클래스의 메소드를 오버라이딩
					return "홍길동";
			}
		};
	}
}
