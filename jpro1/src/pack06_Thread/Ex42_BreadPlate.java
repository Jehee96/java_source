package pack06_Thread;

public class Ex42_BreadPlate {
	private int breadCount = 0;	// 스레드 간 자원 공유 대상
	
	public Ex42_BreadPlate() {	// 생성자
		
	}
	
	// 현재 메소드를 스레드로 호출하면 해당 스레드의 처리가 진행되는 동안 락이 걸린다.(대기상태)
	public synchronized void makeBread() {
		if(breadCount >= 10) {
			try {
				System.out.println("빵 생산을 목표 초과(10개 기준)");
				wait();	// Thread를 not Runnalbe 상태로 만든다.
			} catch (Exception e) {
				
			}
			
		}
		
		breadCount++;	// 빵을 만듦.
		System.out.println("빵 생산 총 수 : " + breadCount + "개");
		notify();	// Thread를 다시 Runnalbe 상태로 복구한다.(wait 탈출)
	}
	
	public synchronized void eatBread() {
		if(breadCount < 1) {
			try {
				System.out.println("빵이 없어 기다림");
				wait();
			} catch (Exception e) {
				
			}
		}
		
		breadCount--;	// 빵을 소비. 
		System.out.println("빵 소비 후 총 수 : " + breadCount + "개");
		notify();
	}
	
}
