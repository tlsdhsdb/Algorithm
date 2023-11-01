import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int T;
    static int[] money;
    static int[] month;
    static int min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for(int t=1;t<T+1;t++){
            st = new StringTokenizer(br.readLine()," ");
            money = new int[5];
            for(int i=1;i<5;i++) money[i] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine()," ");
            month = new int[13];
            for(int i=1;i<13;i++) month[i] = Integer.parseInt(st.nextToken());

            min = money[4]; // 최솟값은 1년 사용권의 값
            dfs(1,0);
            System.out.printf("#%d %d\n",t,min);
        }
    }

    static void dfs(int depth,int value){
        if(depth > 12){
            min = Math.min(value,min);
            return;
        }
        if(month[depth] == 0){
            dfs(depth+1,value);
            //이용일이 없을 경우 그냥 넘어간다
        }else{
            dfs(depth+1,value + (month[depth] * money[1]));
            dfs(depth+1,value + money[2]);
            dfs(depth+3,value + money[3]);
        }


    }
}