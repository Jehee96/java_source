package pack05_Io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Ex34_IoTest {

	public static void main(String[] args) throws Exception {
		// Console과 file을 통한 입력
		// 1. Console을 통한 입력
//		InputStreamReader in = new InputStreamReader(System.in);
//		BufferedReader br = new BufferedReader(in);
//		System.out.println("이름은");
//		String ir = br.readLine();
//		System.out.println("이름은 " + ir);
//		br.close();
//		in.close();
		
		// 2. Scanner를 통한 입력
//		Scanner sc = new Scanner(System.in);
//		System.out.println("이름은");
//		String ir = sc.nextLine();
//		System.out.println("몸무게는");
//		double w = sc.nextDouble();
//		System.out.println(ir + "님의 몸무게는" + w);
//		sc.close();	// Scanner를 열어줬으면 닫아라!
	
		// 파일 읽기
//		File f = new File("c:/Workstation/Acorn/good.txt");
		File f = new File("c:\\Workstation\\Acorn\\good.txt");
		// 문자 단위로 읽기
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);	// 컴퓨터와 보조기억장치 사이의 속도 차이 보완(완충장치역할)
		// System.out.println(br.readLine());		// 한 줄씩 읽음
		while(true) {
			String ss = br.readLine();
			if(ss == null) break;					// 있는 자료까지 읽고 빠져나오기
			System.out.println(ss);
		}
		br.close();	// Garbage Collector(GC)로 하여금 점유 메모리 해제 요청
		fr.close();	// 가비지 컬렉터가 돌아다니면서 알아서 안쓰는거 해제시키는데
					// close 써주면 우선순위 높아짐
		
		System.out.println("----- 전국 도서관 정보 파일 일부 읽기 -----");
		File f1 = new File("c:\\Workstation\\Acorn\\전국도서관표준데이터.csv");
		FileReader fr2 = new FileReader(f1);
		BufferedReader br2 = new BufferedReader(fr2);
		int count = 0;
		String ss = br2.readLine();
		while(true) {
			count++;
			ss = br2.readLine();
			if(ss == null || count >= 10) break;
			StringTokenizer tok = new StringTokenizer(ss, ",");
			String s1 = tok.nextToken();
			String s2 = tok.nextToken();
			String s3 = tok.nextToken();
			String s4 = tok.nextToken();
			
			System.out.println(s1 + "\t" + s2 + "\t" + s3 + "\t" + s4);
		}
		System.out.println("건수 : " + count);
	}
}
