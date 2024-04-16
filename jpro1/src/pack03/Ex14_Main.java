package pack03;

public class Ex14_Main {

	public static void main(String[] args) {
		// 개과의 동물들 상속으로 처리
		Ex14_Dog dog = new Ex14_Dog();
		dog.printMsg();
		System.out.println(dog.callName());
		
		System.out.println("----- HouseDog -----");
		Ex14_HouseDog hd = new Ex14_HouseDog("집개");
		hd.printMsg();
		System.out.println(hd.callName());
		
		System.out.println("----- WolfDog -----");
		Ex14_WolfeDog wd = new Ex14_WolfeDog("늑댕");
		wd.printMsg();
		System.out.println(wd.callName());
		System.out.println();
		wd.display();
		
		System.out.println("\n\n ========== 주소 치환 ==========");
		Ex14_WolfeDog bushdog = wd; // 같은 타입의 변수에게 주소를 치환(bushdog에 wd주소)
		bushdog.printMsg();
		wd.printMsg();
		
		System.out.println();
//		Ex14_HouseDog hd2 = wd;		// Type mismatch error
		Ex14_Dog dog2 = wd;			// 타입은 다르지만 부모변수에 자식변수 주소 치환 가능(부모니까 가능한건가?)
		dog2.printMsg(); 			// 위의 wd의 주소를 dog2에 치환했기 때문에 dog2도 wd와 같은 주소값을 가진다
		
		System.out.println();
		Ex14_Dog dog3 = new Ex14_Dog();	// 부모 객체
		dog3.printMsg();
//		Ex14_WolfeDog wd2 = dog3;		// 자식 객체변수에 부모변수 주소 치환은 불가능
//		wd = dog3;
	}
}
