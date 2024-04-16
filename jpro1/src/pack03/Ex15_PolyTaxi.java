package pack03;

public class Ex15_PolyTaxi extends Ex15_PolyCar {
	private int passenger = 2;
	
	public Ex15_PolyTaxi() {
		// super();
		System.out.println("난 택시라고 해");
	}
	
	@Override
	public void displaySpeed() {
		System.out.println("택시 승객은  " + passenger + "명");
	}
}
