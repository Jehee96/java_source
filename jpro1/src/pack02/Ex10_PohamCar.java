package pack02;

public class Ex10_PohamCar {
	// 여러 개의 부품이 모인 완성차 설계도(class)
	int speed = 0;
	String ownerName, turnMessageShow;	// 완성차 설계도의 멤버필드 // 클래스도 멤버로 쓸 수 있음
	// 객체가 안 만들어져 있기 때문에 Ex10_PohamCar(String name)에서만 사용가능함
	Ex10_PohamHandle handle;			// 부품 클래스를 자신의 멤버처럼 사용
	
	public Ex10_PohamCar() {
		// TODO Auto-generated constructor stub
	}
	public Ex10_PohamCar(String name) {
		ownerName = name;
		handle = new Ex10_PohamHandle(); // class의 포함관계(has a 관계)
	}
	
	public void playcarTurnHandle(int q) { 	// q = 핸들 회전량
		if(q > 0) {										// 우회전(양수)
			turnMessageShow = handle.rightTurn(q);
		}
		if(q < 0) turnMessageShow = handle.leftTurn(q); // 좌회전(음수)
		if(q == 0) turnMessageShow = handle.straightTurn(q);
	}
}
