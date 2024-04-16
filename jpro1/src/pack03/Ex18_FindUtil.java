package pack03;

public class Ex18_FindUtil {
	public static void find(Ex18_Animal ani) {
		ani.animalPrint();
		
		// instanceof : 객체 타입 비교 연산
		if(ani instanceof Ex18_Cow) {
			Ex18_Animal a = ani;
			System.out.println(a.name());
			System.out.println(a.eat());
		}else if (ani instanceof Ex18_Lion) {
			System.out.println(ani.name());
			System.out.println(ani.eat());
			((Ex18_Lion) ani).eatOther();
		
		}
	}
}
