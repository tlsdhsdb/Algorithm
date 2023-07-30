import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    /*
    * key point : 반복되는 별에 주목할 것 , 한줄에 주어지는 빈 공간이 N개라는 것에 주목할것
    * 풀이 : N은 한줄에 주어지는 공백의 개수다. 공백이 다섯개가 주어지면 짝수줄은 홀수번만 홀수줄은 짝수번만 별이 나온다
    * 똑같은 모양이 두줄에 한번씩 반복되기 때문에 우리는 똑같은 문자 하나를 모아서 N번만큼 출력할 것이다.
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<N;i++){
            if(i%2 == 0){
                sb.append("*");
            }else{
                sb.append(" ");
            }
        }
        sb.append("\n");
        //첫번째 행

        for(int i=0;i<N;i++){
            if(i%2!=0){
                sb.append("*");
            }else{
                sb.append(" ");
            }
        }
        //두번째행

        sb.append("\n");

        String str = sb.toString();

        for(int i=1;i<N;i++){
            sb.append(str);
        }

        System.out.println(sb);



    }

}