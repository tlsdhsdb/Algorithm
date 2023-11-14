import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author onyoo
 * @performance
 * @category
 * @note
 * @see
 * @since 2023/11/14
 **/
public class Main {
    static int N,M,V;
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];

        for(int i=0;i<N+1;i++) list[i] = new ArrayList<>();

        for(int m=0;m<M;m++){
            st = new StringTokenizer(br.readLine()," ");

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            list[start].add(end);
            list[end].add(start);
        }

        for(int i=0;i<N+1;i++) Collections.sort(list[i]);

        visited = new boolean[N+1];
        dfs(V);
        sb.append("\n");

        visited = new boolean[N+1];
        bfs(V);

        System.out.println(sb);

    }
    static void dfs(int start){
        sb.append(start+" ");
        visited[start] = true;
        for(int value : list[start]){
            if(visited[value]) continue;
            visited[value] = true;
            dfs(value);
        }
    }

    static void bfs(int start){
        Queue<Integer> que = new ArrayDeque<>();
        que.add(start);
        visited[start] = true;

        while(!que.isEmpty()){
            int curr = que.poll();
            sb.append(curr + " ");
            for(int value : list[curr]){
                if(visited[value]) continue; // 방문여부
                visited[value] = true;
                que.add(value);
            }
        }
    }
}