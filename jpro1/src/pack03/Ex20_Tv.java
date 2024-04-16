package pack03;

public class Ex20_Tv implements Ex20_Volume {
	private int volLevel;
	
	public Ex20_Tv() {	// Tv 생성자
		volLevel = 0;
	}

	@Override
	public void volumeUp(int level) {
		volLevel += level;
		System.out.println("Tv 볼륨을 올리기 " + volLevel);
		String msg = "Tv 볼륨을 높이기";
	}
	
	@Override
	public void volumeDown(int level) {
		volLevel -= level;
		String msg = "Tv 볼륨을 내리기 ";
		System.out.println(msg + volLevel);
	}
	
}
