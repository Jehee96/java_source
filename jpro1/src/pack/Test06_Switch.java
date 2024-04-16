package pack;

import java.util.Scanner;

import javax.print.DocFlavor.INPUT_STREAM;

public class Test06_Switch {

	public static void main(String[] args) {
		// 조건 판단문 switch : 좀 더 정형화된 문법으로 값에 따라 여러 방향으로 분기하는 경우에 사용
		// 길게 늘어진 if문에 비해 코드가 짧고 의미 파악이 쉽다.
		
		int nai = 29;
		nai = nai / 10 * 10;			// 곱하기와 나누기는 우선순위가 같으므로 왼쪽 먼저 계산
	 // System.err.println(nai);
		
		switch (nai) {
		case 20:
			System.err.println("20대");
			break;						// 20대여도 밑으로 쭉 값이 출력되기 때문에 break문으로 값에 따른 탈출을 유도
		case 30:
			System.err.println("30대");
			System.err.println("만세");
			break;
		default:
			System.err.println("기타");
			break;						// 선택적
		}
		
		System.out.println();
		String jik = "청소부";			// 문자열이 들어올 수도 있다.
		switch (jik) {
		case "대리":
			System.err.println("대리");
			break;
		case "과장":
			System.err.println("과장 만세");
			break;
		case "부장":
			System.err.println("부장 만만세");
			System.err.println("하하하");
			break;
		default:
			System.err.println("기타 직원");
		}
		
		System.out.println("난수 출력(찍을 때마다 랜덤값 출력)");
		System.out.println(Math.random());			// 랜덤결과값(소수)
     // int time = (int)(Math.random() * 10);		// 10을 곱하여 소수점을 옮기고 int화 함으로서 소수점 밑에를 다 버린다.
		int time = (int)(Math.random() * 4) + 8;	// 8 ~ 11 사이의 정수 얻기
		System.out.println(time);
		
		switch (time) {
		case 8:
			System.out.println("학원 가자");
			break;
		case 9:
			System.out.println("인사 하자");
			System.out.println("복습 하자");
			break;
		case 10:
			System.out.println("문제 풀자");
			break;
		default:
			System.out.println("명상 시간");
		}
		
		System.out.println("-----윤년 출력-----");
		// 키보드로 년과 월을 입력받아 해당 년월의 날수 출력
		int year, month, days=28;
		String msg = "평년";
		Scanner sc = new Scanner(System.in);
		System.out.println("년도 입력: ");
		year = sc.nextInt();
		System.out.println("월 입력: ");
		month = sc.nextInt();
//		year = 2024;
//		month = 2;
		if(month < 1 || month > 12) {
			System.out.println("월은 1 ~ 12 사이만 허용"); // 입력자료 오류 검사
			System.exit(0); 							   // 프로그램의 강제 종료
		}
		// 윤년 체크해서 윤년이면 2월에 29를 준다.
		// 4의 배수이고 100의 배수가 아니거나 400의 배수
		if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
			days = 29;
			msg = "윤년";
		}
		
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			days = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			days = 30;
			break;
//		case 2:
//			break
		}
		System.out.println(year + "년 " + month + "월은 " + days + " " + msg);
	}
}



