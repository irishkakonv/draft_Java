package NIIT;

import java.net.ServerSocket;
import java.net.Socket;

class Client1{
	Socket socketCl1 = new Socket();
		
}

class Client2{
	
}
class Server{
	private int port;
	public Server(int port) {
		this.port = port;
	}
	ServerSocket ss = new ServerSocket(port);
	Socket socket = ss.accept();
	
}

public class Chat {

	public static void main(String[] args) {
		

	}

}
