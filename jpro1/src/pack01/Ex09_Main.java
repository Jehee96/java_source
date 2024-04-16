package pack01;

public class Ex09_Main {

	public static void main(String[] args) {
		// 메소드 호출 시 매개변수를 통한 자료 전달 (타입이 기본형, 참조형) = (값이 전달되느냐, 주소가 전달되느냐)
		Ex09_Callby01 myData = new Ex09_Callby01();
		Ex09_Callby02 myMethod = new Ex09_Callby02();
		
		System.out.println("원래 a:" + myData.a + ", b:" + myData.b);	// 원래 a:10, b:20
		
		myMethod.ex(myData.a, myData.b); // 인수로 기본형 전달(값이 전달)
		// = System.out.println("메소드 내의 a : " + data.a + ", b : " + data.b); // 메소드 내의 a : 20, b : 10
		
		System.out.println("1. 수행 후 a: " + myData.a + ", b:" + myData.b);	  // 원래의 값 호출
		
		System.out.println();
		myMethod.ex(myData);	// Ex09_Callby01 객체 타입의 주소를 전달
		System.out.println("2. 수행 후 a: " + myData.a + ", b:" + myData.b);
		
		System.out.println();
		//배열의 대표명은 주소를 가지고 있다
		System.out.println("배열의 대표명 c : " + myData.c);		// 배열의 대표명 c : [I@4ac68d3e
		
//		int c[] = {1, 2};
//		int kbs[] = myData.c;	// myData.c의 주소를 kbs에게 주소를 치환했으므로 둘의 주소값은 같다.
//		System.out.println(myData.c[0]);	// 1
//		System.out.println(kbs[0]);			// 1
		myMethod.ex(myData.c);
		System.out.println("3. 배열 수행 후 a: " + myData.c[0] + ", b:" + myData.c[1]);
		// 3. 배열 수행 후 a: 2, b:1
	}
}
