
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author onyoo
 * @performance
 * @category
 * @note
 * 음수가 있는 최소 스패닝 트리
 * 가중치가 최소가 되는 경로를 찾아야함 -> 크루스칼,프림 알고리즘
 * @see
 * https://www.acmicpc.net/problem/1197
 * @since 2023-11-01
 **/
public class Main {
    static class Node implements Comparable<Node> {
        int end,weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight-o.weight;
        }
    }
    static int V,E;
    static ArrayList<Node>[] adj;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine()," ");

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        adj = new ArrayList[V+1];
        parents = new int[V+1];
        for(int i=0;i<V+1;i++) adj[i] = new ArrayList<>();
        for(int i=1;i<V+1;i++) parents[i] = i;

        for(int e=0;e<E;e++){
            st = new StringTokenizer(br.readLine()," ");

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            adj[start].add(new Node(end,weight));
            adj[end].add(new Node(start,weight));
        }

        int result = prim();
        System.out.println(result);
    }

    static int prim(){
        boolean[] visited = new boolean[V+1];
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.add(new Node(1,0)); //시작노드는 항상 1번부터

        int result = 0; // 최종 가중치
        int count  = 0; //모든 노드를 순회했는지 확인

        while(!pq.isEmpty()){
            Node curr = pq.poll();
            if(visited[curr.end]) continue; // 이미 방문한 정점이면 pass
            result += curr.weight;
            visited[curr.end] = true;
            if(++count == V) return result;
            for(Node node : adj[curr.end]){
                //현재 노드와 연결된 노드 중 방문하지 않은 노드 찾기
                if(visited[node.end]) continue;
                pq.add(node);
            }
        }

        return result;
    }
}
    //pq에 데이터가 지속적으로 들어가기 때문에 최소 가중치를 가진 node가 먼저 나온다