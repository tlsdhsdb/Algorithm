import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 한번에 연결된 길이가 5이상이 있는지 확인하면 됨
// 노드의 깊이를 확인하면 됨

public class Main {
    static int N,M;
    static ArrayList<Integer>[] friends;

    static boolean answer;

    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        friends = new ArrayList[N];

        for(int n = 0; n < N; n++){
            friends[n] = new ArrayList<>();
        }

        visited = new boolean[N];

        for(int m = 0; m < M ; m ++){
            st = new StringTokenizer(br.readLine()," ");

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            friends[from].add(to);
            friends[to].add(from);

        }

        for(int n = 0; n < N; n++){
            Collections.sort(friends[n]);
        }

        for(int i = 0 ; i < N ; i++){
            dfs(i,1); // 각 노드 하나하나를 탐색하면서 조건을 충족하는 경우
            if(answer) break; // break
        }
        
        if(answer) System.out.println(1);
        else System.out.println(0);
        

    }

    static void dfs(int start,int depth){
       if(depth == 5) {
           answer = true;
           return;
       }

       visited[start] = true;

       for(int value : friends[start]){
           if(!visited[value]) dfs(value,depth+1);
       }
       visited[start] = false;

    }

}