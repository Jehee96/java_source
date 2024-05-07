package lambda;

@FunctionalInterface
interface MyInter {
	void aaa();
}

interface MyInterArg {
	void bbb(int a, int b);
}

interface MyInterArgReturn {
	int ccc(int a, int b);
}

public class My_Lambda02 {

	public static void main(String[] args) {
		// 01. 인자가 없는 추상 메소드 처리 : 전통적
		MyInter inter = new MyInter() {

			@Override
			public void aaa() { // 매개변수x
				System.out.println("익명 클래스의 메소드 오버라이딩");

			}
		};
		inter.aaa();

		// 람다식으로 표현 01)
		// 매개변수가 없으면 적지 않는다.
		// 람다 바디 내에 수행할 문장이 하나면 중괄호를 빼도 된다. 여러개면 중괄호를 빼지 말것.
		MyInter inter2 = () -> {
			System.out.println("익명 클래스의 aaa 메소드 오버라이딩 : 람다");
		};
		inter2.aaa();

		MyInter inter3 = () -> {
			int imsi = 10;
			System.out.println("람다식으로");
			System.out.println("복수의 명령문 처리");
			System.out.println("imsi : " + imsi);
		};
		inter3.aaa();

		// 02. 인자가 있는 추상 메소드 처리 : 전통적
		MyInterArg interArg = new MyInterArg() {
			@Override
			public void bbb(int a, int b) {
				System.out.println("두 수의 합은" + (a + b));

			}
		};
		interArg.bbb(3, 4);
		System.out.println("--------------------");
		
		// 람다식으로 표현 02) : 만약 아규먼트가 1개일 경우 소괄호는 빼도 된다.
		// ex) (a) -> or a -> 로 적으면 된다.
		MyInterArg interArg2 = (a, b) -> System.out.println("람다로 두 수의 합은" + (a + b));
		interArg2.bbb(3, 4);

		System.out.println("--------------------");
		// 03. 인자가 있고 반환값도 있는 추상 메소드 처리 : 전통적
		MyInterArgReturn argReturn = new MyInterArgReturn() {
			@Override
			public int ccc(int a, int b) {
				System.out.println("ccc 처리");
				return a + b;
			}
		};
		int result = argReturn.ccc(5, 6);
		System.out.println("두 수를 더한 결과 : " + result);
		
		// 람다식으로 표현 03)
		MyInterArgReturn argReturn2 = (m, n) -> (m + n);
		
		// 수행할 문장이 2개 이상일 경우 return을 걸어줘야 한다.
		MyInterArgReturn argReturn3 = (m, n) -> {
			System.out.println("ccc 수행");
			return m + n;
		};
		int result2 = argReturn3.ccc(5, 6);
		System.out.println("두 수를 더한 결과2 : " + result2);
	}
}
