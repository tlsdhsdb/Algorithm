import java.awt.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int num = sc.nextInt();

        for(int i=1;i<=num;i++){
            for(int j=num;j>i;j--){
                System.out.print(" ");
            }
            System.out.print("*");
            if(i!=1 && i!=num){
                for(int j=1;j<i*2-2;j++){
                    System.out.print(" ");
                }
                System.out.print("*");
            }
            if(i==num){
                for(int j=1;j<i*2-1;j++){
                    System.out.print("*");
                }
            }
            System.out.println();
        }

        }

}