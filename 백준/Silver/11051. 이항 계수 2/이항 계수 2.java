import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        dp = new int[n+1][k+1];

        System.out.println(combination(n, k));

    }

    static int combination(int n, int r) {
        if (dp[n][r] > 0) {
            //이미 저장된 조합이라면
            return dp[n][r];
        } else if (n == r || r == 0) {
            //nCn or nC0 일 경우
            return dp[n][r] = 1;
        }
        return dp[n][r] = (combination(n-1,r-1) + combination(n-1,r)) % 10007;

    }
}