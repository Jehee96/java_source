package pack06_Thread;

// java.lang 패키지 안에 있는 내용은 import가 생략돼있다.
public class Ex37_Thread01 extends Thread {	// Thread는 추상 클래스이다.
	public Ex37_Thread01() {

	}
	
	public Ex37_Thread01(String name) {
		super(name);
	}
	
	public void run() {
		for(int i = 1; i <= 50; i++) {
//			System.out.println(i + " ");
			System.out.println(i + " : " + super.getName() + " ");
		}
	}

	public static void main(String[] args) {
		// Thread
		// 하나의 응용 프로그램은 운영체제에 의해 process(작업단위)를 확보하고
		// 응용 프로그램의 실행은 thread가(실행단위) 담당한다.
		// 기본적으로 main thread에 의해 응용 프로그램은 실행된다.
		// thread의 갯수 만큼 실행 단위를 늘릴 수 있다.
		// 즉, multi thread에 의한 multi tasking이 가능하다.
		// 주로 네트워크 작업에서 많이 활용된다.
		// 자바에서 실행 파일 직접 실행.
		try {
			// process 단위의 실행
			// Process p1 = Runtime.getRuntime().exec("calc.exe");
			
		// Thread를 사용한 특정 메소드(run)실행(자바에서 정한 메소드임)
		// 1. Thread를 사용하지 않은 경우 : 순차적으로 실행. (스레드가 하나만 있기 때문에 th1실행 후 th2실행)
//			Ex37_Thread01 th1 = new Ex37_Thread01();
//			th1.run();
//			
//			Ex37_Thread01 th2 = new Ex37_Thread01();
//			th2.run();
		
		// 2. 사용자 정의 Thread를 사용한 경우 : 랜덤하게 실행. 사용자 정의 Thread가 끝나야 끝남. (Run메소드가 끝나야.)
//			Ex37_Thread01 th1 = new Ex37_Thread01();
			Ex37_Thread01 th1 = new Ex37_Thread01("one");
			th1.start();	// .start()가 run을 실행한다.
//			Ex37_Thread01 th2 = new Ex37_Thread01();
			Ex37_Thread01 th2 = new Ex37_Thread01("two");
			th2.start();
			
			// MAX_PRIORITY = 10;	// 최대 우선 순위
			// MIN_PRIORITY = 1;	// 최소 우선 순위
			// NORM_PRIORITY = 5;	// 보통 우선 순위
			th2.setPriority(MAX_PRIORITY); 	// 스레드의 스케쥴러에게 우선 순위를 요청함.
			
			th1.join();		// th1 스레드가 종료될 때까지 main 스레드 종료를 대기시키는 메소드
//			th2.join();
			
			th1.yield(); 	// 다른 스레드의 수행 요청이 들어오면 현재 스레드의 수행을 일시정지한다.
			
			System.out.println();
			System.out.println("프로그램 종료");
		} catch (Exception e) {
			System.out.println("err : " + e);
		}
	}
}
