package pack03;

import java.io.BufferedOutputStream;

public class Ex24_Main {

	public static void main(String[] args) {
		// 내부 클래스 연습용
		Ex24_Outer outer = new Ex24_Outer();
		outer.aa();
		outer.bb();
		// outer.cc();
		
		System.out.println();
		// Inner inner = new Inner();	// 내부 클래스는 독립적인 인스턴스 불가
		
		// 아래의 소스는 수행은 가능하나 현실적으로 사용하지 않는다.
		// Ex24_Outer.Inner inner = outer.new Inner();
		// inner.cc();
		
		System.out.println();
		outer.aa();
	}

}
