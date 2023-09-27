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
 * @see
 * @since 2023-09-27
 **/
public class Solution {
    static int T,N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for(int t = 1; t < T+1; t++){
            st = new StringTokenizer(br.readLine()," ");
            N = Integer.parseInt(st.nextToken());

            int[][] network = new int[N][N];

            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++) {
                    network[i][j] = Integer.parseInt(st.nextToken());
                    if(network[i][j] == 0) network[i][j] = 1000;
                }
            }

            for(int k=0;k<N;k++){ // 노드 개수
                for(int i=0;i<N;i++){ // 출발
                    for(int j=0;j<N;j++){ // 도착
                        if(i == j) continue;
                        network[i][j] = Math.min(network[i][j],network[i][k] + network[k][j]);
                    }
                }
            }
            int min = Integer.MAX_VALUE;
            for(int i=0;i<N;i++){
                int tmp = 0;
                for(int j=0;j<N;j++){
                    if(i==j) continue;
                    tmp += network[i][j];
                }
                min = Math.min(min,tmp);
            }

            System.out.printf("#%d %d \n",t,min);
        }

    }
}