package pack03;

public class Ex18_Lion extends Ex18_Animal{
	@Override
	public String name() {
		return "내 이름은 사자야. 어흥";
	}
	@Override
	public String eat() {
		String gogi = "생고기";
		return gogi;
	}
	@Override
	public String action() {
		return "밤에 움직임";
	}
	
	public void eatOther() {	// lion 고유 메소드
		System.out.println("가끔 물도 마심");
	}
}
