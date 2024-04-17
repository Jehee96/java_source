package pack04;

import java.util.ArrayList;

public class Ex30_DtoTest {
	// DTD : 레코드 단위의 기억장소
	ArrayList<Ex30_StudentDto> list = new ArrayList<Ex30_StudentDto>();
	Ex30_StudentDto dto;		// DTO (학번, 이름, 점수를 가진)
	
	// DTO 유추하기
	public void aa() {
		String[] persons = new String[3];
		persons[0] = "홍길동";
		persons[1] = "고길동";
		persons[2] = "신길동";
		
		for(String s:persons) {
			System.out.println(s);
		}
	}
	
	public void insertList() {	// 레코드 단위(DTO)로 학생 정보 입력해서 list에 저장
		dto = new Ex30_StudentDto();
		dto.setHakbun("ks1");
		dto.setIrum("손오공");
		dto.setJumsu(90);
		list.add(dto);	// 첫번째 학생 자료 list에 등록
		
		dto = new Ex30_StudentDto();
		dto.setHakbun("ks2");
		dto.setIrum("저팔계");
		dto.setJumsu(50);
		list.add(dto);	// 두번째 학생 자료 list에 등록
		
		dto = new Ex30_StudentDto();
		dto.setHakbun("ks3");
		dto.setIrum("사오정");
		dto.setJumsu(80);
		list.add(dto);	// 세번째 학생 자료 list에 등록
	}
	
	public void showList() {	// list 컬렉션에 저장된 학생 자료를 출력
		System.out.println("학생 수는 " + list.size());	// 학생 수는 3
		System.out.println(list.get(0));				// 손오공의 주소 출력 : pack04.Ex30_StudentDto@e6ea0c6
		System.out.println(list.get(0).getIrum());		// 손오공
		
		System.out.println("------------");
		for(int i=0; i < list.size(); i++) {
//			Ex30_StudentDto sdto = new Ex30_StudentDto();
//			sdto = list.get(i);
			Ex30_StudentDto sdto = list.get(i); 		// StudentDto타입은 StudentDto타입으로만 받아야 한다.
			System.out.println(sdto.getHakbun() + " " + sdto.getIrum() + " " + sdto.getJumsu());
		}
		
		System.out.println("---- 향상된 for문 ----");	// <<더 깔끔하게 처리 가능
		// list가 가지고 있는 만큼 돈다.
		for(Ex30_StudentDto d:list) {
			System.out.println(d.getHakbun() + " " + d.getIrum() + " " + d.getJumsu());
		}
	}

	public static void main(String[] args) {
		Ex30_DtoTest dtoTest = new Ex30_DtoTest();
		dtoTest.aa();
		System.out.println();
		dtoTest.insertList();
		dtoTest.showList();
	}
}
