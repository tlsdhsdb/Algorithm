import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author 신온유
 * @git
 * @youtube
 * @performance
 * @category
 * @note
 * 토마토 - 그래프 탐색 문제
 * 익은 토마토의 상하좌우에 있는 토마토가 영향을 받아 익는다
 * 며칠뒤에 모든 토마토가 익게되는지 최소 일수를 알고싶다
 * BFS 의 깊이를 구하는 문제
 *
 * 1. 토마토가 1개 이상일 경우를 생각 할 것,예제 2번의 경우 양끝에서 토마토가 익어간다.
 * 이러한 경우를 처리해주기위해 큐에 토마토의 위치를 모두 넣어주어 같이 탐색해나갔다.
 *
 * 2. bfs에서 그래프의 depth를 구하기 위해서는 큐의 사이즈를 저장한 뒤, for 문으로 사이즈만큼만 loop를 돌도록 한다
 * 그렇게 되면, 큐에서 모든 데이터가 빠져나가지 않고, 하나의 depth에 저장된 데이터만 뽑히기 때문에 depth를 뽑아낼 수 있다
 *
 * @see https://www.acmicpc.net/problem/7576
 * @since 2023-09-04
 **/
public class Main {
    static class Point{
        int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int M,N;
    static int[][] map;
    static Point[] arrow = {
            new Point(-1,0),
            new Point(1,0),
            new Point(0,-1),
            new Point(0,1)
    };
    static Queue<Point> que = new ArrayDeque<>();
    static int day;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int n=0;n<N;n++){
            st = new StringTokenizer(br.readLine()," ");
            for(int m=0;m<M;m++){
                map[n][m] = Integer.parseInt(st.nextToken());
            }
        }

        for(int n=0;n<N;n++){
            for(int m=0;m<M;m++){
                if(map[n][m] == 1) que.add(new Point(n,m));
            }
        }

        bfs();

        for(int n=0;n<N;n++){
            for(int m=0;m<M;m++){
                if(map[n][m] == 0) day = -1;
            }
        }
        System.out.println(day);

    }

    static void bfs(){
        while(!que.isEmpty()){
            int count = 0; // 변경된 것이 있는지 확인
            int size = que.size();
            for(int i = 0; i < size ;i++){
                Point curr = que.poll();

                for(Point ar : arrow){
                    int nx = curr.x + ar.x;
                    int ny = curr.y + ar.y;

                    if(nx < 0 || nx >= N || ny < 0 || ny >= M ) continue;
                    if(map[nx][ny] == 0){
                        //익은 토마토만
                        map[nx][ny] = 1; // visited 일때만
                        que.add(new Point(nx,ny));
                        count++;
                    }
                }
            }
            if(count != 0) day++;
        }

    }
}