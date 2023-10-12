import java.util.*;
import java.io.*;

/**
 * @author onyoo
 * @performance
 * @category
 * @note
 * @see
 * @since 2023-10-11
 **/
public class Solution {
    static int T;
    static int N,M;
    // 노드의 개수 , 간선의 개수
    static List<Integer>[] list;
    static boolean[] visited;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for(int t=1;t<T+1;t++){
            st = new StringTokenizer(br.readLine()," ");

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            list = new ArrayList[N];
            visited = new boolean[N];

            for(int n=0;n<N;n++) list[n] = new ArrayList<>();

            answer = 0;

            for(int m=0;m<M;m++){
                st = new StringTokenizer(br.readLine()," ");

                int a = Integer.parseInt(st.nextToken()) - 1;
                int b = Integer.parseInt(st.nextToken()) - 1;

                list[a].add(b);
                list[b].add(a);
            }

            for(int i=0;i<N;i++){
                if(!visited[i]){
                    dfs(i);
                    answer++;
                }
            }
            System.out.printf("#%d %d \n",t,answer);
        }
    }
    static void dfs(int start){
         visited[start] = true;
         for(int value : list[start]){
             if(visited[value]) continue;
             dfs(value);
         }
    }
}