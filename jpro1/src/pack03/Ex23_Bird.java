package pack03;

public class Ex23_Bird implements Ex23_Flyer {
	@Override
	public void fly() {
		System.out.println("날개를 휘 저으며 숲으로 날아감");
	}
	@Override
	public boolean isAnimal() {
		return true;
	}
	@Override
	public void happy() {
		
	}
}
