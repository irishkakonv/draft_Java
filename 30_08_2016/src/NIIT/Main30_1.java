package NIIT;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;


class Server {
	private int port;
	private InetAddress addr;
	private ServerSocket ss;
	private Socket socket;
	private InputStream sis;
	private OutputStream sos;
	private InputStreamReader isr;
	private OutputStreamWriter osw;
	private BufferedReader br;
	private BufferedWriter bw;

	private void svrlogic() {
		try {
			String cliLine = br.readLine();
			bw.write("Server answer for " + cliLine + "\n");
			bw.flush();

		} catch (IOException ex) {
			System.err.println("Can't handle client's request");
			ex.printStackTrace();
		}
	}

	public Server(int port) {
		this.port = port;
	}

	public void start() {
		try {
			ss = new ServerSocket(port);
			while (true) {
				// Accept connection

				socket = ss.accept();
				System.out.println("client " + socket.getInetAddress());

				// input
				sis = socket.getInputStream();
				isr = new InputStreamReader(sis);
				br = new BufferedReader(isr);

				// output
				sos = socket.getOutputStream();
				osw = new OutputStreamWriter(sos);
				bw = new BufferedWriter(osw);

				// logic
				svrlogic();
			}

		} catch (IOException ex) {
			System.err.println("Can't start server!");
			ex.printStackTrace();
		}
	}

}

class Client {
	private int port;
	private InetAddress addr;
	private ServerSocket ss;
	private Socket socket;
	private InputStream sis;
	private OutputStream sos;
	private InputStreamReader isr;
	private OutputStreamWriter osw;
	private BufferedReader br;
	private BufferedWriter bw;

	public Client(String addr, int port) {
		try {
			// connect to server
			this.addr = InetAddress.getByName(addr);
			this.port = port;
			socket = new Socket(addr, port);
			// input
			sis = socket.getInputStream();
			isr = new InputStreamReader(sis);
			br = new BufferedReader(isr);

			// output
			sos = socket.getOutputStream();
			osw = new OutputStreamWriter(sos);
			bw = new BufferedWriter(osw);

			cliLogic();
		} catch (UnknownHostException ex) {
			System.err.println("illegal" + addr);
		} catch (IOException e) {
			System.err.println();
		}
	}

	private void cliLogic() {
		try {
			String request = "Hello\n";
			bw.write(request);
			bw.flush();

			String svrAnsw = br.readLine();
			System.out.println("Answer " + svrAnsw);

		} catch (Exception ex) {
			System.err.println("Can't handle client request");
			ex.printStackTrace();
		}
	}
}

public class Main30_1 {

	public static void main(String[] args) throws InterruptedException {

		Thread serverThread = new Thread(() -> {
			Server server = new Server(7777);
			server.start();
		});

		serverThread.start();

		Thread clientThread = new Thread(() -> {
			Client client = new Client("127.0.0.1", 7777);
		});

		clientThread.start();

		serverThread.join();
		clientThread.join();
	}
}
