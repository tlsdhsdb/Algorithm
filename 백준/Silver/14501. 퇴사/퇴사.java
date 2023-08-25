import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author 신온유
 * @git
 * @youtube
 * @performance
 * @category
 * @note
 * N + 1 되는날 퇴사하기 위해서, 퇴사 전까지 최대한 많은 상담
 * 최대한 많은 상담을 하면서,최대 수익을 얻는 것이 목표
 * 역순으로 반대로 내려가며 진행한다는 것이 key point
 * 가장 큰 값을 저장해나가며 진행한다.
 * @see https://www.acmicpc.net/problem/14501
 * @since 2023-08-25
 **/
public class Main {
    static int N;
    static Counsel[] counsels;

    static int[] dp; // 값을 저장할 배열
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        counsels = new Counsel[N+1];
        dp = new int[N+2]; // 0 부터 마지막 출근날까지 구해야 함

        for(int n = 1 ; n < N + 1; n++){
            st = new StringTokenizer(br.readLine()," ");
            counsels[n] = new Counsel(st.nextToken(),st.nextToken());
        }

        for(int n = N ; n > 0; n--){
            if( n + counsels[n].time > N+1) dp[n] = dp[n+1];
            else dp[n] = Math.max(dp[n+1],counsels[n].money + dp[n + counsels[n].time]);
            // 거꾸로 내려가며, 점화식 세우기
            // 가격을 돌아가며 저장하고,현재 다음에 갈 시간의 값이 큰 경우만 해당 값을 저장한다
            
        }

        System.out.println(dp[1]);

    }


    static class Counsel{
        int time; //상담하는데 걸리는 시간
        int money; // 받을 수 있는 금액

        public Counsel(int time, int money) {
            this.time = time;
            this.money = money;
        }
        public Counsel(String time,String money){
            this.time = Integer.parseInt(time);
            this.money = Integer.parseInt(money);
        }
    }
}