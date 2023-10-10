import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author onyoo
 * @performance
 * @category
 * @note
 * @see
 * 두 선거구로 나누었을때 인구의 차이를 최소화
 * 각각의 선거구는 이어져있어야한다
 * 1. 두 선거구로 나눈다 -> 경우의 수를 구한다
 * 2. 각각의 선거구의 인구 차를 구한다 -> 최솟값보다 크다면 이후 과정을 할 필요가 없다
 * 3. 선별된 선거구가 이어져있는지 확인한다
 * @since 2023-10-10
 **/
public class Main {
    static int p;
    static int[] population; //인구수 저장
    static int[] arr; // 경우의 수 저장
    static ArrayList<Integer>[] list; //인접리스트 저장
    static boolean[] visited;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        p = Integer.parseInt(br.readLine());
        population = new int[p];
        arr = new int[p];
        list = new ArrayList[p];
        answer = Integer.MAX_VALUE;



        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<p;i++){
            population[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<p;i++){
            st = new StringTokenizer(br.readLine()," ");
            int k = Integer.parseInt(st.nextToken());
            list[i] = new ArrayList<>();
            for(int j=0;j<k;j++) list[i].add(Integer.parseInt(st.nextToken())-1);
        }

        dfs(0);
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    static void dfs(int depth){
        if(depth == population.length){
            // 모든 선거구가 배정되었다
            // 선거구가 하나에 치우치면 안된다
            // 두 선거구 모두에 최소 하나의 구가 있으면서 인구수 차이가 최소인 경우를 골라내야한다

            int a = 0;
            int b = 0;
            //각 선거구의 인구수를 구하자

            for(int i=0;i<arr.length;i++){
                if(arr[i] == 1) a += population[i];
                else b += population[i];
            }
            int diff = Math.abs(a-b);
            if(a == 0 || b ==  0) return; //하나의 선거구라도 텅 빈다면 잘못된 것
            if(answer < diff) return; // 인구수의 차이가 기존에 가지고 있는 최솟값보다 크다면 더이상 탐색할 필요가 없다
            // 연결 여부 확인하기
            int cnt = 0;
            visited = new boolean[p]; // 방문배열 초기화하기
            for(int i=0;i<list.length;i++){
                if(visited[i]) continue;
                bfs(i,arr[i]);
                cnt++;
            }
            if(cnt == 2) answer = Math.min(answer,diff);

            return;
        }

        arr[depth] = 1;
        dfs(depth+1);
        //1선거구 선택

        arr[depth] = 2;
        dfs(depth+1);
        //2선거구 선택
    }
    static void bfs(int start,int gu){
        Queue<Integer> que = new ArrayDeque();
        que.add(start);

        while(!que.isEmpty()){
            int curr = que.poll();
            visited[curr] = true;

            for(int val : list[curr]){
                if(!visited[val] && arr[val] == gu) que.add(val);
            }
        }
    }
}