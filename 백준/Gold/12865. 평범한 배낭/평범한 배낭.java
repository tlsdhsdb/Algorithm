import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author onyoo
 * @performance
 * @category
 * @note
 * @see
 * @since 3/10/24
 **/
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");

		int N,K;

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		int[][] item = new int[N+1][2];

		for(int i=1;i<=N;i++){
			st = new StringTokenizer(br.readLine()," ");

			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			item[i][0] = w;
			item[i][1] = v;
		}

		int[][] dp = new int[N+1][K+1];

		for(int k=1;k<=K;k++){ // 무게
			for(int i=1;i<=N;i++){ // 몇번째 상품이 들어가는가
				dp[i][k] = dp[i-1][k];
				if( k - item[i][0] >= 0){
					dp[i][k] = Math.max(dp[i-1][k],item[i][1] + dp[i-1][k - item[i][0]]);
				}
				// i번 아이템이 k 무게의 배낭에 들어갈 수 있는 최대값
				// 이전 아이템이 들어있던 최대값 vs i번 물건의 가치 + 최대 무게 - 현재 물건의 무게의 인덱스 에서 최대값
			}
		}

		System.out.println(dp[N][K]);
	}
}