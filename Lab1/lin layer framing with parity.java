import java.util.Scanner;

public class parity {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string : ");
        String data = sc.next();

        int count = 0;

        for(int i=0; i < data.length() ; i++ ){
            if (data.charAt(i) == '1'){
                count++;
            }
        }

        System.out.println("1. Odd Parity\n 2.Even parity");
        System.out.print("Enter Your Choice: ");
        int choice = sc.nextInt();

        int paritybit = 0;

        if (choice == 1){
            if(count%2 == 0){
                paritybit = 1;
            }
            else{
                paritybit = 0;
            }
        }
        else if (choice == 2){
            if(count%2 == 0){
                paritybit = 0;
            }
            else{
                paritybit = 1;
            }
        }
        else{
            System.out.println("Invalid choice!");
        }
        System.out.println("The string is : "+ data + paritybit);
        sc.close();
    }
}
