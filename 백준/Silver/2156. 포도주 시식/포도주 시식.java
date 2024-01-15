import java.util.Scanner;

/**
 * @author onyoo
 * @performance
 * @category
 * @note
 * 가장 많은 양의 포도주를 먹을 수 있도록하자
 * @see
 * @since 1/15/24
 **/
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[] grape = new int[N+1];
		for(int i=1;i<=N;i++){
			grape[i] = sc.nextInt();
		}

		int[] dp = new int[N+1];

		if(N == 1) {
			System.out.println(grape[1]);
			return;
		}

		dp[1] = grape[1];
		dp[2] = grape[1] + grape[2];

		//i번째 차례가 왔을때 마신 포도주의 최댓값

		for(int i=3;i<=N;i++){
			dp[i] = Math.max(dp[i-1],Math.max(dp[i-2]+grape[i],dp[i-3] +grape[i-1]+ grape[i]));
			// 0번 연속으로 마신 경우
			// 1번 연속으로 마신 경우
			// 2번 연속으로 마신 경우
		}
		System.out.println(dp[N]);
	}
}