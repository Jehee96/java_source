package pack03;

public class Ex25_AnonyMain {

	public static void main(String[] args) {
		// 내부 무명(익명) 클래스 연습
		Ex25_Saram saram = new Ex25_Saram();
		System.out.println(saram.getIr());	// 신기해
		
		System.out.println();
		Ex25_Person person = new Ex25_Person();
		Ex25_Saram saram2 = person.getSaram();
		System.out.println(saram2.getIr());
		
		System.out.println("hotfix 작업공간에서 적음");
		
		System.out.println("main 작업공간에서 추가");
		System.out.println("hotfix 작업공간에서 행 추가");
	}

}
