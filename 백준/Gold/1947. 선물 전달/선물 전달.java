import java.util.Scanner;

/**
 * @author 신온유
 * @git
 * @youtube
 * @performance
 * @category
 * @note
 * 테이블 정의 : N명이 선물을 나누는 모든 경우의 수
 * 점화식
 * 자기자신을 제외한 나머지 사람에게 선물을 전달한다
 * N-1 명에게 선물을 전달할 수 있다.
 * D[N] = (N-1) * (D[N-2] + D[N-1])
 * 현재 N번째의 사람이 다른 사람한테 전달하는 선물의 개수를 구하려면,
 * 양방향 교환 : A -> B  B -> A ,여기에서 교환을 완료한 사람은 2명이다. 이 두명을 제외한 나머지 사람이 선물을 교환하는 개수를 구하면 된다
 * 단방향 교환 : A -> B, 그러면, B는 A를 선택하지 않을 것이기 때문에 A가 선택하는 경우의 수만을 뺀, N-1 가지를 구해야한다
 * 초깃값 설정 : 1,혼자서 선물을 주고받을 수 없다 2,두명이서는 N-1 = 1번 선물을 주고받을 수 있다
 * @see https://www.acmicpc.net/problem/1947
 * @since 2023-08-31
 **/
public class Main {

    static int N;
    static long[] memo;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        memo = new long[1000001];

        memo[1] = 0;
        memo[2] = 1L;

        for(int i = 3; i <= N; i++) {
            memo[i] = (i-1) * (memo[i-1] + memo[i-2]) % 1000000000;
        }

        System.out.println(memo[N]);

    }
}