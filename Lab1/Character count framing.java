import java.util.Scanner;

public class CharacterFraming {
    public static void main(String[] args) {

     // Sender side
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of frames to be transmitted : ");
        int n = sc.nextInt();

        String transmitted = "";

        for(int i = 0; i < n; i++){
            System.out.print("Enter Frame"+ (i+1)+ " :" );
            String frame = sc.next();

            int count = frame.length() + 1;

            transmitted = transmitted + count + frame;

        }
        System.out.println("transmitted: "+ transmitted);

        // Receiver side

        int i =0;
        int frameNo = 1;

        while(i < transmitted.length() ){

            int count = transmitted.charAt(i) - '0';
            System.out.print(count + " ");
            i++;

            String frame = transmitted.substring(i,i+ count-1 );

            System.out.println("\nFrame "+ frameNo +" : "+ frame);
            i = i + count-1;
            frameNo++;

        }
        sc.close();
}
}
