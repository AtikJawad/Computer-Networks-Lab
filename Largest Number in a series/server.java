import java.io.*;
import java.net.*;
import java.util.StringTokenizer;

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

                StringTokenizer st = new StringTokenizer(msg);

                int max = Integer.MIN_VALUE;

                while (st.hasMoreTokens()) {

                    int num = Integer.parseInt(st.nextToken());

                    if (num > max)
                        max = num;
                }

                out.writeUTF("Largest Number = " + max);
            }

            s.close();
            System.out.println("Client Disconnected");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

public class LargestServer {

    public static void main(String[] args) throws Exception {

        ServerSocket server = new ServerSocket(5000);

        System.out.println("Largest Number Server Started...");

        while (true) {

            Socket s = server.accept();

            System.out.println("Client Connected");

            ClientHandler t = new ClientHandler(s);

            t.start();
        }
    }
}
