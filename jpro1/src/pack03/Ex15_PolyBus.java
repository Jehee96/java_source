package pack03;

public class Ex15_PolyBus extends Ex15_PolyCar {
	private int passenger = 10;
	
	public void show() {	// Ex15_PolyBus 고유 메소드
		System.out.println("버스");
	}
	
	@Override	// Annotation, 메타데이터 : 컴파일러에게 다양한 정보를 알려주는 역할
	public void displaySpeed() {
		System.out.println("버스 승객 수는 " + passenger);
		System.out.println("버스의 속도는 " + speed);
	}
	
}
