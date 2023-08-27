import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author 신온유
 * @performance
 * @category
 * @note
 * @see https://www.acmicpc.net/problem/14889
 * @since 2023-08-27
 **/
public class Main {
    static int N;
    static int[][] team;
    static boolean[] visit; // 스타트팀
    static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        team = new int[N][N];
        visit = new boolean[N];

        for(int i = 0 ;i < N; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j = 0;j < N; j++){
                team[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0,0);
        System.out.print(MIN);

    }
    static void dfs(int depth,int idx){
        if(depth == N/2){
            diff();
            return;
        }
        for(int i = idx ; i < N ; i++){
            if(!visit[i]){
                visit[i] = true;
                dfs(depth+1,i+1);
                visit[i] = false;
            }
        }
    }
    static void diff(){
        int team_start = 0;
        int team_link = 0;

        for(int i=0;i<N-1;i++){
            for(int j=i+1;j<N;j++){
                if(visit[i] && visit[j]){
                    team_start += team[i][j];
                    team_start += team[j][i];
                }
                if(!visit[i] && !visit[j]){
                    team_link += team[i][j];
                    team_link += team[j][i];
                }
            }
        }

        int val = Math.abs(team_start-team_link);
        // 두 팀의 점수 차이

        if(val == 0){
            System.out.println(val);
            System.exit(0);
        }
        //두팀의 점수차가 0이되는 건 가장 작은 값이기 때문에
        //종료
        //그렇지 않으면, 최솟값을 찾음

        MIN = Math.min(MIN,val);

    }
}