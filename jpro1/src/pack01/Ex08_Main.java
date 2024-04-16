package pack01;

import java.time.LocalDate;
import java.util.Set;

public class Ex08_Main {

	public static void main(String[] args) {
		// 싱글톤 패턴 연습
		Ex08_SingletonClass s1 = new Ex08_SingletonClass();
		System.out.println(s1.kor);
		
		Ex08_SingletonClass s2 = new Ex08_SingletonClass();	// new를 만들면 인스턴스가 계속 추가된다.
		System.out.println(s2.kor);
		
		System.out.println(s1 + " " + s2);
		System.out.println(s1.hashCode() + " " + s2.hashCode());
		
		System.out.println("---------------------");
		Ex08_SingletonClass s3 = Ex08_SingletonClass.getInstance();
		System.out.println(s3.kor);
		
		Ex08_SingletonClass s4 = Ex08_SingletonClass.getInstance();
		System.out.println(s4.kor);
		
		System.out.println(s3.hashCode() + " " + s4.hashCode());
		
		System.out.println("날짜 출력 싱글톤 사용 예");
		LocalDate mynow = LocalDate.now();
		LocalDate mynow2 = LocalDate.now();								// 같은 인스턴스를 mynow, mynow2에 공유됨
		System.out.println(mynow.hashCode() + " " + mynow2.hashCode()); // 주소가 같게 나온걸 확인. 4145412 4145412
		System.out.println(mynow2.getYear()); 		// 내 컴퓨터가 가지고 있는 년도를 알려줌(윤년체크 다 하고 출력)
		
	}

}
