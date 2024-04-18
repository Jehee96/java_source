package pack06_Thread;

public class Ex38_Thread02 implements Runnable{
	
	public Ex38_Thread02() {
		
	}
	
	public Ex38_Thread02(String name) {
		Thread tt = new Thread(this, name);
		tt.start();
	}

	@Override
	public void run() {
		for(int i = 1; i <= 50; i ++) {
			// System.out.println(i);
			System.out.println(i + " : " + Thread.currentThread().getName()); // .currentThread() : 현재 수행중인 스레드
			try {
				Thread.sleep(100);	// .sleep() : thread를 일정 시간 동안 비활성화
			} catch (Exception e) {
				
			}
		}
	}
	
	public static void main(String[] args) {
//		Ex38_Thread02 my1 = new Ex38_Thread02();
//		Ex38_Thread02 my2 = new Ex38_Thread02();
//		Thread t1 = new Thread(my1);
//		t1.start();
//		Thread t2 = new Thread(my2);
//		t2.start();
		
		new Ex38_Thread02("하나");
		new Ex38_Thread02("둘");
		System.out.println("프로그램 종료");
		
	}

}
