import java.awt.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int num = sc.nextInt();

        for(int i=0;i<num;i++){
            for(int a=0;a<i;a++){
                System.out.print(" ");
            }
            for(int b=0;b<2*(num-i)-1;b++){
                System.out.print("*");
            }
            System.out.println();
        }

        for(int i=1;i<num;i++){
            for(int a=0;a<num-1-i;a++){
                System.out.print(" ");
            }
            for(int b=0;b<2*i+1;b++){
                System.out.print("*");
            }
            System.out.println();
        }

    }
}