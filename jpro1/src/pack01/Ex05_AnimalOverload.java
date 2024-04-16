package pack01;

// method overload : 하나의 클래스 내에 이름이 같은 메소드를 여러 개 선언
// 성립 조건: 매개변수(parameter)의 갯수, 타입, 순서가 다르면 된다. 반환형과는 관계 없다.

public class Ex05_AnimalOverload {
	private int leg = 4;
	private int age;
	private String name;					// <- setter를 이용해서 이 값을 바꿀 수 있음.
	public final static int MOUTH = 1;		// final 멤버 필드는 대문자로. final static은 바로 부를 수 있고 수정은 불가함.
	
	public Ex05_AnimalOverload() {
		// 생성자는 내용이 없는 경우 생략 가능. 그렇지만 써놓는게 정신건강에 이로움(?)
		this(10); 		// 생성자가 다른 생성자를 호출함
		System.out.println("비어 있는 생성자");
	}
	
	public Ex05_AnimalOverload(int leg) {	// 생성자 오버로딩
		// 위의 기본 값에서 다른 값을 줄 수 있다. 생성자 추가 가능
		this.leg = leg;						// this.(); //메서드 호출
	}
	
	public Ex05_AnimalOverload(String name) {
		this.name = name;
	}
	
	public Ex05_AnimalOverload(String name, int age, int leg) {
		this.name = name;
		this.age = age;
		this.leg = leg;
	}
	
//	---------------------------------------------------------------------------------------------------------------------
	
	// 멤버 출력용 메서드
	public void display() {
		System.out.println("leg: " + leg + ", age: " + age + ", name: " + name);
	}
	
	// method overloading
	public void display(int age) {		// 매개변수(parameter)의 갯수가 다름  // 똑같은 메소드가 두개 있으면 error
		this.age = age;					// 지역변수 age를 멤버필드 age에 기억 // this.age = private int age;
		System.out.println("leg: " + leg + ", age: " + age + ", name: " + name);
	}
	
	public void display(String name) {
		System.out.println("leg: " + leg + ", age: " + age + ", name: " + name);
	}
	
	public void display(String name, int age) {	// 순서1
		System.out.println("leg: " + leg + ", age: " + age + ", name: " + name);
	}
	
	public void display(int age, String name) { // 순서2
		System.out.println("leg: " + leg + ", age: " + age + ", name: " + name);
	}
	
//	public void display(int leg) {	// display(int age)와 타입과 갯수가 같아서 성립할 수 없음.
//		System.out.println("leg: " + leg + ", age: " + age + ", name: " + name);
//	}
	
//	public String display(int age) {
//		System.out.println("leg: " + leg + ", age: " + age + ", name: " + name);
//	}
}
