package pack06_Thread;

public class Ex41_Wife extends Thread {
	
	@Override
	public void run() {
		Ex41_BankMain.bank.minusMoney(2000);	// 2천원 출금
		
		System.out.println("부인 출금 후 잔고 : " + Ex41_BankMain.bank.getMoney());
	}
}
