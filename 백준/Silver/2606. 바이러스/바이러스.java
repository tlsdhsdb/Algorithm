import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * @author 신온유
 * @performance
 * @category
 * @note
 * 시작지점으로부터 연결되지 않은 컴퓨터는 바이러스에 걸리지 않는다
 * 시작지점을 받으면 해당 컴퓨터와 연결된 컴퓨터를 전체 탐색해야함
 * @see https://www.acmicpc.net/problem/2606
 * @since 2023-08-10
 **/
public class Main {
    static int V,E;
    //컴퓨터의 수 (정점) , 연결된 컴퓨터의 수 (간선)
    static LinkedList<Integer>[] adjList;
    //인접 리스트
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        V = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());

        adjList = new LinkedList[V + 1]; // 1부터 시작하기 때문에

        for(int v = 0; v <= V; v++){
            adjList[v] = new LinkedList<>();
        }
        //리스트 초기화

        for(int e = 1; e <= E; e++){
            st = new StringTokenizer(br.readLine()," ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            adjList[from].add(to);
            adjList[to].add(from);
        }

        System.out.println(dfs(1));

    }
    static int dfs(int start){
        Stack<Integer> stack = new Stack<>();
        int answer = -1; // 시작노드를 빼기 위해 -1로 시작함
        boolean visited[] = new boolean[V+1]; // 방문 정보 저장
        stack.add(start); // 시작 정점 저장

        while(!stack.isEmpty()){
            int node = stack.pop();

            if(visited[node]) continue;
            else{
                answer++;
                visited[node] = true; // 방문하지 않았다면
            }

            for(int n = adjList[node].size() - 1 ; n >= 0 ; n--){
                stack.add(adjList[node].get(n));
            }

        }
        return answer;
    }
}