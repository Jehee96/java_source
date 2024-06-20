package pack.board;

import java.time.LocalDate;

import lombok.Data;

@Data
public class BoardFormBean {
	private String name, pass, mail, title, cont, bip, bdate;
	private int num, readcnt, gnum, onum, nested;
	
	public void setBdate() { // OverLoading
		LocalDate now = LocalDate.now(); // 시스템 날짜
		int year = now.getYear();		 // 년
		int month = now.getMonthValue(); // 월
		int day = now.getDayOfMonth();	 // 일
		
		this.bdate = year + "-" + month + "-" + day;
		
	}
}
