package pack01;

public class Ex05_Main {

	public static void main(String[] args) {
		
		// 메소드 오버로딩 연습
		Ex05_AnimalOverload tiger = new Ex05_AnimalOverload();
		tiger.display();
		tiger.display(5);	// 인수(인자, argument)
		tiger.display("호랑이");
		tiger.display("호앵이", 7);
		tiger.display(3, "호돌이");
		
		System.out.println("\n--- 생성자 오버로딩 ---");
		Ex05_AnimalOverload dog = new Ex05_AnimalOverload();
		dog.display();
		
		Ex05_AnimalOverload hen = new Ex05_AnimalOverload(2);
		hen.display();
		
		Ex05_AnimalOverload wolf = new Ex05_AnimalOverload("늑대", 3, 4);
		wolf.display();
		
//		요 순서임
//		public Ex05_AnimalOverload(String name, int age, int leg) {
//			this.name = name;
//			this.age = age;
//			this.leg = leg;
//		}
	}
}
