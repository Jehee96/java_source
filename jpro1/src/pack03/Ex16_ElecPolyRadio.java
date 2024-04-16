package pack03;

public class Ex16_ElecPolyRadio extends Ex16_ElecPolyProduct {
	@Override
	public void volumeControl() {
		System.out.println("라디오 볼륨 조절 후 : " + getVolume());
	}

}
