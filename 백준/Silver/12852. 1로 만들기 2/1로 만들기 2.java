import java.io.BufferedReader;
import java.util.Scanner;

/**
 * @author onyoo
 * @performance
 * @category
 * @note
 * @see
 * @since 1/20/24
 **/
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] dp = new int[N+1];
		int[] trace = new int[N+1]; // 연산을 사용했을 때 그 전의 값을 저장하는 배열

		// N을 1로 만드는 최소 연산횟수를 저장하는 배열
		dp[0] = dp[1] = 0;

		for(int i=2;i<=N;i++){
			dp[i] = dp[i-1] + 1;
			trace[i] = i-1;
			if(i%2==0 && dp[i] > dp[i/2]+1){
				dp[i] = dp[i/2] + 1;
				trace[i] = i/2;
			}
			if(i%3==0 && dp[i] > dp[i/3] + 1){
				dp[i] = dp[i/3] + 1;
				trace[i] = i/3;
			}
		}
		System.out.println(dp[N]);
		StringBuilder sb = new StringBuilder();
		while(N > 0){
			sb.append(N+" ");
			N = trace[N];
		}
		System.out.println(sb);
	}
}