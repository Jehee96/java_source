package pack;

// JSP로 호출될 클래스 : Bean
public class Para01_Class {
	private String msg;
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public String getMsg() {
		return msg + "메세지 처리";
	}
}
