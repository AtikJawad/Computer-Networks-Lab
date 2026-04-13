import java.io.*;
import java.net.*;
import java.util.Scanner;

public class MathClient {
    public static void main(String[] args) throws Exception {

        Socket s = new Socket("localhost", 5000);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(s.getInputStream()));
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter expression with only ( + - * /): ");
        String input = sc.nextLine();

        out.println(input);

        String result = in.readLine();
        System.out.println(result);

        s.close();
    }
}
