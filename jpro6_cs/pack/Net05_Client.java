package pack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Net05_Client {
	Socket socket;
	PrintWriter out;
	BufferedReader reader;

	public Net05_Client() {
		try {
			socket = new Socket("192.168.0.9", 8888);

			// 메세지 내보내기
			out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true);

			// 메세지 읽기
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));

		} catch (Exception e) {
			System.out.println("Net05_Client error : " + e);
		}
	}

	public void sendReceiveData() {
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println("전송 메세지 입력 : ");
			String data = scanner.nextLine();
			out.println(data); // 서버로 자료 전송
			
			String re_data = reader.readLine(); // 서버가 보낸 자료 수신
			System.out.println("수신된 자료는 : " + re_data);
		} catch (Exception e) {
			System.out.println("sendReceiveData error : " + e);
		} finally {
			try {
				reader.close();
				out.close();
				socket.close();
			} catch (Exception e2) {
				
			}
		}
	}
	
	public static void main(String[] args) {
		Net05_Client client = new Net05_Client();
		client.sendReceiveData();
	}

}
