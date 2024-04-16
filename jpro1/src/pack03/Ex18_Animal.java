package pack03;

abstract class Ex18_Animal { 		// 추상 클래스
	abstract public String name();	// 추상 메소드
	abstract public String eat();
	abstract public String action();

	public void animalPrint() {		// 일반 메소드
		System.out.println("동물 추상 클래스의 일반 메소드");
	}
}