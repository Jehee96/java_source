package pack03;

public class Ex20_Radio implements Ex20_Volume {
	private int volLevel;
	
	public Ex20_Radio() {	// 라디오 생성자
		volLevel = 0;
	}
	@Override
	public void volumeUp(int level) {
		volLevel += level;
		System.out.println("라디오 볼륨을 올리면 " + volLevel);
	}

	@Override
	public void volumeDown(int level) {
		volLevel -= level;
		System.out.println("라디오 볼륨을 내리면 " + volLevel);
	}
	
}
