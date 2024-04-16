package pack03;

public class Ex18_Main {

	public static void main(String[] args) {
		Ex18_Cow cow = new Ex18_Cow();
		System.out.println(cow.name());
		System.out.println(cow.action());
		System.out.println(cow.eat());
		cow.animalPrint();
		
		System.out.println();
		Ex18_Lion lion = new Ex18_Lion();
		System.out.println(lion.name());
		System.out.println(lion.action());
		System.out.println(lion.eat());
		lion.animalPrint();
		lion.eatOther();	// 사자 고유 메소드
		
		System.out.println();
		Ex18_Animal animal = null;
		animal = cow;
		System.out.println(animal.name());
		animal = lion;
		System.out.println(animal.name());
		
		System.out.println("\n별도의 클래스 사용해보기\n");
		Ex18_FindUtil.find(cow);
		System.out.println();
		Ex18_FindUtil.find(lion);
	}
}
