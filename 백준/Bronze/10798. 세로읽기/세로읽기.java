import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        String[] arr = new String[5];
        String[] tmp = new String[15];

        for(int i=0;i<5;i++){
            arr[i] = sc.nextLine();
            char[] chars = arr[i].toCharArray();
            for(int j=0;j<chars.length;j++){
                if(tmp[j] == null){
                    tmp[j] = String.valueOf(chars[j]);
                }else{
                    tmp[j] += String.valueOf(chars[j]);
                }
            }
        }

        for(int i=0;i<15;i++){
            if(tmp[i]== null){
                break;
            }
            sb.append(tmp[i]);

        }

        System.out.println(sb);


    }
}