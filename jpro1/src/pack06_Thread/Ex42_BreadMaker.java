package pack06_Thread;

public class Ex42_BreadMaker extends Thread {	// 빵 생산자
	private Ex42_BreadPlate plate;
	
	public Ex42_BreadMaker(Ex42_BreadPlate plate) {
		this.plate = plate;
		
	}
	
	@Override
		public void run() {
			for(int i = 0; i < 30; i++) {
				plate.makeBread();	// 빵 만들장
				
		}
	}
	
}
