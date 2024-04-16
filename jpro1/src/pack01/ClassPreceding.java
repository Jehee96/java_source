package pack01;

public class ClassPreceding {
	// 클래스 이해 전에 자원의 재활용에 대해 알아보기
	public static void main(String[] args) {
		int su1 = 6;
		int su2 = 3;
		
		System.out.println("방법1 사용");
		System.out.println("합은 " + (su1 + su2));
		System.out.println("차는 " + (su1 - su2));
		// 뭔가를 하다가..
		System.out.println();
		// 합과 차 구하기가 또 필요할 때
		System.out.println("합은 " + (su1 + su2));
		System.out.println("차는 " + (su1 - su2));
		
		System.out.println("\n방법3 사용 - ClassPreceding02의 단위 프로그램을 호출");
		// 별도의 단위 프로그램을 작성 후 필요할 때마다 호출
		ClassPreceding02 my = new ClassPreceding02();
		my.hap(su1, su2);   					// 값 호출
		my.hap(2, 5);  	 	   					// 정해진 변수(값)말고 수정해서 써도 됨
		
		
		System.out.println();
		hap(su1, su2); 							// 1번 기억장소
		cha(su1, su2);
												// 둘의 기억장소가 다르므로 변수명 같게 사용 가능. 각자의 위치에서만 호출 가능.
	}											// 2번 호출 후 다시 1번으로 되돌아감.
	public static void hap(int su1, int su2) { 	// 2번 기억장소
		System.out.println("합은 " + (su1 + su2));
	}
	public static void cha(int su1, int su2) {
		System.out.println("차는 " + (su1 - su2));
	}
}
