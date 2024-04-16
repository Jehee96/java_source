package good;

import pack01.Ex06_Bank;

public class Ex06_Main3 {

	public static void main(String[] args) {
		// 프로젝트가 다른 곳에서 Ex06_Bank를 사용하려면
		Ex06_Bank kildong = new Ex06_Bank();
		kildong.dePosit(5000);
		kildong.withDraw(2000);
		System.out.println("kildong 예금액 : " + kildong.getMoney());
	}

}
