import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author 신온유
 * @git
 * @youtube
 * @performance
 * @category
 * @note
 * 지구에 있는 모든 사람들은 최대 6단계 이내에서 서로 아는 사람으로 연결될 수 있다
 * -> 임의의 두 사람이 최소 몇 단계 만에 이어질 수 있는지 계산하는 게임
 * 아는 사람 사이를 그래프의 간선으로 표현한다
 * 가장,짧은 길이를 탐색해야하는 사람을 고르는 문제
 * 이 문젠 BFS를 통해서 최단거리를 탐색해도 되지만, 점의 개수가 100개로 매우 작기 때문에 플로이드 와샬을 사용해도 무방하다
 * (플로이드 와샬 알고리즘의 경우 시간복잡도가 O(N^3)이기 때문에 그래프의 크기가 작을 때 사용하는 것이 적절하다)
 * 100의 세제곱은 100만정도이기 때문에 시간제한 2초만에 풀어낼 수 있다
 * (1초에 1억번 제한)
 * @see https://www.acmicpc.net/problem/1389
 * @since 2023-09-07
 **/
public class Main {
    static int N,M;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];



        for(int i=0;i<N;i++){
            Arrays.fill(map[i],101);
            map[i][i] = 0;
        }

        for(int m=0;m<M;m++){
            st = new StringTokenizer(br.readLine()," ");

            int x = Integer.parseInt(st.nextToken()) -1 ;
            int y = Integer.parseInt(st.nextToken()) -1;

            map[x][y] = 1;
            map[y][x] = 1;
        }

        for(int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        int idx = -1;

        for (int i = 0; i < N; i++) {
            int tmp = 0;
            for (int j = 0; j < N; j++) {
                if(map[i][j] == 101) map[i][j] = 0;
                tmp += map[i][j];
            }
            if(min > tmp){
                min = tmp;
                idx = i;
            }
            tmp = 0;
        }

        System.out.println(idx+1);
    }
}