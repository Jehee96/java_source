package pack01;

public class Ex02_Car {
	private int speed;
	public String irum;
	private double weight;
//	private double weight = 0.0;  위에랑 같은 뜻
	
	public Ex02_Car() {
//		irum = "홍길동"; 	// 주석처리하면 null값이 나옴.
		irum = "홍길동";
		speed = 10;
	}
	

	public void showData() { 	//void showData()라고 써도 됨
		System.out.println("이름은 " + irum + ", 속도는 " + speed);
	}
	
//	public void abcd(int s, int password)	// private 멤버값을 외부에서 접근하기 위한 메소드
	public void setSpeed(int s) { 			// speed에만 집중. setter 메소드(set + 필드이름 첫 문자만 대문자)
			this.speed = s;
		 // return;  						// 값 안돌려줘도 돼서 안써도 됨.
	}
	
	public int getSpeed() { 				// getter 메소드. 
		return speed; 						// 값을 돌려줘야 하므로 써야 함.
	}


	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) { // 지역 변수랑 멤버 변수명을 달리 해야함. 지역이 우선순위1..
		this.weight = weight;
		// this : 멤버필드 weight에 지역변수 weight값을 치환한다.
		// 현재 클래스 내에 있는 멤버를 가리킴. 후에 자기를 부른 곳으로 돌아감. (this.speed = s;)
	}
}
