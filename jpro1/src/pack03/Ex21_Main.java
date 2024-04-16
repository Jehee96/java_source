package pack03;

public class Ex21_Main {

	public static void main(String[] args) {
		// 지원자가 작성한 이력서를 인사 담당자가 취합하여 이력서 출력
		System.out.println("톰 이력서 작성 후 출력");
		Ex21_Tom tom = new Ex21_Tom();
		tom.setIrum("톰");
		tom.setPhone("111-1234");
		tom.setJuso("강남구 역삼1동 123");
		tom.printData();
		
		System.out.println("제임스 이력서 작성 후 출력");
		Ex21_James james = new Ex21_James();
		james.setIrum("제임스");
		james.setPhone("111-7878");
		james.setSkill("웹프로그래밍 전문가");
		james.printData();
		
		System.out.println("\n--- 인사 담당자가 이력서 출력 ---");
		Ex21_Resume[] resBox = new Ex21_Resume[2];
		resBox[0] = tom;
		resBox[1] = james;
		
		for(Ex21_Resume r:resBox) {
			r.printData();
			System.out.println();
			
		}
		
	}

}
