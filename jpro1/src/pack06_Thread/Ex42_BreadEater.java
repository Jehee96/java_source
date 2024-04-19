package pack06_Thread;

public class Ex42_BreadEater extends Thread {	// 빵 소비자
	private Ex42_BreadPlate plate;
	
	public Ex42_BreadEater(Ex42_BreadPlate plate) {
		this.plate = plate;
		
	}
	
	@Override
		public void run() {
			for(int i = 0; i < 30; i++) {
				plate.eatBread();
				
		}
	}
	
}
