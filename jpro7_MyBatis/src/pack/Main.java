package pack;

import java.util.List;

public class Main {
	public static void main(String[] args) {
		ProcessDAO dao = ProcessDAO.getInstance();

		try {
			// MyBatis FrameWork 사용
			/*
			 * System.out.println("sangdata 추가"); DataDTO dataDTO = new DataDTO();
			 * dataDTO.setCode("100"); dataDTO.setSang("바나나"); dataDTO.setSu("5");
			 * dataDTO.setDan("5000");
			 * 
			 * dao.insData(dataDTO);
			 */
			
			
			/*
			 * System.out.println("sangdata 수정");
			 * DataDTO dataDTO = new DataDTO();
			 * dataDTO.setCode("100");
			 * dataDTO.setSang("바나나우유");
			 * dataDTO.setSu("7");
			 * 
			 * dao.upData(dataDTO);
			 */
			System.out.println("sangdata 레코드 삭제");
			boolean b = dao.delData(100);
			
			if(b) {
				System.out.println("삭제 성공");
			}else {
				System.out.println("삭제 실패");
			}

			
			
			// ----------------------------------------------------------------------------------------------
			System.out.println("\nsangdata 전체 자료 읽기");
			List<DataDTO> list = dao.selectDataAll();
			System.out.println(list.size());
			
			for(DataDTO s:list) {
				System.out.println(s.getCode() + " " + s.getSang() + " " + s.getSu() + " " + s.getDan());
			}
			
			// ----------------------------------------------------------------------------------------------
			System.out.println("\nsangdata 자료 한개 읽기");
			DataDTO dto = dao.selectPart("1");
			System.out.println(dto.getCode() + " " + dto.getSang() + " " + dto.getSu() + " " + dto.getDan());
			
		} catch (Exception e) {
			System.out.println("error : " + e.getMessage());
		}
	}
}
