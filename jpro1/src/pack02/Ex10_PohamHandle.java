package pack02;

public class Ex10_PohamHandle {	// 부품 클래스
	// 부품 만들기
	int quantity; 	// 핸들 회전량
	
	public Ex10_PohamHandle() {
		quantity = 0;
	}
	
	String leftTurn(int q) {
		quantity = q;
		return "좌회전";
	}
	String rightTurn(int quantity) {
		this.quantity = quantity;
		return "우회전";
	}
	String straightTurn(int quantity) {
		this.quantity = quantity;
		return "직진";
	}
}
