........................SERVER............................

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

                int choice = in.readInt();

                if (choice == 3) {
                    out.writeUTF("Connection Closed.");
                    break;
                }

                double amount = in.readDouble();

                double result = 0;

                switch (choice) {

                    case 1:
                        result = amount * 122.0;     // 1 USD = 122 BDT
                        out.writeUTF("BDT = " + result);
                        break;

                    case 2:
                        result = amount / 122.0;
                        out.writeUTF("USD = " + result);
                        break;

                    default:
                        out.writeUTF("Invalid Choice");
                }
            }

            s.close();

            System.out.println("Client Disconnected.");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

public class CurrencyServer {

    public static void main(String[] args) throws Exception {

        ServerSocket server = new ServerSocket(5000);

        System.out.println("Currency Server Started...");

        while (true) {

            Socket s = server.accept();

            System.out.println("Client Connected.");

            ClientHandler t = new ClientHandler(s);

            t.start();
        }
    }
}

........................CLIENT............................
  import java.io.*;
import java.net.*;
import java.util.Scanner;

public class client {

    public static void main(String[] args) throws Exception {

            Socket s = new Socket("localhost", 5000);

            DataInputStream in = new DataInputStream(s.getInputStream());
            DataOutputStream out = new DataOutputStream(s.getOutputStream());

            Scanner sc = new Scanner(System.in);

            while (true) {

                System.out.println("\n1. USD to BDT");
                System.out.println("2. BDT to USD");
                System.out.println("3. Exit");

                System.out.print("Enter Choice: ");
                int choice = sc.nextInt();

                out.writeInt(choice);

                if (choice == 3) {
                    System.out.println(in.readUTF());
                    break;
                }

                System.out.print("Enter Amount: ");
                double amount = sc.nextDouble();

                out.writeDouble(amount);

                String result = in.readUTF();

                System.out.println(result);
            }

            s.close();
    }
}
