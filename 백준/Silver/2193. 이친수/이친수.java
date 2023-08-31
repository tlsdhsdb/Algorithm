import java.util.Scanner;

/**
 * @author 신온유
 * @git
 * @youtube
 * @performance
 * @category
 * @note
 * 테이블 정의
 * N자리수에서,끝의 자리수가 0인 이친수의 개수
 * N자리수에서,끝의 자리수가 1인 이친수의 개수
 * 0으로 끝나면, 0 혹은 1 모두가 붙을 수 있고
 * 1로 끝나면 0만 붙을 수 있다
 * 점화식
 * memo[n][0] = memo[n][0] + memo[n][1]
 * memo[n][1] = memo[n][0]
 * 초항
 * 첫번째 항만 데이터를 넣어준다.
 * 나올 수 있는 경우의 수는 1인 경우 한가지이다.
 * @see https://www.acmicpc.net/problem/2193
 * @since 2023-08-31
 **/
public class Main {
    static long[][] memo;
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        memo = new long[91][2];
        memo[1][0] = 0;
        memo[1][1] = 1;

        for(int i = 2 ; i < N + 1; i++){
            memo[i][0] = memo[i-1][0] + memo[i-1][1]; // 0으로 끝나는 경우와,1로 끝나는 경우 두가지 모두 가능하다
            memo[i][1] = memo[i-1][0]; // 0으로 끝나는 경우만 올 수 있다.
        }

        System.out.println(memo[N][0] + memo[N][1]);

    }
}