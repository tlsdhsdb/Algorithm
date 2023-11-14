import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author onyoo
 * @performance
 * @category
 * @note
 * @see
 * @since 2023/11/14
 **/
public class Main {
    static int N,M;
    static int[] selected,number;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken()); //수의 개수
        M = Integer.parseInt(st.nextToken()); //수열의 길이

        number = new int[N];
        selected = new int[M];

        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            number[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(number); // 사전순으로 증가해야하기 때문에
        dfs(0);
        System.out.print(sb);
    }

    static void dfs(int depth){
        if(depth == M){
            for(int i=0;i<selected.length;i++){
                sb.append(selected[i] +" ");
            }
            sb.append("\n");
            return;
        }
        int prev = -1;
        for(int i=0;i<N;i++){
            if(prev == number[i]) continue;
            prev = number[i];
            selected[depth] = number[i];
            dfs(depth+1);
        }
    }
}