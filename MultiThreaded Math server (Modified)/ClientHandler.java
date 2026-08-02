import java.net.*;
import java.io.*;
import java.util.*;

public class ClientHandler extends Thread{
    Socket s;

    ClientHandler(Socket s){
        this.s = s;
    }
    public void run(){
        try{
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter out = new PrintWriter(s.getOutputStream(),true);

            String msg;

            while( (msg=in.readLine()) != null){

                if(msg.equalsIgnoreCase("exit")){
                    out.println("client disconnected.");
                    break;
                }
                System.out.println("Client said: "+ msg);

                StringTokenizer st = new StringTokenizer(msg);

                int a = Integer.parseInt(st.nextToken());
                String op = st.nextToken();
                int b = Integer.parseInt(st.nextToken());

                int result = 0;
                if(op.equals("+")){
                    result = a+b;
                }
                else if (op.equals("-")){
                    result = a-b;
                }
                else if (op.equals("*")){
                    result = a*b;
                }
                else if (op.equals("/")){
                    if (b == 0){
                        out.println("Cannot DIVIDE by ZERO!!");
                        continue;
                    }
                    result = a/b;
                }
                else {
                    out.println("Invalid operator!");
                    continue;
                }

                out.println(result);

            }
            s.close();

        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
