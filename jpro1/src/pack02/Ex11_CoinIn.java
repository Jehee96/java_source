package pack02;

public class Ex11_CoinIn {	// 부품 만들기
	private int coin;		// 코인 (machine에서 받은 코인 값을(this.coin = coin;) private int coin;에 할당)
	private int jandon;		// 잔돈
	
	public void setCoin(int coin) {	//coinIn.setCoin(sc.nextInt()); 스캐너가 얘의 값을 받음
		this.coin = coin;
	}
	
	public String calc(int cupCount) {
		String msg = "";
		if(coin < 200) {
			msg = "요금이 부족합니다";
		}else if(cupCount * 200 > coin) {
			msg = "요금이 부족합니다";
		}else {
			jandon = coin - (200 * cupCount);
			msg = "커피 " + cupCount + "잔과 잔돈 " + jandon + "원";
		}
		return msg;
	}
}
