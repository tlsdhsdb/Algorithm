import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author 신온유
 * @performance
 * @category
 * @note
 * 도시가 주어지고,도시 사이에는 길의 유무는 모른다
 * @see https://www.acmicpc.net/problem/1976
 * @since 2023/09/14
 **/
public class Main {
    static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        int[] city = new int[N+1];

        for(int i=1;i<N+1;i++) city[i] = i;

        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=1;j<=N;j++){
                int tmp = Integer.parseInt(st.nextToken());
                if(tmp == 1){
                    union(city,i,j);
                }
            }
        }

        st = new StringTokenizer(br.readLine()," ");

        int start = find(city,Integer.parseInt(st.nextToken()));

        String answer = "YES";

        for(int i=1;i<M;i++){
            int now = Integer.parseInt(st.nextToken());
            if(start != find(city,now)) {
                answer = "NO";
                break;
            }
        }

        System.out.println(answer);

    }

    static void union(int[] parent,int a,int b){
        a = find(parent,a);
        b = find(parent,b);
        // 부모를 찾은다음

        if(a != b){
            // 부모가 다를경우
            parent[b] = a;
        }
    }
    static int find(int[] parent,int a){
        if(parent[a] == a) return a;
        return parent[a] = find(parent,parent[a]);
    }

}