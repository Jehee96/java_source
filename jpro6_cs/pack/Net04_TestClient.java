package pack;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Net04_TestClient {

	public static void main(String[] args) {
		// 특정 컴의 접속 후 메세지 전달용
		try {
			// InetAddress ia = InetAddress.getByName("127.0.0.1"); // InetAddress를 객체로 얻음
			// System.out.println(ia);
			// Socket socket = new Socket(ia, 9999);

			Socket socket = new Socket("192.168.0.9", 9999);	// 이렇게 적어도됨. 9999번 포트를 타고 요청에 대기
			
			PrintWriter writer = new PrintWriter(
					new OutputStreamWriter(socket.getOutputStream(), 
							StandardCharsets.UTF_8), true); // 서버와 접속
			writer.println("안녕 난 jh야" + "\n");	// 서버로 자료 전송
			
			writer.close();
			socket.close();
		} catch (Exception e) {
			System.out.println("client error : " + e);
		}
	}
}
