import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = 9;
        int[][] arr = new int[N][N];

        int max = Integer.MIN_VALUE;

        int max_c = Integer.MIN_VALUE;
        int max_r = Integer.MIN_VALUE;

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                arr[i][j] = sc.nextInt();
                if(arr[i][j] > max){
                    max = arr[i][j];
                    max_c = i + 1;
                    max_r = j + 1;
                }
            }
        }
        System.out.println(max);
        System.out.println(max_c + " "+max_r);

    }
}