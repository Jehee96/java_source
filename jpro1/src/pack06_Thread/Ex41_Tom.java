package pack06_Thread;

public class Ex41_Tom extends Thread {
	// static은 메모리 할당 영역이 적으므로 많이 쓰지 말기
	@Override
	public void run() {
		Ex41_BankMain.bank.saveMoney(5000);	// 5천원 입금
		
		System.out.println("남편 Tom 예금 후 잔고 : " + Ex41_BankMain.bank.getMoney());
	}
}
