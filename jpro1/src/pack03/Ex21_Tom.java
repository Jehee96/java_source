package pack03;

// 신입 지원자 톰
public class Ex21_Tom implements Ex21_Resume {
	private String irum, phone,juso;
	
	public Ex21_Tom() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void setIrum(String irum) {
		this.irum = irum;
	}
	@Override
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public void setJuso(String juso) {
		this.juso = juso;
	}
	@Override
	public void printData() {
//		Ex21_Resume.SIZE = "b5";	// error : final이므로
		System.out.println("용지 규격은 " + Ex21_Resume.SIZE);
		System.out.println("이름: " + irum + ", 전화: " + phone + ", 주소: " + juso);
	}
}
