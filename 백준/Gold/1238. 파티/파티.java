import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author onyoo
 * @performance
 * @category
 * @note
 * 다익스트라 알고리즘
 * 1.가중치의 값이 양수
 * 2.최소 시간을 가지면서 최단거리로 가야한다는 점
 * 중요한 점
 * 모두가 하나의 정점으로 도착하고,하나의 정점에서 시작한다는 점을 생각하면
 * 인접리스트를 두개로 만들어야 한다는 생각을 할 수 있다.
 * 1 -> 2 , 3 -> 2 ...
 * 2 -> 1 , 2 -> 3 ...
 * 이 두개의 경우는 정확하게 반대이다, 이것을 이용해서 시작정점과 도착정점을 바꿔준 reverse 인접리스트가 필요
 * @see
 * https://www.acmicpc.net/problem/1238
 * @since 2023-10-17
 **/
public class Main {
    static class Node implements Comparable<Node>{
        int idx,time;

        public Node(int idx, int time) {
            this.idx = idx;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return time - o.time;
        }
    }
    static int N,M,X;
    static ArrayList<Node>[] adjList;
    static ArrayList<Node>[] adjListR;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[N+1];
        adjListR = new ArrayList[N+1];
        for(int i=0;i<N+1;i++) {
            adjList[i] = new ArrayList<>(); //인접 리스트 초기화
            adjListR[i] = new ArrayList<>();
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            adjList[s].add(new Node(e,t));
            adjListR[e].add(new Node(s,t));
        }

        int answer = 0;

        int[] dist1 = bfs(adjList);
        int[] dist2 = bfs(adjListR);

        //reverse list를 만드는 이유
        // 하나의 노드 -> 여러노드로 가야하는데,다익스트라의 경우
        // 여러 노드 -> 하나의 노드로 갈때 최단거리비용을 구하기 때문에
        // 여기 에서 대상 인접리스트의 형태만 바꿔주면 되기 때문이다 그것이 바로 노드 출발 도착점 뒤집기!

        for(int i=1;i<N+1;i++){
            answer = Math.max(dist1[i] + dist2[i],answer);
        }

        System.out.println(answer);
    }
    static int[] bfs(ArrayList<Node>[] adj){
        Queue<Node> que = new PriorityQueue<>();
        int[] answer = new int[N+1];
        Arrays.fill(answer,987654321);
        que.add(new Node(X,0)); // 지금 시작합니다.
        answer[X] = 0; //도착지로 들어오는건 0

        while(!que.isEmpty()){
            Node curr = que.poll();
            for(Node node : adj[curr.idx]){
                if(curr.time + node.time < answer[node.idx]){
                    answer[node.idx] = curr.time + node.time;
                    que.add(new Node(node.idx,answer[node.idx]));
                }
            }
        }
        return answer;
    }
}