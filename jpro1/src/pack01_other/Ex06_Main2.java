package pack01_other;

import pack01.Ex06_Bank;	// 다른 패키지에 있는 클래스 읽기
//import pack01.*;			// pack01의 모든 클래스 읽기 : 비권장(메모리 낭비 심함)

public class Ex06_Main2 {
	public static void main(String[] args) {
		// 프로젝트는 같으나 다른 패키지에 있는 Ex06_Bank 클래스를 사용
		Ex06_Bank kildong = new Ex06_Bank();
//		System.out.println("a: " + kildong.a);	// default = 패키지가 달라지면 불가능. error
		System.err.println("a: " + kildong.b);	// public = 패키지가 달라져도 public이면 가능
	}

}
