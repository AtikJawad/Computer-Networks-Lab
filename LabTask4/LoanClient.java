import java.io.*;
import java.net.*;
import java.util.*;

public class client{
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost",3000);

        DataInputStream in = new DataInputStream(s.getInputStream());
        DataOutputStream out = new DataOutputStream(s.getOutputStream());

        Scanner sc = new Scanner(System.in);

        while(true){
        System.out.print("\nEnter Annual interest Rate (-1 to cancel):  ");
        double rate = sc.nextDouble();

        if(rate == -1){
            System.out.println("Connection disconneted.");
            break;
        }

        System.out.print("\nNumber of years:  ");
        int years = sc.nextInt();
        System.out.print("\nLoan Amount:  ");
        double loan_amount = sc.nextDouble();

        out.writeDouble(rate);
        out.writeInt(years);
        out.writeDouble(loan_amount);

        double monthly_payment = in.readDouble();
        double total_payment = in.readDouble();

        System.out.printf("Monthly Payment: %.2f\n", monthly_payment);
        System.out.printf("Total Payment: %.2f\n", total_payment);
        }
        sc.close();
        s.close();
 }
}
