package exam01;

public class Manager extends Regular{
	private double incentive;
	
	public Manager(String irum, int nai, int salary) {
		super(irum, nai, salary);
	}
	
	@Override
	public double pay() {
		double imsi;
		if(pay() >= 2500000) {
			imsi = 0.6;
		}else if(pay() >= 2000000){
			imsi = 0.5;
		}else {
			imsi = 0.4;
		}
		
		incentive = super.pay() * imsi;
		return super.pay() + imsi;
	}
	
	@Override
	public void print() {
		display();
		System.out.println("수령액 : " + pay() + "원");
	}
	
}
