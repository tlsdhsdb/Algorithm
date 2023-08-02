import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static int[][] dp = new int[31][31];
    //max 개수로 다리를 세운다는 가정함
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        for(int i=0;i<t;i++){
            st = new StringTokenizer(br.readLine()," ");

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            System.out.println(combination(m,n));
            //다리는 겹쳐질 수 없기 때문에 순서가 상관이 있다
            //조합 -> (3,1,4) (1,3,4) 중 유효하는 하나의 가짓수만 측정하기 때문에
            //겹치는것에 대한 문제가 발생하지 않음
        }
    }

    static int combination(int n,int r){
        //이미 계산된 값일 경우 해당 값을 리턴
        if(dp[n][r] > 0){
            return dp[n][r];
        }
        //원소의 개수가 조합의 갯수와 동일할 경우 (nCn or nC0)
        else if(n==r || r==0){
            return dp[n][r] = 1;
        }
        else{
            return dp[n][r] = combination(n-1,r-1) + combination(n-1,r);
        }

    }
}