package pack;

import java.util.Scanner;

public class Test09_While {

	public static void main(String[] args) {
		// 반복문 while
		// while(조건) {참일 때 실행문들 실행..}

//		int w = 1;			// for문과 달리 초기치를 미리 준다.
//		while (w <= 5) {	// w값이 5이하일 경우
//			System.out.print("w=" + w + " ");
//			w++;			// w=1 w=2 w=3 w=4 w=5 
//		}
//		System.out.println("\nwhile 수행 후 w: " + w);	// w <= 5를 만족 못하기 때문에 1증가 하고 while문을 탈출함.
//		
//		System.out.println();
//		int count = 0;
//		while(count < 5) {	// 1 2 3 4
//			count++;  		// count+1 = 1 -> 5찍고 탈출
//			System.out.println("count : " + count);
//			
//			if(count == 3) {
//				System.out.println("쉬어가기");
//			}
//				
//			if(count == 5) {
//				System.out.println("count가 5라서 종료");
//			}
//		}

//		System.out.println();
//		w = 0;
//		while(true) { 		// 무한 루프        
//			w++;
//			if(w == 5) break;
//			if(w == 3) continue;	// w == 3이 만족하므로 다시 while문으로 복귀
//			System.out.println("w는 " + w);
//		}

//		System.out.println();
		// factorial n! 은 1부터 n까지의 모든 정수의 곱을 의미
		// ex) 5! = 5 * 4 * 3 * 2 * 1 = 120

//		Scanner scanner = new Scanner(System.in);
//		System.out.println("정수 입력 : ");
//		int number = scanner.nextInt(); // API를 가져다 적용

		int number = 5;
		// factorial 계산을 위한 초기값 설정
		int factorial = 1;
		int i = 1; // 반복을 위한 counter 변수
		while (i <= number) {
//			System.out.println(i);
			factorial *= i;
			i++;
		}
		System.out.printf("number는 %d factorial은 %d이다", number, factorial); // 프린트 포맷. 서식을 줌.

		System.out.println("\n다중 while---");
		int a = 1;
		while (a <= 3) {
			System.out.println("a:" + a + " ");
			int b = 1;
			while (b <= 4) {
				System.out.print("b:" + b + " ");
				b++;
			}
			a++;
			System.out.println();
		}

		System.out.println();
		// 키보드로 입력받은 숫자에 대해 1부터 시작해 그 숫자까지
		// 모든 수에 나누기를 시도하고 나누어 떨어지는 경우(약수) 그 수를 출력한다.
		// 0이나 음수를 입력하면 프로그램을 종료한다.

//		Scanner scanner = new Scanner(System.in);
//		while(true) {
//			System.out.println("정수 입력(0이나 음수면 종료):");
//			int num = scanner.nextInt();
//			if(num <= 0) {
//				System.out.println("프로그램 종료");
//				break; 						 		// 반복문만 break사용 가능. (if빠져나가기 x)
//			}
//			System.out.println(num + "의 약수는");
//			int divisor = 1; 						// 약수를 찾기 위해 1부터 시작
//			while(divisor <= num) {
//				if(num % divisor == 0) {	
//					System.out.println(divisor);	// 약수 출력
//				}
//				divisor++;							// 다음 수로 이동
//			}
//		}

		System.out.println();
		// do{반복 수행문...} while(조건);
		int k = 1;
		do { // 최소 1회는 수행
			System.out.println("k : " + k);
			k = k + 1;
		} while (k <= 5);

		System.out.println("exam -----------");

		System.out.println();
		// 문1) 1 ~ 100 사이의 정수 중 3의 배수이지만 2의 배수가 아닌 수를 출력하고, 합과 갯수도 출력
		int sum = 0; // 합
		int gs = 0; // 개수
		int e = 1;

		while (e <= 100) {
			if (e % 3 == 0 && e % 2 != 0) {
				System.out.print(e + " ");
				sum += e;
				gs += 1;
			}
			e++;
		}
		System.out.println("\n합계는 " + sum + ", 갯수는 " + gs);

		// 문2) -1, 3, -5, 7, -9, 11 ... 99 까지의 합 출력

		int n = 1, cnt = 1, hap = 0;
		while (n < 100) {
			if (cnt % 2 == 0) {
				hap += n;
				System.out.println("짝수 " + n);
			} else {
				int imsi = n * -1;
				hap += imsi; // 부호 면경 후 누적에 참여
				System.out.println("홀수 " + imsi);
			}
			System.out.println(n);
			n += 2; // 2씩 늘어남
			cnt += 1;
		}
		System.out.println("합은 " + hap + "입니다.");

		// 문3) 1 ~ 100 사이의 정수중에서 소수와 그 갯수를 출력
		// 소수 : 1보다 크며 1과 그 수 자체 이외의 다른 수로는 나누어 떨어지지 않는 수
		// 힌트 : 1은 소수가 아니므로 2부터 출발
		int aa = 2;
		int count2 = 0; // 소수의 갯수
		int su2 = 0;
		System.out.println("1부터 100까지의 소수 : ");
		while (aa <= 100) {
			boolean imsi = false;

			int bb = 2;
			while (bb <= aa - 1) {
				if (aa % bb == 0) {
					imsi = true;
				}
				bb++;
			}
			if (imsi == false) {
				System.out.print(aa + " ");
				count2++;
			}
			aa++;
		}
		System.out.println("\n갯수 : " + count2);

		System.out.println("2부터 그 숫자의 제곱근까지의 모든 수로 나누어 떨어지는지 확인");
		// 소수를 찾는 이유로 제곱근까지만 검사하는 것은 어떤 수의 약수는 그 수의 제곱근을 넘지 않기 때문
		int num = 2; // 1은 소수가 아니므로 2부터 출발
		int count3 = 0; // 소수의 건수
		System.out.println("1부터 100까지의 소수 : ");
		boolean isPrime = true; 		// 현재 숫자가 소수인지 판별

		while (num <= 100) {
			int divisor = 2; 			// 나누는 수는 2부터 시작
			while (divisor <= Math.sqrt(num)) {
				if (num % divisor == 0) {
					isPrime = false;
					break; 				// 나누어 떨어지지 않으면 더 이상의 검사는 필요 없음
				}
				divisor++;
			}
			if (isPrime == true) { 		// if(isPrime) 이라고 써도 된다. (같은 뜻..)
				count3++; 				// 소수의 갯수 증가
				System.out.print(num + " ");
			}
			num++;
		}
		System.out.println("\n건수 : " + count2);
	}
}