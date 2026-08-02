import java.net.*;

public class server {
    public static void main(String[] args) throws Exception{
        ServerSocket server = new ServerSocket(5000);
        System.out.println("Server Started...");

        while(true){
            Socket s = server.accept();
            System.out.println("Client connected");
            ClientHandler t1 = new ClientHandler(s);
            t1.start();
        }
}
}
