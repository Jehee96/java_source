package pack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

// Thread와 Socket을 사용해 간단한 웹 서버 작성
public class Net07_SimpleHttpServer {
	private ServerSocket serverSocket;
	private final int PORT;
	
	
	public Net07_SimpleHttpServer(int port) {
		this.PORT = port;
	}
	
	public void gogo() throws IOException {
		serverSocket = new ServerSocket(PORT);
		System.out.println("HTML Server Started On POST : " + PORT);
		
		while(true) {
			try {
				Socket clientSocket = serverSocket.accept();
				System.out.println("Received Request From " + clientSocket.getRemoteSocketAddress()); // 클라이언트의 정보를 볼 수 있다.
				
				ClientHandler clientHandler = new ClientHandler(clientSocket);
				new Thread(clientHandler).start(); // run메소드를 부르게 됨
				
			} catch (Exception e) {
				System.out.println("gogo error : " + e.getMessage());
				break;
			}
		}
		
		
	}
	
	// 실무 웹서버 구조 설명
	// 내부 클래스
	private static class ClientHandler implements Runnable {
		private Socket clientSocket;
		
		public ClientHandler(Socket socket) {
			clientSocket = socket;
		}
		
		@Override
		public void run() {
			try {
				BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true); // auto flush
				
				String requestLine = in.readLine();
				System.out.println("Request : " + requestLine);
				
				// HTTP 요청에 대한 응답 전송
				out.println("HTTP/1.1 200 OK");
				out.println("Content-Type : text/html;charset=UTF-8"); // text/html 대소문자 구분함
				out.println("");
				out.println("<html><head><title>연습</title></head>");
				out.println("<body>");
				out.println("<h1>홈페이지</h1>");	// 큰 글씨!
				out.println("<a href='https://www.daum.net'>다음으로</a>출발<br>");
				out.println("<a href='https://www.naver.com'>네이버로</a>가자<br>");
				out.println("</body>");
				out.println("</html>");
				
				out.close();
				in.close();
				clientSocket.close();
				
			} catch (Exception e) {
				System.out.println("error client request : " + e.getMessage());
			}
		}
	}
	
	public static void main(String[] args) {	 // localhost:8080 입력하면 만든 페이지로 이동한다!
		int port = 8080;	// 연습용 웹서버의 Default port : 8080
		
		try {
			Net07_SimpleHttpServer httpServer = new Net07_SimpleHttpServer(port);
			httpServer.gogo();
			
		} catch (Exception e) {
			System.out.println("error : " + e);
		}
	}
}
