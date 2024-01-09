import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author onyoo
 * @performance
 * @category
 * @note
 * @see
 * @since 1/9/24
 **/
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] score = new int[301];
		int[] stair = new int[301];

		for(int n=1;n<=N;n++) stair[n] = Integer.parseInt(br.readLine());

		// 마지막 계단까지 올라갔을때,최고값일 경우
		// 마지막 계단에 도착할 경우의 수를 계산해보자
		// N-3 -> N-1 -> N
		// N-2 -> N
		// 연속으로 세칸을 밟아서는 안되기때문에 두가지 경우의 수만 가능하다
		// 즉, 직전칸을 밟을때, 그렇지 않을때 두가지의 경우의 수가 있다
		// N = Math.max((N-3) + (N-1), (N-2)) + N번째 계단의 점수

		score[1] = stair[1]; // 첫번째 칸의 최대값은 1번계단의 점수
		score[2] = stair[1] + stair[2]; // 두번째 칸의 최대값은 1,2 (두개를 모두 밟을 경우가 최대값)
		// N - 3 이 존재하지 않는 경우

		score[3] = Math.max(score[1],stair[2]) + stair[3];
		//가장 큰 값과 합친값이 3번째 칸의 초깃값

		for(int n=4; n <= N; n++){
			score[n] = Math.max(score[n-3]+stair[n-1],score[n-2])+ stair[n];
			//가장 큰 값이 다음계단의 값이 된다
			//score[n-3] + stair[n-1] 인 이유, 중간 n-1번째의 계단을 구해야하기 때문에 
		}

		System.out.println(score[N]);

	}
}