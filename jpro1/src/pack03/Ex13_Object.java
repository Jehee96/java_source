package pack03;

//public class Ex13_Object extends Object {
public class Ex13_Object { 		// extends 안 해도 결과가 똑같음
	
	
	@Override
	public String toString() {
		// 오버라이딩 : 부모의 본래 기능을 자식이 원하는 명령으로 재정의
		return "자바여 영원하라";
	}
	
	
	public static void main(String[] args) {
		// 최상위 수퍼 클래스 Object
		// 모든 클래스는 자동으로 Object 클래스를 상속받는다. -진리랍니다!
		Ex13_Object obj = new Ex13_Object();
		System.out.println(obj);
//		System.out.println(obj.toString());	// obj는 to String과 같다.
		
	}

}
