import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author 신온유
 * @performance
 * @category
 * @note
 * 기본적인 dfs,bfs 문제
 * @see https://www.acmicpc.net/problem/1260
 * @since 2023-08-10
 **/
public class Main {
    static int N,M,V;
    static LinkedList<Integer>[] adj;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken()); // 정점의 개수
        M = Integer.parseInt(st.nextToken()); // 간선의 개수
        V = Integer.parseInt(st.nextToken()); // 탐색 시작 번호

        adj = new LinkedList[N+1];

        for(int n = 0; n < N + 1; n++){
            adj[n] = new LinkedList();
        }

        for(int m=0;m<M;m++){
            st = new StringTokenizer(br.readLine()," ");

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            adj[from].add(to);
            adj[to].add(from);

        }

        for(int i=1;i<=N;i++) Collections.sort(adj[i]);

        dfs(V);

        sb.append("\n");

        bfs(V);

        System.out.println(sb);

    }
    static void dfs(int start){
        Stack<Integer> stack = new Stack<>();
        boolean visited[] = new boolean[N+1];

        stack.add(start); // 시작정점 저장

        while(!stack.isEmpty()){
            int target = stack.pop();
            if(visited[target]) continue; // 이미 방문했다면
            else visited[target] = true; // 방문하지 않았을 경우
            sb.append(target + " ");
            for(int i = adj[target].size() - 1 ; i >= 0 ; i-- ){
                stack.add(adj[target].get(i));
            }
        }
    }
    static void bfs(int start){
        Queue<Integer> que = new ArrayDeque<>();
        boolean[] visited = new boolean[N+1];

        que.add(start);

        while(!que.isEmpty()){
            int target = que.poll();
            if(visited[target]) continue; // 이미 방문한 노드
            else visited[target] = true; // 방문하지 않은 노드라면

            sb.append(target + " ");

            for(int node : adj[target]){
                if(!visited[node]){
                    que.add(node);
                }
            }
        }
    }



}