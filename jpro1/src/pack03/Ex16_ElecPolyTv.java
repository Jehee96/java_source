package pack03;

public class Ex16_ElecPolyTv extends Ex16_ElecPolyProduct {
	@Override
	public void volumeControl() {
		int sosiSize = getVolume();
		System.out.println("Tv 소리 변경 후 : " + sosiSize);
	}
	
	public void tvShow() {
		System.out.println("tv의 고유 메소드");
	}
	
}
