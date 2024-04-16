package pack03;

// 신입 지원자 제임스
public class Ex21_James implements Ex21_Resume {
	private String irum, phone,skill;
	
	public Ex21_James() {
	}
	
	
	@Override
	public void setIrum(String irum) {
		if(irum.equals(null)) {
			this.irum = "아무개";
		}else {
			this.irum = irum;
		}	
	}
	@Override
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public void setSkill(String s) {
		skill = s;
	}
	@Override
	public void printData() {
//		Ex21_Resume.SIZE = "b5";	// error : final이므로
		System.out.println("용지 규격은 " + Ex21_Resume.SIZE);
		System.out.println("이름: " + irum + ", 전화: " + phone + ", 보유기술: " + skill);
	}
}
