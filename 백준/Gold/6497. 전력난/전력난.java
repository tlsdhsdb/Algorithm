import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author 신온유
 * @git
 * @youtube
 * @performance
 * @category
 * @note
 * 제일 적은 불로,많은 길을 켜야 한다
 * @see
 * @since 2023-08-23
 **/
public class Main {
    static class Edge implements Comparable<Edge> {
        int from, to, weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
    static int m,n;
    static Edge[] edgeList;
    static int[] parents;
    static int sum;
    static void make(){
        parents = new int[m];
        for(int i=0;i<m;i++){
            parents[i] = i;
        }
    }
    static int find(int a){
        if(parents[a] == a) return a;
        return find(parents[a]);
    }

    static boolean union(int a,int b){
        int aRoot = find(a);
        int bRoot = find(b);

        if(aRoot == bRoot) return false;
        parents[bRoot] = aRoot;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        while(true){
            st = new StringTokenizer(br.readLine()," ");
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());

            if(m + n == 0) break;

            edgeList = new Edge[n];

            for(int i = 0;i < n ; i ++){
                st = new StringTokenizer(br.readLine()," ");
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                sum += weight;

                edgeList[i] = new Edge(from,to,weight);
            }

            Arrays.sort(edgeList);

            make();

            int result = 0; // MST 비용
            int count = 0; // 연결된 간선 개수

            for(Edge edge : edgeList){ // 비용이 작은 간선순으로 꺼내어서 처리
                if(union(edge.from,edge.to)){
                    result += edge.weight;
                    if(++count == m-1)break;;
                }
            }
            System.out.println(sum-result);

            sum = 0;
        }
    }

}