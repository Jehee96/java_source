package pack03;

public class Ex15_PolyMain {

	public static void main(String[] args) {
		Ex15_PolyCar car1 = new Ex15_PolyCar();		// 부모
		Ex15_PolyBus bus1 = new Ex15_PolyBus();		// 자식
		Ex15_PolyTaxi taxi1 = new Ex15_PolyTaxi();	// 자식2
		
		
		System.out.println();
		car1.displaySpeed();
		System.out.println(car1.getSpeed());
		
		System.out.println();
		bus1.displaySpeed();
		System.out.println(bus1.getSpeed());
		bus1.show();
		
		System.out.println();
		taxi1.displaySpeed();
		System.out.println(taxi1.getSpeed());
		
		System.out.println("----- 객체 주소 치환 -----");
		Ex15_PolyCar car2 = new Ex15_PolyBus();	// promotion
		car2.displaySpeed(); // 오버라이딩된 메소드(호출 가능)
		System.out.println(car2.getSpeed()); 		// car2.getSpeed()도 버스 값(50)을 찾다가 없으면 부모(car1)의 값을 찾으러 떠남
//		car2.show(); (오버라이딩x)					// 자식 고유의 메소드는 간섭(호출) 불가
		// = 오버라이딩된 메소드만 호출할 수 있다. 오버라이드하지 않은 고유 메소드는 호출할 수 없다.
		
		Ex15_PolyCar car3 = taxi1;	// promotion // Polycar는 taxi1의 값을 가지게 된다.
		System.out.println("주소 확인 :" + car3 + " " + taxi1);
		car3.displaySpeed();
		System.out.println(car3.getSpeed());
		
		
		System.out.println("\n\n==========================\n\n");
//		Ex15_PolyBus bus2 = new Ex15_PolyCar(); //안됑!!		
//		Ex15_PolyBus bus3 = car2;	// 실질적으로 car2가 갖고 있는 값은 polybus임.. (Type mismatch) .. 근데 강제로 바꿀 수 있음!
		Ex15_PolyBus bus3 = (Ex15_PolyBus)car2;		// Casting으로 성립시킬 수 있당~!!
//		// car2는 부모타입이지만 bus(자식)의 주소를 갖고 있으므로 casting에 의해 치환이 가능하다~!
		bus3.displaySpeed();
		
		System.out.println();
//		Ex15_PolyTaxi taxi2 = new Ex15_PolyCar();	// 성립 안됨
//		Ex15_PolyTaxi taxi2 = new car3;				// (부모)polycar타입이라 type mismatch
		Ex15_PolyTaxi taxi2 = (Ex15_PolyTaxi)car3;	// casting으로 성립
		taxi2.displaySpeed();
		
//		Ex15_PolyTaxi taxi3 = (Ex15_PolyTaxi)car1;	// ClassCastException(Runtime error)
		System.out.println("\n\n^^^^이것이 다형성^^^^^\n\n");
		// 오버라이딩된 메소드를 출력함으로써 메소드는 같지만 각자의 주소를 참조해서 다른 결과가 나온다.
		Ex15_PolyCar mycar;
		mycar = bus1;
		mycar.displaySpeed();
		
		mycar = taxi1;
		mycar.displaySpeed();
		
		System.out.println("\n\n\n----- PolyCar 타입의 배열 선언 -----");
		Ex15_PolyCar p[] = new Ex15_PolyCar[3];
		p[0] = car1;
		p[1] = bus1;
		p[2] = taxi1;
		
		// 향상된 for문을 통해 p를 출력
		for(Ex15_PolyCar poly:p) {
			poly.displaySpeed();
		}
	}
}
