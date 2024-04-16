package pack03;

public class Ex20_Main {

	public static void main(String[] args) {
//		Ex20_Volume volume = new Ex20_Volume();	// x
		Ex20_Volume volume;	// o
		
		Ex20_Radio radio = new Ex20_Radio();
		Ex20_Tv tv = new Ex20_Tv();
		Ex20_HandPhone phone = new Ex20_HandPhone();
		
		radio.volumeUp(5);
		radio.volumeDown(2);
		tv.volumeUp(10);
		tv.volumeDown(7);
		phone.volumeUp(7);
		phone.volumeDown(1);
		
		System.out.println("-----------");
		volume = radio;
		volume.volumeUp(1);
		volume = tv;
		volume.volumeUp(2);
		volume = phone;
		volume.volumeUp(3);
		
		System.out.println("-----------");
		Ex20_Volume volArr[] = new Ex20_Volume[3];	// 3개짜리 배열 만듦.
		volArr[0] = radio;
		volArr[1] = tv;
		volArr[2] = phone;
		
		System.out.println("\n---- 배열 for문 ----");
		for(int a = 0; a < volArr.length; a++) {
			volArr[a].volumeDown(1);
		}
		
		System.out.println("\n---- 향상된 for문 ----");
		for(Ex20_Volume mbc:volArr) {	// 향상된 for문
			mbc.volumeDown(1);
		}
		
	}

}
