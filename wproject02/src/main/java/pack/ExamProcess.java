package pack;

public class ExamProcess { // 연산용 클래스(Business Logic용)
	private ExamBean bean;
	
	public void setBean(ExamBean bean) {
		this.bean = bean;
	}
	
	public int getTot() {
		return bean.getKor() + bean.getEng() + bean.getMat();
	}
	
	public double getAvg() { // 값을 받을 때는 get을 쓸 때도 있다.
		return getTot() / 3.0;
	}
}