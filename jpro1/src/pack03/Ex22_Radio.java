package pack03;

// 인터페이스는 implements를 통해 다중상속의 효과를 볼 수 있다. (콤마(,)로 클래스 구분)
public class Ex22_Radio implements Ex22_InterVol {
	private int v = 0;
	
	@Override
	public void volUp(int v) {
		this.v += v;
	}
	@Override
	public void volDown(int v) {
		this.v -= v;
	}
	
	@Override
	public void volOff() {
		v = 0;
	}
	
	@Override
	public void volOn() {
		v = 1;
	}
	
	public void showVol() {
		System.out.println("현재 볼륨은 " + v);
	}
}
