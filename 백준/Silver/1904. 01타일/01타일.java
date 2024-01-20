import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author onyoo
 * @performance
 * @category
 * @note
 * @see
 * @since 1/20/24
 **/
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[1000000+1];
		// 크기가 N인 2진수열을 만들 수 있는 개수
		// 00 , 1 만 사용 가능
		// N = 1 , 1
		// N = 2 , 11 00
		// N = 3 , 111,001,100
		// N = 4 , 1111,0011,1001,1100,0000

		dp[1] = 1;
		dp[2] = 2;

		for(int i=3;i<=N;i++){
			dp[i] = (dp[i-2] + dp[i-1]) % 15746;
		}

		System.out.println(dp[N]);
	}
}