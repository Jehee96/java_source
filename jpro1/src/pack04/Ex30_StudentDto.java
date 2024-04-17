package pack04;

public class Ex30_StudentDto {
	// 레코드 단위 기억장소
	// Type이 다른 여러 개의 기억장소를 하나의 묶음으로 만들어 자료 전송
	private String hakbun, irum;
	private int jumsu;
	
	public Ex30_StudentDto() {

	}
	
	public Ex30_StudentDto(String hakbun, String irum, int jumst) {
		this.hakbun = hakbun;
		this.irum = irum;
		this.jumsu = jumsu;
		// 생성자를 통해 멤버필드에 값을 줄 경우에는 setter가 필요 없다.
	}

	public String getHakbun() {
		return hakbun;
	}

	public void setHakbun(String hakbun) {
		this.hakbun = hakbun;
	}

	public String getIrum() {
		return irum;
	}

	public void setIrum(String irum) {
		this.irum = irum;
	}

	public int getJumsu() {
		return jumsu;
	}

	public void setJumsu(int jumsu) {
		this.jumsu = jumsu;
	}
}
