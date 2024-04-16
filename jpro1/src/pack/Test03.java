package pack;

public class Test03 {

	public static void main(String[] args) {
		// 관계, 논리 연산자
		int a = 5;
		
		System.out.println(a > 3); 	// 관계(비교) 연산자
		boolean bo = a > 3;
		System.out.println(bo);		// true
		
		System.out.println(a >= 3); // 이상
		System.out.println(a <= 3); // 이하
		System.out.println(a == 3); // 같다
		System.out.println(a != 3); // 다르다
		
		System.out.println();
		int b = 10;
		System.out.println(a > 3);						// true
		System.out.println(b > 3);						// true
		System.out.println(a > 3 && b > 3);				// 논리 연산자 &&(and : 논리곱) = 두개의 값이 모두 참일때 true
		System.out.println(a > 3 && b <= 3);			// false
		
		System.out.println(a > 3 || b > 3); 			// 논리 연산자 ||(or : 논리합) = 둘중 하나라도 값이 참일때  true
		System.out.println(a > 3 || b <= 3);
		System.out.println(a < 3 || b <= 3);			// 두개의 값이 모두 거짓일때만 false
		
		System.out.println(a < 3 || b <= 1 + 1 * 1);
		boolean bb = a < 3 || b <= 1 + 1 * 1;
		System.out.println(bb);
		// 연산자 우선순위 : ()소괄호 > 산술(*, /, +, -) > 관계 > 논리 > 치환
		
		System.out.println("shift 연산--------------");
		int ii = 8, ij = 0;
		System.out.println("ii:" + Integer.toBinaryString(ii)); // ii:1000
		
		ij = ii << 1;	// << 좌측으로 1bit 이동. 남은 우측은 0으로 채움	
		System.out.println("ii:" + ii + ", " + ij);				// ii:8, 0
		
		ij = ii >> 1;	// >> 우측으로 1bit 이동. 남은 좌측은 부호(0:양수, 1:음수)와 같은 값으로 채움	
		System.out.println("ii:" + ii + ", " + ij);				// ii:8, 0
		
		ij = ii >>> 1;	// >> 우측으로 2bit 이동. 남은 좌측은 0으로 채움	
		System.out.println("ii:" + ii + ", " + ij);
		
		
		System.out.println("삼항 연산자		(조건)?참일때값:거짓일때값");
		int sbs = 8;
		int mbc = (sbs > 5)?100:10 + 20 * 2;		// 조건이 참이면 ?옆의 값, 거짓일때는 콜론옆의 값을 sbs값에다 대입
		System.out.println(mbc);
		
		System.out.println();
		int x, y, z;
		x = y = z = 5;
		System.out.println(x + " " + y + " " + z);	// 5 5 5
		
		System.out.println("논리 연산자에서 주의할 점----------");
		/*
		 * aa(); System.out.println(aa());
		 * 
		 * boolean imsi = aa(); System.out.println(imsi);
		 */
		
		boolean a1 = false, b1 = true, c1;
		c1 = a1 || b1;						// or
		System.out.println("c1 : " + c1);
		c1 = a1 && b1;						// and
		System.out.println("c1 : " + c1);
		
		System.out.println();
		boolean b2, b3;
		b1 = aa();
		System.out.println(b1);
		System.out.println(bb());
		
		System.out.println("~~~~~~~~~~~~~~~");
	 // b2 = aa() || bb();	                   aa():true or bb():false
     // b2 = bb() || aa();					   bb():false or aa():true /false, true순서는 조심. or 특성상 둘중하나 true를 가져오기때문에 앞에껀 넘어가고 뒤에값만 받아옴
	    b2 = aa() | bb();					// or : 모든 메소드 호출
		System.out.println(b2); 			// true
		
		System.out.println();
     // b3 = aa() && bb();
     // b3 = bb() && aa();
		b3 = bb() & aa();	
		System.out.println(b3);
		
		System.out.println("프로그램 종료");
	}
	
	public static boolean aa() {			// public static "boolean" = 반환 타입..? 메소드는 또다른 메소드를 부른다
		System.out.println("aa 출력");
		return true;
	}
	
	
	public static boolean bb() {			// ststic을 부르면 글자가 쓰러짐 ㅋㅋ
		System.out.println("bb 출력");
		return false;
	}
}
