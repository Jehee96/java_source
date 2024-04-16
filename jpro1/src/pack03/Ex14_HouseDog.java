package pack03;

public class Ex14_HouseDog extends Ex14_Dog {	// 자식클래스
	private String where = "집";
	
	public Ex14_HouseDog(String name) {
		super(name);	// 개지만 다른 이름을 가질 수 있다.
	}
	
	public void show() {
		System.out.println("사는 곳: " + where);
	}
	@Override
		public void printMsg() {
		System.out.println(getName() + " : " + where + "에 산다");
		}
}
