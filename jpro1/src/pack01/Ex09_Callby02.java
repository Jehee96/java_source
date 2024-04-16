package pack01;

public class Ex09_Callby02 {
	public void ex(int a, int b) {			// 매개변수(parameter)로 기본형을 사용 /값이 넘어옴
		int imsi = a;
		a = b;
		b = imsi;
		System.out.println("메소드 내의 a : " + a + ", b : " + b);
	}
	public void ex(Ex09_Callby01 data) {	// 매개변수(parameter)로 참조형을 사용 /객체 주소가 넘어옴
		int imsi = data.a;	// imsi에 a값을 넘김
		data.a = data.b;	// data.b에 data.a값을 넘김 (10)
		data.b = imsi;		// imsi에 data.b 값을 넘김  (20)
		System.out.println("메소드 내의 a : " + data.a + ", b : " + data.b);
	}
	public void ex(int[] ar) {
		int imsi = ar[0]; //Ex09_Callby01에 있는 int c[] = {1, 2};의 1번째 값을 줌 //1
		ar[0] = ar[1];
		ar[1] = imsi;
		System.out.println("메소드 내의 배열 요소[0]:" + ar[0] + ", [1]:" + ar[1]);
		// 메소드 내의 배열 요소[0]:2, [1]:1
		
	}
}
