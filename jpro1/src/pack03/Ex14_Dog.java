package pack03;

public class Ex14_Dog {	// 부모클래스
	// 개과의 동물이 가져야할 기본 속성과 행위를 별도의 클래스로 작성 후 상속
	private String name = "개";
	
	
	public Ex14_Dog() {
		
	}
	
	public Ex14_Dog (String name) {
		this.name = name;		
	}
	
	public String getName() {
		return name;
	}
	
	public String callName() {
		return "종류 : " + name;
	}
	
	public void printMsg() {
		System.out.println(name + " : 지구에 산다");
	}
}
