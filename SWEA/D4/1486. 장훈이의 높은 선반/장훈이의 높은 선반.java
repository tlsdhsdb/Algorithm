import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author 신온유
 * @performance
 * @category
 * @note
 * @see
 * @since 2023/10/11
 **/
public class Solution {
    static int T,N,B;
    static int min;
    static int[] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for(int t=1;t<T+1;t++){
            st = new StringTokenizer(br.readLine()," ");
            N = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            arr = new int[N];
            visited = new boolean[N];

            min = Integer.MAX_VALUE; // 최솟값을 찾기 위함
            st = new StringTokenizer(br.readLine()," ");
            for(int n=0;n<N;n++) {
                arr[n] = Integer.parseInt(st.nextToken());
            }
            dfs(0,0,0);
            System.out.printf("#%d %d\n",t,Math.abs(B-min));
        }
    }
    static void dfs(int depth,int sum,int idx){
        if(depth == N){
            if(sum >= B) min = Math.min(sum,min);
            return;
        }
        dfs(depth+1,sum,idx+1); // 안넣음
        dfs(depth+1,sum+arr[idx],idx+1); // 넣음
    }
}