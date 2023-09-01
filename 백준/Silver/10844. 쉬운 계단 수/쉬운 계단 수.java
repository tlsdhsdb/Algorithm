import java.util.Scanner;

/**
 * @author 신온유
 * @git
 * @youtube
 * @performance
 * @category
 * @note 수의 길이가 N인 계단 수가 몇개 있는가?
 * 데이터 정의하기 : 인덱스 (N) 에 N의 길이를 가지는 계단에서 H의 높이로 종료되는 계단 수를 만들 수 있는 경우의 수
 * 점화식 :
 * 만약에 숫자가 0이라면,다음숫자는 반드시 1이여야 한다.크기가 0보다 작은 자연수는 없기 때문이다
 * 이와 같이 숫자가 9라면, 다음숫자는 반드시 8이여야 한다. 크기가 9보다 한자리수 없기 때문이다
 * 나머지 숫자의 경우 앞에 숫자 or 뒤의 숫자 두가지 경우가 가능하다
 * D[i][0] = D[i-1][H+1]
 * D[i][9] = D[i-1][H-1]
 * D[i][H] = D[i-1][H+1] + D[i-1][H-1]
 * 점화식이 이해가 안간다면 이렇게 생각해보자, 1의 길이를 가지는 계단수는 모두 가짓수가 1개로 1로 초기화 된다.
 * 2의 길이를 가지는 계단수는 1의 길이를 가지는 계단수를 이어붙이는 행위이다. 이걸 반복해서 만들기 때문에
 * 이전항의 계단수를 이어붙이고 붙이고.. 같은 행동을 반복한다고 이해하면 비교적 쉽게 다가올 것이다.
 * 초항 : 한자리 수의 계단 수는 미리 구할 수 있다. 0 ~ 9 이기 때문이다. 즉, 1개씩 배분하여, 1으로 초기화 한다
 * @see https://www.acmicpc.net/problem/1562
 * @since 2023-08-31
 **/
public class Main {
    static int N;
    static int H = 10;
    static long mod = 1000000000;
    static long[][] memo;
    static long ans;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        memo = new long[N+1][H];

        for(int h = 1 ; h < H; h++){
            memo[1][h] = 1;
        }
        //초항 초기화
        //높이가 1인 계단수는 모두 한가지의 계단수 (자기자신)을 가진다.

        for(int i=2;i<N+1;i++){
            for(int h = 0 ; h < H; h++){
                if(h == 0) memo[i][h] = memo[i-1][1] % mod;
                else if (h == 9) memo[i][h] = memo[i-1][8] % mod;
                else memo[i][h] = (memo[i-1][h-1] + memo[i-1][h+1]) % mod;
            }
        }

        for(int i = 0; i < 10 ; i++) ans += memo[N][i];

        System.out.println(ans % mod);

    }
}