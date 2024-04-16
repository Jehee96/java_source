package pack02;

import java.util.Scanner;

public class Ex11_Machine {
	private int cupCount;	// String을 제외한 다른 참조형들은 new를 해줘야함
	private Ex11_CoinIn coinIn = new Ex11_CoinIn();		//포함 관계
	
	public Ex11_Machine() {			// 생성자
		
	}

	public void showData() {
		Scanner sc = new Scanner(System.in);
		System.out.print("금액을 입력하세요");
		coinIn.setCoin(sc.nextInt());
		
		System.out.print("몇 잔을 원하세요?");
		cupCount = sc.nextInt();
//		String result = coinIn.calc(cupCount);
//		System.out.println(result);
		System.out.println(coinIn.calc(cupCount));
		sc.close();
	}
}
