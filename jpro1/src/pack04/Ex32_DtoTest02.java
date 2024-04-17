package pack04;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Ex32_DtoTest02 {
	private ArrayList<Ex32_HaksaengDto> dtos = new ArrayList<Ex32_HaksaengDto>();
	
						// 타입 맞추기!!
	public void inputData(String[] datas) {
		// System.out.println(datas[0]);
		// "김밥,100,100,100" 이런 문자열을 콤마(,)를 기준으로 분리
		/*
		 * StringTokenizer tokenizer = new StringTokenizer("kbs,mbc,sbs", ","); //
		 * (구분하고자 하는 대상, 구분할 문자?) String s1 = tokenizer.nextToken(); // 0번째 String s2 =
		 * tokenizer.nextToken(); // 1번째 String s3 = tokenizer.nextToken(); // 2번째
		 * System.out.println(s1 + " " + s2 + " " + s3);
		 */
		for(int i = 0; i <datas.length; i++) {
			StringTokenizer tok = new StringTokenizer(datas[i], ","); // StringTokenizer datas의 i번째를 ","로 구분.
			String ir = tok.nextToken();					// 김밥
			int kor = Integer.parseInt(tok.nextToken());	// 100
			int eng = Integer.parseInt(tok.nextToken());	// 100
			int mat = Integer.parseInt(tok.nextToken());	// 100
			
			Ex32_HaksaengDto dto = new Ex32_HaksaengDto();	// DTO 처리용 클래스
			dto.setName(ir);
			dto.setKor(kor);
			dto.setEng(eng);
			dto.setMat(mat);
			
			// 생성자를 통해 값을 줄 수도 있다.
			// Ex32_HaksaengDto dto = new Ex32_HaksaengDto(ir,kor, eng, mat);
			
			dtos.add(dto);	// dto를 여러개 담는 arraylist를 만듦.
		}
	}
	
	public void displayData() {
		for(Ex32_HaksaengDto hd:dtos) {
			int tot = hd.getKor() + hd.getEng() + hd.getMat();
			double avg = tot / 3.;	// .을 붙여야 실수연산.
			System.out.println(hd.getName() + ", 총점 : " + tot + ", 평균 : " + avg);
		}
	}
	
	public static void main(String[] args) {
		String[] datas = new String[3];
		datas[0] = "김밥,100,100,100";
		datas[1] = "주먹밥,80,75,88";
		datas[2] = "비빔밥,77,88,80";
	
		Ex32_DtoTest02 test02 = new Ex32_DtoTest02();
		test02.inputData(datas);
		test02.displayData();
	}
}
