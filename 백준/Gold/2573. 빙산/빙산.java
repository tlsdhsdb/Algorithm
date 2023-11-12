import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author onyoo
 * @performance
 * @category
 * @note
 * @see
 * @since 2023/11/12
 **/
public class Main {
    static class Ice{
        int x,y;
        int size;

        public Ice(int x, int y, int size) {
            this.x = x;
            this.y = y;
            this.size = size;
        }
    }
    static int N,M;
    static int[][] map;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static List<Ice> list;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        list = new ArrayList<>();

        int time = 0; // 시간


        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] != 0) list.add(new Ice(i,j,map[i][j]));
            }
        }

        int lump = 0; // 덩어리 개수
        while(true){
            time++;
            for(Ice ice : list){
                int count = 0; // 주변 물의 개수
                for(int i=0;i<4;i++){
                    int nx = ice.x + dx[i];
                    int ny = ice.y + dy[i];

                    if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                    if(map[nx][ny]== 0) count++;
                }
                if(ice.size > count) ice.size = ice.size - count;
                else ice.size = 0;
            }
            //얼음의 사이즈 지정해주기

            for(int i=0;i<list.size();i++){
                Ice ice = list.get(i);
                map[ice.x][ice.y] = ice.size; // 사이즈 재정의
                if(ice.size == 0) {
                    list.remove(i--);
                }
            }

            if(list.isEmpty()) {
                time = 0; // 모든 얼음이 녹았을 경우
                break;
            }

            visited = new boolean[N][M];
            //매 분기마다 빙산의 높이가 달라지기 때문에 체크하기

            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(!visited[i][j] && map[i][j] > 0) {
                        lump += bfs(i,j);
                    }
                }
            }
            if(lump > 1) break;
            else {
                lump = 0;
            }

        }
        System.out.println(time);
    }

    static int bfs(int x,int y){
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{x,y});
        visited[x][y] = true;

        while(!que.isEmpty()){
            int[] curr = que.poll();
            for(int i=0;i<4;i++){
                int nx = curr[0] + dx[i];
                int ny = curr[1] + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(visited[nx][ny]) continue; // 이미 방문한 적이 있을 경우
                if(map[nx][ny] == 0) continue; // 바다일경우
                visited[nx][ny] = true;
                que.add(new int[]{nx,ny});
            }
        }
        return 1;
    }
}