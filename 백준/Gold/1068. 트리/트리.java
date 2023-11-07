import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * @author onyoo
 * @performance
 * @category
 * @note
 * 탐색 문제 지워진 노드를 만나면 더이상 탐색할 수 없도록 하자
 * @see
 * https://www.acmicpc.net/problem/1068
 * @since 2023/11/07
 **/
public class Main {
    static int N,D,root,ans;
    static ArrayList<Integer>[] adjList;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        adjList = new ArrayList[N];
        visited = new boolean[N];

        root = -1;
        ans = 0;

        for(int n=0;n<N;n++) adjList[n] = new ArrayList<>();

        st = new StringTokenizer(br.readLine()," ");

        for(int i=0;i<N;i++){
            int parent = Integer.parseInt(st.nextToken());
            if(parent != -1) {
                adjList[parent].add(i);
                adjList[i].add(parent);
            }else{
                root = i;
            }
        }

        D = Integer.parseInt(br.readLine());
        dfs(root);
        System.out.println(root == D ? 0 :ans);
    }
    static void dfs(int idx){
        visited[idx] = true; // 방문한 노드는 방문처리
        int node = 0; // 자식노드의 개수
        for(int curr : adjList[idx]){
            if(curr != D && !visited[curr]){
                // 삭제한 노드가 아니면서 방문한 적이 없어야 한다
                node++;
                dfs(curr); //
            }
        }
        if(node == 0){
            ans++;
        }
        // 자식노드가 하나도 없으면 leaf node
    }
}