import java.net.*;

public class server{
    public static void main(String[] args) throws Exception {

        ServerSocket server = new ServerSocket(3000);
        System.out.println("Server Started...");

        while(true){
            Socket s = server.accept();
            System.out.println("Client Connected...");

            ClientHandler t = new ClientHandler(s);
            t.start();
        }

    }
}
