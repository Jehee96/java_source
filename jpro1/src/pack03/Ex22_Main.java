package pack03;

public class Ex22_Main {

	public static void main(String[] args) {
		Ex22_Radio radio = new Ex22_Radio();
		radio.volOn();
		radio.volUp(5);
		radio.volDown(2);
		radio.showVol();
		radio.volOff();
		radio.showVol();
	}
}
