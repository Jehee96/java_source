package pack03;

public class Ex12_Father extends Ex12_GrandFa{	// 아빠 클래스(extends를 붙이면서 상속 완료)
//	Ex12_GrandFa fa = new Ex12_GrandFa();	    // 포함관계
	
	public String gabo = "꽃병";				// 은닉화
	private int nai = 55;
	private int house = 2;
	
	public Ex12_Father() {
//		super();	// 매개변수가 없는 '부모 생성자 호출'
//		super(55);	// 값이 있는 생성자를 찾아가려면 타입에 맞는 값을 입력
		System.out.println("아버지 생성자");
	}
	public Ex12_Father(int n) {
		System.out.println("아버지 생성자라고 해");
	}
	
	@Override
		public int getNai() {	// Method overriding(오버라이딩)
			return nai;
	}
	
	public String say() {
		return "아버지 말씀 : 에러 잡는 연습을 하거라";
	}
	
	public void eat() {
		System.out.println("뇽뇽뇽뇽");
	}
	
	final public String getHouse() {	// 아빠 고유의 메소드임
		return "집 : " + house + "채";
	}
	
	public void showData() {
		System.out.println("아버지 나이 " + nai);			// 블럭 내에서 지역변수 나이 찾다가 없으면 멤버변수로 감
		System.out.println("아버지 나이 " + this.nai);		// 처음부터 멤버변수로 감
		System.out.println("아버지 나이 " + getNai());		// 현재 클래스에 getNai를 찾음
		System.out.println("아버지 나이 " + this.getNai());
		// getNai를 주석처리하면 현재 클래스 내에 getNai가 없기 때문에 부모 클래스로 올라가 부모 클래스 나이를 받아옴
		
//		System.out.println("아버지 나이 " + super.nai());	// error
		System.out.println("할아버지 나이 " + super.getNai());	// super.getNai : 처음부터 부모클래스로 찾아감
																// this.getNai : 현재 멤버필드부터 뒤지고 없으면 부모클래스로 찾아감
		
		System.out.println();
		String gabo = "물병";
		System.out.println("가보 " + gabo); 		// 물병		// {현재 로컬 블럭 안}의 gabo
		System.out.println("가보 " + this.gabo);	// 꽃병		// 멤버필드(전역)의 gabo
		System.out.println("가보 " + super.gabo);	// 상감청자 // 부모클래스의 gabo
	}
}
