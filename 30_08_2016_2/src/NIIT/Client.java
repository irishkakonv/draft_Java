package NIIT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	private InetAddress iAddress;
	private int port;
	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	private BufferedReader inu;

	public Client(String addr, int port) throws UnknownHostException {
        this.iAddress = InetAddress.getByName(addr);
		this.port = port;
	}
	
	private void start() {
		System.out.println("Enter the command .. ");
		System.out.println("If you need help, enter \"help\"");
		
		try {
			
			socket = new Socket(iAddress, port);

			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream(), true);
			inu = new BufferedReader(new InputStreamReader(System.in));

			cliLogic();
			
			inu.close();
			out.close();
			in.close();
			socket.close();
		} catch (UnknownHostException ex) {
			System.err.println("illegal" + iAddress);
		} catch (IOException e) {
			System.err.println("IO Exception");
		}
	}

	private static void helpAnswer() {
		System.out.println("If you want to add the user, enter \"add\"");
		System.out.println("If you want to look the user, enter \"get nameUser\"");
		System.out.println("If you want to remove the user, enter \"remove nameUser\"");
		System.out.println("If you want to look all users, enter \"getAll\"");
		System.out.println("If you want to exit, enter \"exit\"");
	}

	private void cliLogic() {
		String request;
		try {
			while ((request = inu.readLine()) != null) {
				if (request.equalsIgnoreCase( "help")) {
					helpAnswer();
					continue;
				}
				if (request.equalsIgnoreCase("exit") ) break;
				if (request.equalsIgnoreCase("add")) {
					System.out.println("Enter a name ..");
					request += " " + inu.readLine() + " " ;
					
					System.out.println("Enter a phone ..");
					request += inu.readLine() + " ";
					
					System.out.println("Enter a e-mail ..");
					request += inu.readLine();
				}
			
				out.println(request);
				out.flush();

				String svrAnsw = in.readLine();
				System.out.println("Answer: " + svrAnsw);
			
			}
		} catch (Exception ex) {
			System.err.println("Can't handle client request");
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) throws UnknownHostException {
		Thread clientThread = new Thread(() -> {
			try {
				Client client = new Client("127.0.0.1", 7777);
                client.start();
			} catch (UnknownHostException e) {
                System.err.println("sdg");
                e.printStackTrace();
			}
		});

		clientThread.start();
		
//		Client client = new Client("127.0.0.1", 7778);
//		client.start();
	}
}
