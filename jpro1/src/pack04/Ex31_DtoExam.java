package pack04;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex31_DtoExam {
	private ArrayList<Ex31_StuDto> list = new ArrayList<Ex31_StuDto>();
	
	public void insertList() {
		while(true) {
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.print("이름 입력 : ");
			String name = scanner.next();
			System.out.print("국어 점수 : ");
			int kor = scanner.nextInt();
			System.out.print("영어 점수 : ");
			int eng = scanner.nextInt();
			
			Ex31_StuDto dto = new Ex31_StuDto();
			dto.setName(name);
			dto.setKor(kor);
			dto.setEng(eng);
			list.add(dto);
			
			System.out.print("계속할까요?(y/n)");
			if(scanner.next().equalsIgnoreCase("n")) break; // equalsIgnoreCase : 대소문자를 구별하지 않기 때문에 N도 n으로 입력받음.
		} catch (Exception e) {
			System.out.println("처리 중 오류 발생 : " + e);
			break;
		}
	}
}
	public void showList() {
		System.out.println("이름\t국어\t영어\t총점");
		for(Ex31_StuDto my:list) {
//			Ex31_StuDto dto = my;
			int tot = my.getKor() + my.getEng();	// 총점
			System.out.println(my.getName() + "\t" + my.getKor() + "\t" + my.getEng() + "\t" +  tot);
		}
		System.out.println("\n응시 인원 : " + list.size() + "명");
	}
	
	public static void main(String[] args) {
		Ex31_DtoExam dtoExam = new Ex31_DtoExam();
		dtoExam.insertList();	// 이름, 국어, 영어 점수
		dtoExam.showList();		// 최종 결과물 산출
	}
}
