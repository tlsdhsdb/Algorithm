import java.awt.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int num = sc.nextInt();

        for(int i=1;i<=num;i++){
            for(int j=i;j<num;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=i*2-1;j++){
                if(j%2==1){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
            //빈칸을 이미 앞에서 다 찍었기 때문에 별을 찍는 위치는 항상 1부터 시작한다
            //고로 별은 항상 홀수자리에 찍힌다

        }

        }

}