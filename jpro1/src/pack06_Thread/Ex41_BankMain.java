package pack06_Thread;

public class Ex41_BankMain {
	public static Ex41_Bank bank = new Ex41_Bank();
	
	public static void main(String[] args) {
		System.out.println("원금 : " + bank.getMoney());
		
		Ex41_Tom tom = new Ex41_Tom();	// run() 메소드를 가지고 있는 '객체 생성'
		Ex41_Wife wife = new Ex41_Wife();
		
		tom.start();
		wife.start();
		
	}

}
