package NIIT;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

public class Server {
    private int port;
    private ServerSocket ss;
    private Socket socket;
    private BufferedReader in;
    private BufferedWriter out;
    private User user;
    String answer;
    private LinkedList<User> users = new LinkedList<User>();
    String[] arr = null;

    public Server(int port) {
        this.port = port;
    }

    private void start() {
        System.out.println("Wait a client .. ");
        try {
            ss = new ServerSocket(port);
            while (true) {
                socket = ss.accept();
                System.out.println("A client accepted .. ");

                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

                svrlogic();
            }
        } catch (IOException ex) {
            System.err.println("Can't start server!");
            ex.printStackTrace();
        }
    }

    private void svrlogic() throws IOException {
        String clientRequest;
        while ((clientRequest = in.readLine()) != null) {
            try {
                parseClientRequest(clientRequest);
                out.write(answer);
                out.flush();
            } catch (IOException e) {
                System.err.println("Can't handle client's request");
                e.printStackTrace();
            }
        }
    }

    private void parseClientRequest(String clientRequst) throws IOException {
        if (clientRequst.contains(" ")) {
            arr = clientRequst.split(" ");
        } else {
            arr[0] = clientRequst;
        }

        switch (arr[0]) {
            case "add":
                if (userIsExist() == true)
                    break;
                addUser();
                break;

            case "get":
                getUser();
                break;

            case "remove":
                removeUser();
                break;

            case "getAll":
                getAllUsers();
                break;

            default:
                answer = "The comand was entered uncorrect. Try again." + '\n';
                break;
        }
    }

    private boolean userIsExist() {
        boolean userIsExist = false;
        if (!users.isEmpty()) {
            for (User user :
                    users) {
                if (user.getName().equals(arr[1])) {
                    answer = "The user exist yet. Try again." + '\n';
                    userIsExist = true;
                }
            }
        }
        return userIsExist;
    }

    private void addUser() throws IOException {
        answer = "";
        try {
            user = new User();
            user.setName(arr[1]);
            user.setPhone(arr[2]);
            user.setEmail(arr[3]);

            users.add(user);
            answer = "The user is added successfully." + '\n';

        } catch (IndexOutOfBoundsException ex) {
            answer = "The comand was entered uncorrect. Try again." + '\n';
        }

    }

    private void getUser() throws IOException {
        answer = "";
        for (User user : users) {
            if (user.getName().equals(arr[1])) {
                answer = "The name of the user is " + user.getName() + ", the phone is " + user.getPhone() +
                        ", the e-mail is " + user.getEmail() + "." + '\n';
            }
        }
        if (answer == "") {
            answer = "The user doesn't exist." + '\n';
        }
    }

    private void removeUser() throws IOException {
        answer = "";
        for (User user : users) {
            if (user.getName().equals(arr[1])) {
                users.remove(user);
                answer = "The user is removed successfully." + '\n';
            }
        }
        if (answer == "") {
            answer = "The user doesn't exist." + '\n';
        }
    }

    private void getAllUsers() throws IOException {
        answer = "";
        int i = 0;
        for (User user : users) {
            answer += ++i + ". The name is " + user.getName() + ", the phone is  " + user.getPhone() + ", the e-mail is " + user.getEmail() + ". ";
        }
        answer += '\n';
    }

    public static void main(String[] args) throws InterruptedException {

        Thread serverThread = new Thread(() -> {
            Server server = new Server(7777);
            server.start();
        });

		serverThread.start();

//        Server server = new Server(7778);
//        server.start();
    }
}

