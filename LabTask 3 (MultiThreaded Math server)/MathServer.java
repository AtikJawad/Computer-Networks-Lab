import java.io.*;
import java.net.*;
import java.util.StringTokenizer;

// Thread class to handle each client
class ClientHandler extends Thread {
    Socket s;

    public ClientHandler(Socket s) {
        this.s = s;
    }

    public void run() {
        try {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(s.getInputStream()));

            PrintWriter out = new PrintWriter(s.getOutputStream(), true);

            String msg = in.readLine();
            System.out.println("Received from client: " + msg);

            StringTokenizer st = new StringTokenizer(msg);

            int a = Integer.parseInt(st.nextToken());
            String op = st.nextToken();
            int b = Integer.parseInt(st.nextToken());

            int result = 0;

            if (op.equals("+"))
                result = a + b;
            else if (op.equals("-"))
                result = a - b;
            else if (op.equals("*"))
                result = a * b;
            else if (op.equals("/"))
                result = a / b;

            out.println("Result = " + result);

            s.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

public class MathServer {
    public static void main(String[] args) throws Exception {

        ServerSocket ss = new ServerSocket(5000);
        System.out.println("Server started...");

        while (true) {
            Socket s = ss.accept();
            System.out.println("Client connected...");

            // Create new thread for each client
            ClientHandler t = new ClientHandler(s);
            t.start();
        }
    }
}
