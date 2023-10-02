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
 * @since 2023/10/03
 **/
public class Main {
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int answer = 0;

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        arr = new int[N+1][N+1];

        for(int i=0;i<N+1;i++){
            arr[i][1] = i;
            arr[i][i] = 1;
            arr[i][0] = 1;
        }

        for(int i=2;i<N+1;i++){
            for(int j=1;j<i;j++){
                arr[i][j] = arr[i-1][j] + arr[i-1][j-1];
            }
        }
        System.out.println(arr[N][K]);
    }
}