package pack;

public class Gugudan {
	// Singleton Pattern
	private static Gugudan gugudan = new Gugudan(); // 현재 클래스의 인스턴스를 반환
	public static Gugudan getInstance() {
		return gugudan;
	}
	
	// 구구단 계산 비즈니스 로직 구현 클래스
	public Gugudan() {
		// TODO Auto-generated constructor stub
	}
	
	public int[] computeGugu(int dan) {
		int gu[] = new int[9];
		for(int i = 1; i < 10; i++) {
			gu[i - 1] = dan * i;
		}
		return gu;
	}
}
