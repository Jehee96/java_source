package pack;

import java.util.Scanner;

import javax.swing.plaf.FontUIResource;

import org.w3c.dom.ls.LSOutput;

public class Test07_For {

	public static void main(String[] args) {
		// 반복문 for
		// for(초기화식;조건;증감식) {반복 처리 대상}

		int a;
//      for(int a = 1; a <= 5; a = a + 1) {		 		// a = 1로 초기화. 조건만큼(5이하까지) 반복. a + 1씩 증감
//		for(a = 1; a <= 5; a = a + 1) {
//		for(a = 1; a <= 5; a += 1) {

		int sum = 0; // 누적 기억장소

		for (a = 1; a <= 7; a++) {
			System.out.println("a : " + a); // 참이면 실행
			// a = 4; // for 안의 값에 손을 대면 안된다.
			sum += a;
		}
		System.out.println("반복문 수행 후 a : " + a); // 거짓이면 실행
		System.out.println("합은 " + sum);

		for (int i = 65; i <= 90; i++) {
			System.out.print((char) i + " ");
		}
		System.out.println();
		for (int i = 'A'; i <= 'Z'; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
		for (int i = 10; i > 1; i -= 2) {
			System.out.print(i + " ");
		}

		System.out.println();
		for (int ytn = 0, tvn = 5; ytn <= 5; ytn++, tvn++) {
			System.out.print(ytn + "," + tvn + ":");
		}

		System.out.println();
		System.out.println("===**참고용**===");
		int aa = 1; // 여기에 값을 쓰면
		for (; aa <= 5; aa++) { // 초기화식에 세미콜론만 냅둬도 됨.
			System.out.print(aa + " ");
		}

		System.out.println("\n\n===**다중 for**===");
		for (int m = 1; m <= 3; m++) {
			System.out.println("m =" + m);
			for (int n = 1; n <= 4; n++) {
				System.out.print("n :" + n + " ");
			}
			System.out.println();
		}

		System.out.println();
		for (char i = 65; i <= 90; i++) {
			System.out.print(i + " : ");
			for (char j = i; j <= 'Z'; j++) { // char i = 65(A) = j >> A ~ Z 도장찍기
				System.out.print(j);
			}
			System.out.println();
		}

		System.out.println();
		// 구구단 3단 출력
		for (int count = 1; count < 10; count++) {
			System.out.println("3 * " + count + " = " + (3 * count));
		}

		// 문제 1 : 키보드로 숫자를 받아 구구단 출력
		// 예시) 몇 단? 3
		// 3*1=3 3*2=6...
//		System.out.println("\n\n\n\n\n\n--- 1 ---");
//		Scanner sc = new Scanner(System.in);
//		System.out.print("몇 단? ");
//		int dan = sc.nextInt();
//			for(int count = 1; count < 10; count+=1) {
//				System.out.println(dan + "*" + count + " = " + (dan * count));
//			}
			
			
//		문제 2 : 1 ~ 100 사이의 정수 중 3의 배수이면서 5의 배수의 갯수와 그 합을 출력
//		System.out.println("--- 2 ---");
//        int gaesu = 0;
//        int hap = 0;
//        for(int su=1; su <= 100; su++){
//            if(su % 3 == 0 && su % 5 == 0) {    // 3의 배수이고 동시에 5의 배수라는 뜻(동시 만족)
//                gaesu += 1;
//                hap += su;
//			}
//		}
//        System.out.println("갯수는 " + gaesu + ",합은 " + hap);
//		
//		 문제 3 : 2 ~ 9단까지 출력 (다중for)
//		 2*1=2 2*2=4...
//		 ...
//		 9*1=9 9*2=18...

		System.out.println("--- 3 ---");
		for (int d1 = 2; d1 <= 9; d1++) {
			System.out.println(d1);
			{
				for (int d2 = 1; d2 <= 9; d2++)
					System.out.print(d1 + " *" + d2 + " = " + (d1 * d2) + " ");

			}
		}
	}
}
