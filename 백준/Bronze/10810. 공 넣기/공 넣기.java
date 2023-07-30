import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        * 바구니 : 1~N개
        * 바구니에는 공을 한개까지만 넣을 수 있음
        * 공을 넣을 바구니 범위를 정하고 정한 바구니에 모두 같은 번호가 적혀있는 공을 넣음
        * 바구니에 공이 이미 있는 경우에는 들어있는 공을 빼고 새로 공을 넣는다.
        * */
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] basket = new int[n+1];

        for(int x=0;x<m;x++){
            int i = sc.nextInt();
            int j = sc.nextInt();
            int k = sc.nextInt();

            // i번 바구니부터 j번 바구니까지 k번 적힌 공을 넣는다

            for(int l=i;l<=j;l++){
                basket[l] = k;
            }
        }
    
        for(int num: Arrays.copyOfRange(basket,1,n+1)){
            System.out.print(num + " ");
        }
        

    }

}