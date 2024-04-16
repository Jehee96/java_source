package pack02;

public class Ex10_CarMain {

	public static void main(String[] args) {
		// 클래스의 포함관계 연습
		Ex10_PohamCar tom = new Ex10_PohamCar("미스터 톰");
		tom.playcarTurnHandle(30);
		System.out.println(tom.ownerName + "의 회전량은 " + tom.turnMessageShow + " " + tom.handle.quantity);
		// 미스터 톰의 회전량은 우회전 30
		
		tom.playcarTurnHandle(-20);
		System.out.println(tom.ownerName + "의 회전량은 " + tom.turnMessageShow + " " + tom.handle.quantity);
		// 미스터 톰의 회전량은 좌회전 -20
		
		System.out.println();
		Ex10_PohamCar james = new Ex10_PohamCar("제임스 삼촌");
		james.playcarTurnHandle(0);
		System.out.println(james.ownerName + "의 회전량은 " + james.turnMessageShow + " " + james.handle.quantity);
		// 제임스 삼촌의 회전량은 직진 0
	}

}
