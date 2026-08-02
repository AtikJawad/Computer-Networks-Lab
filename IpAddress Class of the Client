...............SERVER.................

import java.io.*;
import java.net.*;

class ClientHandler extends Thread {

    Socket s;

    ClientHandler(Socket s) {
        this.s = s;
    }

    public void run() {

        try {

            DataInputStream in = new DataInputStream(s.getInputStream());
            DataOutputStream out = new DataOutputStream(s.getOutputStream());

            while (true) {

                String msg = in.readUTF();

                if (msg.equalsIgnoreCase("exit")) {
                    out.writeUTF("Connection Closed");
                    break;
                }

                InetAddress ip = InetAddress.getLocalHost();

                String address = ip.getHostAddress();

                String[] parts = address.split("\\.");

                int first = Integer.parseInt(parts[0]);

                String ipClass;

                if (first >= 1 && first <= 126)
                    ipClass = "Class A";
                else if (first <= 191)
                    ipClass = "Class B";
                else if (first <= 223)
                    ipClass = "Class C";
                else if (first <= 239)
                    ipClass = "Class D";
                else
                    ipClass = "Class E";

                out.writeUTF("Server IP : " + address);
                out.writeUTF("IP Class : " + ipClass);
            }

            s.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

public class IPServer {

    public static void main(String[] args) throws Exception {

        ServerSocket server = new ServerSocket(5000);

        System.out.println("IP Server Started...");

        while (true) {

            Socket s = server.accept();

            System.out.println("Client Connected");

            ClientHandler t = new ClientHandler(s);

            t.start();
        }
    }
}

.................CLIENT..................

import java.io.*;
import java.net.*;

public class client {
    public static void main(String[] args) throws Exception{
        Socket s = new Socket("localhost",3000);

        DataInputStream in = new DataInputStream(s.getInputStream());
        DataOutputStream out = new DataOutputStream(s.getOutputStream());

        InetAddress ip = InetAddress.getLocalHost();
        String Address = ip.getHostAddress();

        out.writeUTF(Address);

        String result = in.readUTF();

        System.out.println("Class = "+ result);;

        s.close();
    }
}
