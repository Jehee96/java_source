package exam01;

public class Salesman extends Regular{
	private int sales;	//실적
	private double commission;	//수수료율

	
	public Salesman(String irum, int nai, int salary, int sales, double commission) {
		super(irum, nai, salary);
		this.sales = sales;
		this.commission = commission;
	}
	
	
	@Override
	public double pay() {	// 급여
		return super.pay() + sales * commission;
	}
	
	@Override
	public void print() {
		display();
		System.out.println("수령액 : " + pay() + "원");
	}
	
}
