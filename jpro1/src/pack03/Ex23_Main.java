package pack03;

public class Ex23_Main {

	public static void main(String[] args) {
		System.out.println("속도 : " + Ex23_Flyer.FAST);
		
		Ex23_Bird bird = new Ex23_Bird();
		bird.fly();
		
		Ex23_AirPlane airplane = new Ex23_AirPlane();
		airplane.fly();
		
		System.out.println();
		Ex23_FlyerUtill.show(bird);		// 주소 치환중...
		System.out.println();
		Ex23_FlyerUtill.show(airplane);
		
		System.out.println();
		Ex23_Ball ball = new Ex23_Ball();
		ball.fly();
	}

}
