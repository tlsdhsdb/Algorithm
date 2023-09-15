import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author 신온유
 * @git
 * @youtube
 * @performance
 * @category dfs & 유니온 파인드
 * @note
 * 창용 마을 무리의 개수
 * 무리의 개수를 구하는 것 -> dfs 탐색 or union find를 통한 방법 두가지 가능
 * dfs의 탐색횟수를 구하면 되고,유니온 파인드의 경우 같은 집합에 포함되어있는지 대표 노드를 찾으면 된다
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWngfZVa9XwDFAQU#
 * @since 2023-09-15
 **/
public class Solution {
    static int T;
    static int N,M;
    static int[][] graph;
    static boolean[] visited;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for(int t = 0;t < T; t++){
            st = new StringTokenizer(br.readLine()," ");

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            graph = new int[N+1][N+1];
            visited = new boolean[N+1];
            answer = 0;

            for(int m = 0; m < M; m++){
                st = new StringTokenizer(br.readLine()," ");

                int i = Integer.parseInt(st.nextToken());
                int j =  Integer.parseInt(st.nextToken());

                graph[i][j] = 1;
                graph[j][i] = 1;
            }

            for(int i=1;i<=N;i++){
                if(!visited[i]) answer += dfs(i);
            }

            System.out.printf("#%d %d",t+1,answer);
            System.out.println();
        }
    }

    static int dfs(int start){
        visited[start] = true;
        for(int i=1;i<=N;i++){
            if(graph[start][i] == 1 && !visited[i]) dfs(i);
        }
        return 1;
    }
}