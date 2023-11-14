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

        N = Integer.parseInt(st.nextToken()); //1~N 까지의 자연수
        M = Integer.parseInt(st.nextToken()); //수열의 길이

        st = new StringTokenizer(br.readLine()," ");

        number = new int[N];
        selected = new int[M];

        for(int n=0;n<N;n++){
            number[n] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(number);

        dfs(0,0,new boolean[N]);
        System.out.print(sb);
    }
    static void dfs(int start,int depth,boolean[] visited){
        if(depth == M){
            for(int m=0;m<M;m++){
                sb.append(selected[m] + " ");
            }
            sb.append("\n");
            return;
        }
        for(int i=start;i<number.length;i++){
            if(visited[i]) continue;
            selected[depth] = number[i];
            visited[i] = true;
            dfs(i+1,depth+1,visited);
            visited[i] = false;
        }
    }



}