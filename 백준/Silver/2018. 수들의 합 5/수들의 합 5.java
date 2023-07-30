

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        //연속된 자연수의 합 구하기
        //bj 2018

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;

        int n = Integer.parseInt(br.readLine());

        int start = 1,end = 1,answer = 1,sum = 1;

        while(end < n){
            if(sum == n){
                ++answer;
                sum-=start;
                ++start;
            }else if(sum < n){
                ++end;
                sum += end;
            }else {
                sum -= start;
                ++start;
            }
        }

        System.out.println(answer);
    }

}