package pack;

public class Test11_Array {

	public static void main(String[] args) {
		// main 메소드의 매개변수(배열) 확인
		if(args.length == 0) {						// args의 값이 0이면 실행
			System.out.println("실행 시 값을 주세요");
			System.exit(0);
		}
		
		System.out.println(args.length);
		for(int i = 0; i < args.length; i++) { 		// args.length의 값만큼 실행
			System.out.println(args[i]);			// args.length의 값을 출력
		}
		
		System.out.println();
		for(String imsi:args) {
			System.out.println(imsi);
		}
		System.out.println("응용 프로그램 종료");	// 프로그램 종료
	}
}
