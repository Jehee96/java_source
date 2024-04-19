package pack06_Thread;

public class Ex42_BreadMain {

	public static void main(String[] args) {
		// 스레드 간 자원 공유 및 스레드 활성화/비활성화 연습
		Ex42_BreadPlate breadPlate = new Ex42_BreadPlate();
		
		Ex42_BreadMaker maker = new Ex42_BreadMaker(breadPlate);
		Ex42_BreadEater eater = new Ex42_BreadEater(breadPlate);
		
		maker.start(); // .start : JVM이 Thread의 run()메소드를 호출한다.
		eater.start();

	}

}
