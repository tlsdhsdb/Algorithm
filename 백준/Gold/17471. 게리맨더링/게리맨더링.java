import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author 신온유
 * @performance
 * @category
 * @note
 * @see
 * @since 2023-08-10
 **/
public class Main {
    static int n; // 구의 개수
    static int[] population,area; // 인구수,지역구 배열
    static ArrayList<Integer>[] list;
    static int min = Integer.MAX_VALUE;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine()); // 구역의 개수

        population = new int[n+1]; // 인구수를 저장하기 위한 배열, 1부터 시작하기 때문에 n+1의 크기를 가지도록 함
        list = new ArrayList[n+1]; // 그래프를 저장하기 위한 배열, 인접리스트로 저장한다

        st = new StringTokenizer(br.readLine()," ");
        for(int i = 1; i <= n; i++){
            list[i] = new ArrayList<>(); // 인접리스트 초기화
            population[i] = Integer.parseInt(st.nextToken()); //인구수 저장
        }

        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine()," ");
            int num = Integer.parseInt(st.nextToken()); // 구역의 인접정보 개수
            for(int j = 0; j < num; j++){
                list[i].add(Integer.valueOf(st.nextToken())); // 인접정보 저장
            }
        } // 그래프 입력

        area = new int[n+1]; // 각 지역구가 속한 선거구 저장 1 or 2
        //지역구는 인덱스로 구분하며 해당 인덱스의 지역구가 속한 선거구가 어디인지 저장하는 배열
        dfs(1); // 뽑을 수 있는 모든 지역구를 뽑는 dfs 탐색
        //완전탐색을 이용하여,각각의 지역구가 어떤 선거구를 가질지 모든 경우의 수를 탐색헀다
        //n의 최대 크기가 10이기 때문에 완전탐색을 해도 괜찮다는 생각을 함

        if(min == Integer.MAX_VALUE) System.out.println("-1");
        else System.out.println(min);

    }

    public static void dfs(int k){
        // 1번 지역구부터 시작하며 선거구를 할당함
        // 조건에 부합하지 않는다면 2번 선거구를 할당함

        if(k == n+1){ //마지막까지 탐색했다면
            int area1 = 0;
            int area2 = 0;
            // 두 지역간 인구수의 차를 구해야 하기 때문에 두개의 변수를 생성

            for(int i = 1;i <= n; i++){
                if(area[i] == 1) area1 += population[i];
                else area2 += population[i];
            }
            // 배정된 지역구를 바탕으로 인구수를 셈

            visited = new boolean[n+1];
            int link = 0; // 인접 지역들의 개수를 셈

            for(int i=1;i<=n;i++){
                if(!visited[i]){
                    bfs(i,area[i]);
                    link++;
                    //구역이 연결될 경우 = 2
                }
            }
            // 두개의 구역으로 연결되는지 확인 함

            if(link == 2) min = Math.min(min,Math.abs(area1-area2));
            // 두개의 구역이 연결될 경우 차이가 가장 작은 값이 저장된다.
            return;
        }
        area[k] = 1;
        dfs(k+1); // 지역구를 1로 배정한뒤 탐색한다

        area[k] = 2;
        dfs(k+1); // 지역구를 2로 배정한뒤 탐색한다

    }
    static void bfs(int idx,int areaNum){
        Queue<Integer> que = new LinkedList<>();
        visited[idx] = true;
        que.offer(idx);

        while(!que.isEmpty()){
            int curr = que.poll(); // head의 데이터를 가져옴
            for(int i=0;i< list[curr].size();i++){
                int next = list[curr].get(i);
                if(area[next] == areaNum && !visited[next]){
                    que.offer(next);
                    visited[next] = true;
                }
            }
        }
    }
}