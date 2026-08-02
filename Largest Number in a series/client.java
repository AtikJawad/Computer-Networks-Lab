import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class client {
    public static void main(String[] args) throws Exception{
        Socket s = new Socket("localhost",3000);

        DataInputStream in = new DataInputStream(s.getInputStream());
        DataOutputStream out = new DataOutputStream(s.getOutputStream());

        Scanner sc = new Scanner(System.in);

        while(true){
        System.out.print("Enter Numbers using space (or quit): ");

        String nums = sc.nextLine();

        out.writeUTF(nums);

        if(nums.equalsIgnoreCase("quit")) break;

        int result = in.readInt();

        System.out.println("Result= "+ result);;

        }
        sc.close();
        s.close();
    }
}
