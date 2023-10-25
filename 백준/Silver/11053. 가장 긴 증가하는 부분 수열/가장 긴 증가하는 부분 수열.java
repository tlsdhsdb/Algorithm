import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author onyoo
 * @performance
 * @category
 * @note
 * DP : 1차원 배열 , 해당 인덱스 길이의 숫자까지 왔을 때 가장 긴 수열의 길이를 저장
 * @see https://www.acmicpc.net/problem/11053
 * @since 2023-10-25
 **/
public class Main {
    static int N;
    static int[] arr,dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new int[N]; // dp table
        dp[0] = 1; // 초항

        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int answer = 0;
        for(int i=0;i<N;i++){
            int max = 0;
            for(int j=0;j<i;j++){
                if(arr[i] > arr[j]) max = Math.max(max,dp[j]);
            }
            // 현재 값 보다 큰 값을 가지면서, dp 테이블의 값이 가장 큰 (수열의 길이가 긴) 경우를 고른다
            // 값을 구하지 못할 경우 0이기 때문에 상관없다
            dp[i] = max + 1;
            answer = Math.max(dp[i],answer); // dp 테이블에서 가장 큰 값이 답이다 !
        }
        System.out.println(answer);
    }
}