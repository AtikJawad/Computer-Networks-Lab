import java.io.*;
import java.net.*;

public class ClientHandler extends Thread{
    Socket s;

    ClientHandler(Socket s){
        this.s = s;
    }

    public void run(){
        try{
            DataInputStream in = new DataInputStream(s.getInputStream());
            DataOutputStream out = new DataOutputStream(s.getOutputStream());

            while(true){
                double rate = in.readDouble();
                if (rate == -1){
                    System.out.println("Client Disconnected.");
                    break;
                }
                int years = in.readInt();
                double loan_amount = in.readDouble();

                double monthly_rate = rate/1200;

                double monthly_payment = (loan_amount*monthly_rate)/ (1 - Math.pow(1+monthly_rate, -years*12));

                double total_payment = monthly_payment*12*years;

                out.writeDouble(monthly_payment);
                out.writeDouble(total_payment);

            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
