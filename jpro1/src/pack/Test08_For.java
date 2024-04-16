package pack;

public class Test08_For {

	public static void main(String[] args) {
		// 반복문 : continue, break
		System.out.println("뭔가를 하다가...");

		for (int i = 1; i <= 10; i++) {
			System.out.println(i);
			if (i == 3)
				continue; // continue : 아래 문장을 무시해버리고 무조건 for문으로 돌아감; (반복문에 존재함)
			if (i == 5)
				break; // 5를 찍고 무조건 for문을 탈출함(밑으로!!!!)
			// if(i == 5) System.exit(0); // 얘는 아예 응용프로그램을 끝내버림

			System.out.println("금요일");
		}

		System.out.println();
		System.out.println("무한루프 ('무'조건)"); // 무한루프는 for문보다 while문에서 더 자주 쓰인다.
		int kk = 0;
		for (;;) {
			kk++;
			System.out.println("무한 반복 출력");
			if (kk == 10)
				break;
		}

		System.out.println();
		kbs: for (int i = 1; i <= 3; i++) {
			mbc: for (int j = 1; j <= 5; j++) {
				System.out.print(i + " " + j + "  ");
				if (j == 3)
					continue; // mbc label로 분기
				if (j == 3)
					continue kbs; // 해당 label로 분기
				if (j == 3)
					break kbs; // kbs로 레이블된 외부 반복문을 완전히 종료시키고, 그 반복문의 다음 코드로 진행하라는 의미.
								// 이로 인해 더 이상 외부 반복문과 내부 반복문이 실행되지 않음.

			}
			System.out.println("~~~~~");
		}
	}
}
