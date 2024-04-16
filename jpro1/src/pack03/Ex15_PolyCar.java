package pack03;

// 자동차가 가져아 할 기본 멤버를 선언한 자원 클래스
// 다른 클래스 포함 또는 상속을 통해 자원을 사용할 수 있다.

public class Ex15_PolyCar {
	protected int speed = 50;
	
	public Ex15_PolyCar() {
		System.out.println("나는 자동차 원형 클래스댱");
	}
	
	public void displaySpeed() {
		System.out.println("속도 : " + speed );
	}
	public int getSpeed() {
		return speed;
	}
}
