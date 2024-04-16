package pack03;

import javax.xml.parsers.FactoryConfigurationError;

public class Ex12_GajokMain {

	public static void main(String[] args) {
		// 상속 연습 : 우리 가족 소개
		Ex12_GrandFa gr1 = new Ex12_GrandFa();
		System.out.println("가보 : " + gr1.gabo);
		System.out.println("가훈 : " + gr1.gahun);
		System.out.println(gr1.say());
		gr1.eat();
		System.out.println("할아버지 나이 : " + gr1.getNai());
		
		System.out.println();
		// 매개변수가 있는 생성자 호출
		Ex12_GrandFa gr2 = new Ex12_GrandFa(77);
		System.out.println("가훈 : " + gr2.gahun);
		System.out.println("할아버지 나이 : " + gr2.getNai());
		
		System.out.println("\n----- 아버지에 대해 -----");
		Ex12_Father father = new Ex12_Father();
		System.out.println("가보 : " + father.gabo);
		System.out.println("가훈 : " + father.gahun);
		System.out.println(father.say());
		father.eat();
		System.out.println("아빠 나이 : " + father.getNai());
		System.out.println(father.getHouse());
		
		System.out.println();
		father.showData();
		
		System.out.println("\n----- 나에 대해 -----");
		Ex12_Me me = new Ex12_Me();
		System.out.println("가보 : " + me.gabo);
		System.out.println("가훈 : " + me.gahun);
		System.out.println(father.say());
		me.eat();
		System.out.println("내 나이 : " + me.getNai());
		System.out.println(me.getHouse());
		me.biking();
		}
}
