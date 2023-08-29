import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 신온유
 * @git
 * @youtube
 * @performance
 * @category
 * @note
 * 상태 공간 트리 -> 중복 연산(계산) 발견
 * 점화식
 * @see
 * @since 2023-08-29
 **/
public class Main {
    static int N;
    static int[] memo;
    static int[] count;
    static int cnt;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        memo = new int [N+1];
        count = new int [N+1];
        Arrays.fill(memo,-1);
        memo[0] = memo[1] = 0;
        System.out.println(dp(N));
    }
    static int dp(int n){
        if(memo[n] == -1){
            if(n % 6 == 0){
                memo[n] = Math.min(dp(n-1),Math.min(dp(n/3),dp(n/2))) + 1; //순회 횟수를 세기 위해, 1씩 더한다
            }
            else if(n % 3 == 0) {
                memo[n] = Math.min(dp(n/3),dp(n-1)) + 1;
            }
            else if(n % 2 ==0) {
                memo[n] = Math.min(dp(n/2),dp(n-1)) + 1;
            }else{
                memo[n] = dp(n-1) + 1;
            }
            // 경우의 수 별로 나올 수 있는 경우의 수를 모두 비교한 뒤, 가장 작은 값을 넣어준다
        }
        return memo[n];
    }
}