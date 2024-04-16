package pack;

public class Test02 {

	public static void main(String[] args) {
	 // 응용 프로그램의 시작 메소드(method(행위))
		
	 //	int a; 	// 치환 연산자. 오른쪽의 최종 결과값을 왼쪽 기억장소에 저장
	 // a = 5;
		int a = 5;
		int b = 3;
		int c = a + b; 						// 5 + 3 = 8
		System.out.println("c는 " + c); 	// c는 8
		
		System.out.println("산술 연산자 연습");
		System.out.println(a + b);			// 8
		System.out.println(a - b);			// 2
		System.out.println(a * b);			// 15
		System.out.println(a / b);			// 1 몫
		System.out.println(a % b);			// 2 나머지
		System.out.println(a / (double)b);	// 1.6666666666666667 (실수연산. 몫과 나머지)
		
		System.out.println(3 + 4 * 5);		// 23 (*, /가 +, -보다 우선순위 높음)
		System.out.println((3 + 4) * 5);	// 35 (소괄호 내의 연산순위가 가장 높음)
		
	 // System.out.println(a / 0);			// 정수연산인 경우 에러 ArithmeticException : / by zero at pack.Test2.main(Test2.java:26)
		System.out.println(a / 0.0); 		// 실수연산인 경우 Infinity(무한대)
		System.out.println(a % 0.0);		// NaN(Not a Number) 숫자가 아니라 표현할 수 없는 상태
		
		System.out.println("문자열 더하기 연산 : +");
		String ss1 = "배가";
		String ss2 = "고파";
		String ss3 = ss1 + ss2; 
		System.out.println(ss3);					  // 배가고파
		System.out.println(ss3 + " " + 123);		  // 배가고파 123 숫자가 문자열로 자동 변환 후 연산
		System.out.println(ss3 + " " + 123 + 100);    // 배가고파 123100
		System.out.println(ss3 + " " + (123 + 100));  // 배가고파 223
		
	 // String ss4 = 5 + 6;							  // type mismatch error
		String ss4 = "5" + 6;					// 자동 형변환
		System.out.println(ss4); 					  // 56
		String ss5 = Integer.toString(5) + 6;   // 강제 형변환   int 기본형 클래스는 Integer (wrapper class)
		System.out.println(ss5); 					  // 56
		
		String ss6 = Double.toString(5) + 6;    // 강제 형변환
		System.out.println(ss6); 					  // 56
		
		System.out.println();
	 // int abc = 5 + "6";							  // type mismatch error
		int abc = 5 + Integer.parseInt("6");
		System.out.println(abc); 					  // 11
		double abc2 = 5 + Double.parseDouble("6.7");
		System.out.println(abc2);					  // 11.7
		
		System.out.println();
		// 누적
		int no = 1;
		no = no + 1;
		no += 1;
		no++;		// 후위 증감연산자
		++no;		// 전위 증감연산자
		System.out.println("no :" + no); 	        // no : 5
		
		int imsi = 5;								// imsi가 연산 전에 1증가
		int result = ++imsi + 1;
		System.out.println("imsi : " + imsi);    	// imsi : 6
		System.out.println("result : " + result);   // result : 7
		
		int imsi2 = 5;
		int result2 = imsi2++ + 1;					// imsi2가 연산 후에 1증가
		System.out.println("imsi2 : " + imsi2);		// imsi2 : 6
		System.out.println("result2 : " + result2); // result2 : 6
		// 주의 : 증감연산자는 다른 연산자와 함께 쓰지 않도록 권장
		
		// 부호 관련
		int imsi3 = 3;
		System.out.println(imsi3);
		System.out.println(-imsi3);					// 음수 변환
		System.out.println(imsi3 * -1);				// 음수 변환
	}
}
