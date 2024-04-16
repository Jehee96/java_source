package pack03;


//public class Ex22_Tv implements Ex22_InterVol {	// 추상메소드 4개
//public class Ex22_Tv implements Ex22_VolEtc {		// 추상메소드 2개

public class Ex22_Tv implements Ex22_InterVol {
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
		System.out.println("현재 볼륨은 " + v);{
	
		}
	}
}