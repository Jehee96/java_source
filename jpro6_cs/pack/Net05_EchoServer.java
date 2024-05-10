package pack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

// Echo Server : 클라이언트의 요청에 계속 반응을 보이는 서버
public class Net05_EchoServer {
	ServerSocket ss;
	Socket socket;
	PrintWriter out;
	BufferedReader reader;

	public Net05_EchoServer() { // 생성자
		try {
			ss = new ServerSocket(8888);
			System.out.println("서버 서비스 중...");

			socket = ss.accept(); // 클라이언트 접속 대기 후 접속하면 바로 socket 객체 생성

			// 메세지 내보내기
			out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true);

			// 메세지 읽기
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));

		} catch (Exception e) {
			System.out.println("Net05_EchoServer error : " + e);
			System.exit(0);
		}
	}

	public void receiveSendData() {
		try {
			String msg = reader.readLine(); // 클라이언트의 자료를 수신
			System.out.println("수신된 메세지 : " + msg);

			out.println("서버가 보낸 메세지 : " + msg + "잘 봤어");

		} catch (Exception e) {
			System.out.println("receiveSendData error : " + e);
		} finally {
			try {
				reader.close();
				out.close();
				socket.close();
				ss.close();
			} catch (Exception e2) {
				
			}
		}
	}

	public static void main(String[] args) {
		while(true) {
			Net05_EchoServer server = new Net05_EchoServer();
			server.receiveSendData();
		}
	}
}
