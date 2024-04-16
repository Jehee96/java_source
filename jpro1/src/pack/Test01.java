package pack;

public class Test01 {
	public static void main(String[] args) {
		System.out.println("얍");
		System.out.println("단축키를 사용하자");
		System.out.print("자바");
		System.out.print("변수");
		System.out.println("연습");
		
		
		/*		
		// 여러줄 주석 (/* )
		*/
		System.out.println("주석 연습"); // 한 줄 주석
		
		
		System.out.println("---변수 연습---");
		// 기본형 : bcbsilfd = 값을 변수가 직접 기억
		// 참조형 : 객체 = 객체의 주소를 변수가 기억
		// byte : 하나의 단위로 이루어진 이진 문자(bit)의 집합
		// bit : 정보 표현의 최소 단위
		// 8bit = 1byte를 구성하는 것이 일반적임
		
		// 숫자형 기억장소 : 변수 선언 방법 -> 타입 변수명
		byte var1; // 1byte 정수 기억 장소 -128 ~ 127
		var1 = 3;  // 3
		var1 = 5;  // 5
		System.out.println(var1); // 첫번째 var1의 값(3)을 5로 덮어씌움
		System.out.println(Byte.MAX_VALUE); // 127
		System.out.println(Byte.MIN_VALUE); // -128
		
		
		System.out.println("-------------");
		short var2 = 123;	// 2byte 정수 기억 장소 -32,768 ~ 32,767
		System.out.println(var2);
		System.out.println(Short.MAX_VALUE);
		System.out.println(Short.MIN_VALUE);
		
		
		System.out.println("-------------");
		int var3 = 123; // 4byte 정수 기억 장소
		System.out.println(var3);
		
		
		System.out.println("-------------");
		long var4 =123;	// 8byte 정수 기억 장소
		var4 = 12343223423424L; // int(약 21억)의 숫자를 넘어갈 때는 long타입이 되므로 끝에 L을 붙여 형변환을 시켜준다
		System.out.println(var4);
		
		
		System.out.println("형변환에 대해 : 자동형변환(promotion), 강제형변환(castiong)");
		// 자바에서 정수는 int로 인정 (★★★★★)
		short ss = 10;			// promotion - 10을 short type으로 자동형변환
		short ss2 = (short)10;	// casting - 10을 short type으로 강제형변환
		// ss와 ss2는 같은 뜻임
		
		// 여기서 +는 문자열 더하기
		System.out.println(ss + " " + ss2);	// 10 10 ..문자로 자동 형변환
	  //short ss3 = 50000; = type mismatch (short = -32,768 ~ 32,767)
		short ss3 = (short)50000;	// casting ..-15536
		System.out.println(ss3);
		
		int imsi = 123;
		//short ss4 = 123;
		short ss4 = (short)imsi;
		System.out.println(ss4);		
		
		
		System.out.println("-------------");
		// 자바에서 실수는 double로 인정 (기본)
		double d1 = 1.2;		// 8byte
		d1 = 12.345;
		d1 = 12345;				// promotion  정수는 실수 기억장소에 기억될 때 실수로 자동 형변환
		System.out.println(d1);	// 12345.0
		
		// float는 4byte
		float f1 = 12.3F;		 // 4byte
		float f2 = (float)12.3;	 // 강제 형변환 (casting)	
		
		// 연산시 큰 타입으로 자동변환
		double result = 4.5 + 10;
		result = 4.5 + (double)10;
		result = (int)4.5 + 10;		// 14.0		// 강제로 실수를 정수화 할 때 소숫점자리 버림 발생
		System.out.println(result);	// 14.5		// double(8byte), int(4byte) 즉 int ->double타입으로 자동형변환
		
		double dd = 5.5;
		int result2 =(int)(4.5 + 10);			// 연산자 우선순위에 의해 4.5 + 10 하고 그 결과를 정수화
		result2 =(int)4.5 + (int)dd;			// 4 + 5
		System.out.println(result2);			// 9
		
		System.out.println("지금부터는 논리형(boolean) - true or false");
		boolean bu1 = true;		// 1byte
		bu1 = false;
		System.out.println(bu1);
		
		
		System.out.println("지금부터는 문자형(char)");
		char c1 = 'a';
	// c1 = 'abc'; error
		c1 = 'k';
	// c1 = "a";   error
		c1 = '7';
		c1 = 'A';
		System.out.println(c1); 												// A	
		System.out.println(c1 + " " + (int)c1 + " " + 65 + " " + (char)65);		// A 65 65 A
		
		
		System.out.println("안녕" + 13 + "반가워");
		System.out.println("안녕" + (char)13 + "반가워");						// (char)13 아스키코드로 enter
		System.out.println("안녕" + "\n" + "반가워");
		System.out.println("안녕\n반가워");
		
		System.out.println();
		System.out.println(11 + " " + 0xb + " " + 013);		// 11 11 11 (10 16 8진수 순서)
		
		System.out.println("\n---문자열 처리------------");
		// String : 참조형 객체이지만 기본형처럼 사용할 수 있도록 자바가 배려
		String irum = "홍길동";								// 홍길동 객체의 주소를 irum이란 변수가 기억
		System.out.println(irum + "님 만세"); 				// 홍길동님 만세		
		
		System.out.println();
		// 상수 : final type 변수명 = 값(리터럴, literal)
		// 리터럴은 데이터(값) 그 자체를 뜻한다. 즉, 변수에 넣는 변하지 않는 데이터를 의미한다.
		// 한번 저장된 값은 수정 불가
		final int kbs = 9;
	 // kbs = 11;											// 수정 불가이므로 에러
		System.out.println("kbs : " + kbs); 				// kbs : 9 숫자는 문자열로 바뀜
		
		final double PI = 3.14;								// final 변수(=상수)는 대문자로 쓰기를 권장		
		System.out.println("pi : " + PI); 					// pi : 3.14
		
	}
}
