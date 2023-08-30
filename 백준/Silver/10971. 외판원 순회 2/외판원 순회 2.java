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
 * @see https://www.acmicpc.net/problem/10971
 * @since 2023-08-30
 **/
public class Main {
    static int N; // 도시의 수
    static int[][] map;// 도시 그래프를 저장 할 2차원 배열
    static boolean[] visited;
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++){
            dfs(i,i,0,0);
        }
        System.out.println(result);
    }
    static void dfs(int start,int node,int depth,int sum){
        if(depth == N && start == node){
            // 시작지점 = 돌아오는 지점
            result = Math.min(result,sum);

        }
        for(int i = 0 ; i < N; i++){
            if(map[node][i] == 0) continue; // 본인과 본인을 연결하는 선은 없다
            if(!visited[i] && map[node][i] > 0){
                //방문을 한번도 하지않은 마을이면서,자기자신이 아닌 다른 노드일 경우
                visited[i] = true;
                sum +=  map[node][i];
                dfs(start,i,depth+1,sum);
                sum -= map[node][i];
                visited[i] = false;
            }
        }

    }
}