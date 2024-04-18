package pack05_Io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Ex36_DataProcess {

	public static void main(String[] args) throws Exception {
		// 이진 데이터 처리
		
		Ex36_BinaryData binaryData = new Ex36_BinaryData();
		
		// 저장
//		File f = new File("c:/Workstation/Acorn/iotest03.dat");
		File dir = new File("c:/Workstation/Acorn/");
		File file = new File(dir, "iotest03.dat");
		
		FileOutputStream fo = new FileOutputStream(file);
		BufferedOutputStream bo = new BufferedOutputStream(fo, 1024);
		ObjectOutputStream oo = new ObjectOutputStream(bo);
		oo.writeObject(binaryData);
		oo.close(); bo.close(); fo.close();
		System.out.println("저장 성공");
		
		// 읽기
		File file02 = new File("c:/Workstation/Acorn/iotest03.dat");
		FileInputStream fis = new FileInputStream(file02);
		BufferedInputStream bi = new BufferedInputStream(fis, 1024);
		ObjectInputStream oi = new ObjectInputStream(bi);
		Object obj = oi.readObject();
		Ex36_BinaryData data = (Ex36_BinaryData)obj;
		System.out.println(data.a);
		System.out.println(data.b);
		System.out.println(data.ss1);
		System.out.println(data.ss2);
		oi.close(); bi.close(); fis.close();
	}

}
