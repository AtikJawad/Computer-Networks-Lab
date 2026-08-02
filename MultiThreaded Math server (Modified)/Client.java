import java.io.*;
import java.net.*;
import java.util.Scanner;

public class client {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost",5000);
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter out = new PrintWriter(s.getOutputStream(),true);

        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.print("Enter your Expression: ");
            String input = sc.nextLine();

            out.println(input);

            String result = in.readLine();

            System.out.println("Result: "+ result);

            if (input.equalsIgnoreCase("exit")){
                break;
            }
        }
    }
}
