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
 * @note 경로찾기
 * 양수인 경로가 있는지 유무를 확인하자
 * 인접행렬 방식으로 데이터가 주어진다
 * 플로이드 와샬 알고리즘 
 * 거쳐가는 경로가 있다면 처음부터 끝까지 가는 경로도 있다
 * @see https://www.acmicpc.net/problem/11403
 * @since 2023-09-05
 **/
public class Main {
    static int N;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j = 0;j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int n = 0; n < N; n++){
            //정점 n을 확인한다
            for(int i = 0; i < N; i++){
                for(int j = 0;j < N; j++){
                    if(map[i][n] == 1 && map[n][j] == 1) map[i][j] = 1;
                    // 가운데에 n이 있어 지나가는 경로를 지나갈 수 있는지 확인하기
                }
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0;j < N; j++){
                sb.append(map[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}