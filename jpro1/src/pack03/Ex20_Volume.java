package pack03;

//	1. 추상 메소드와 상수로 구성된 클래스
//	2. 다중상속이 가능
//	3. 인터페이스는 인스턴스(new) 할 수 없다.
//	4. 인터페이스는 자식 클래스에서 implementd 키워드로 구현한다.
//	5. 인터페이스간 상속이 가능

public interface Ex20_Volume {
	void volumeUp(int level);

	void volumeDown(int level);
}
//	void print();
// 일반 메소드는 사용할 수 없다.
