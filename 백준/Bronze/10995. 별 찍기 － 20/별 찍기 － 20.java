import java.awt.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int num = sc.nextInt();

        for(int i=1;i<=num;i++){
            if(i%2==0){
                System.out.print(" ");
            }

            for(int j=1;j<num*2;j++){
                if(j%2==1){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        }

}