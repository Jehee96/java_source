package pack04;

import java.util.ArrayList;
import java.util.Iterator;

public class Ex28_ListTest {

	public static void main(String[] args) {
		// List류의 ArrayList로 연습 : 중복 가능, 순서O
		ArrayList<String> list = new ArrayList<String>();
		list.add("lee");
		list.add("lee");
		list.add("lee");
		list.add("park");
		list.add("hong");
//		list.remove("park"); // 특정해서 지울 수도 있지만, 순서로 지울수도 있다.↓ (11줄의 lee를 지우며 크기는 4로 변경됨.)
		list.remove(0);		 // list는 가능, set은 불가
//		list.clear();
		System.out.println("크기 : " + list.size());
		
		for(Object obj:list) {
			System.out.println(obj);
		}
		
		System.out.println();
		// Iterator(반복자) : 개발자가 컨테이너, 특히 리스트를 순회할 수 있게 해주는 객체이다.
		Iterator iter = list.iterator();
		while(iter.hasNext()) {
			String ss = (String)iter.next();
			System.out.println(ss);
		}
	}
}
