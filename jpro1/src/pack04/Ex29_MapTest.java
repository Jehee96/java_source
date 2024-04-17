package pack04;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Ex29_MapTest {

	public static void main(String[] args) {
		// Map류의 HashMap으로 연습 : 자료를 키와 값으로 저장한다. 검색이 편리하다.
		HashMap<String, String> list = new HashMap<String, String>();
		list.put("1", "lee"); // 키는 중복되면 x, 벨류는 중복 가능
		list.put("2", "kim");
		list.put("3", "kim");
		list.put("4", "han");
		list.put("5", "choi");

		System.out.println("크기 : " + list.size()); // 크기 : 5
		System.out.println(list.containsKey("2")); // false
		System.out.println(list.containsKey("7")); // false
		System.out.println(list.containsValue("han")); // true

		System.out.println();

		Set set = list.keySet();
		Iterator iter = set.iterator();
		while (iter.hasNext()) {
			String ss = (String) iter.next();
			System.out.println(ss); 		// 키 찍기
			System.out.println(list.get(ss)); // 값 출력
		}
	}
}
