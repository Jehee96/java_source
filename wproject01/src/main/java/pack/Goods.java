package pack;

//한 개 상품이 이름과 가격으로 구성됨. 이를 하나의 객체로 만들기 위한 DTO(VO) Class (롬복 라이브러리로도 처리 가능)
public class Goods {
	private String name;
	private int price;
	
	public Goods(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	
	public int getPrice() {
		return price;
	}
}