import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author onyoo
 * @performance
 * @category
 * @note
 *
 * @see https://www.acmicpc.net/problem/2583
 * @since 2023-10-16
 **/
public class Main {
    static class Point{
        int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int M,N,K;
    static Point[] dir = {new Point(0,1),new Point(0,-1),new Point(1,0),new Point(-1,0)};
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        StringBuilder sb = new StringBuilder();

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0;i<K;i++){
            st = new StringTokenizer(br.readLine()," ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());

            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            draw(new Point(x1,y1),new Point(x2,y2));
        }
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j] == 0 && !visited[i][j]) arr.add(bfs(new Point(i, j)));
            }
        }
        Collections.sort(arr);

        sb.append(arr.size()).append("\n");
        for(int value : arr ) sb.append(value).append(" ");

        System.out.println(sb);

    }

    static int bfs(Point start){
        Queue<Point> que = new ArrayDeque<>();
        que.add(start);
        visited[start.x][start.y] = true;
        int cnt = 0;
        while(!que.isEmpty()){
            int size = que.size();
            for(int i=0;i<size;i++){
                Point curr = que.poll();
                cnt++;
                for(Point d : dir){
                    int nx = curr.x + d.x;
                    int ny = curr.y + d.y;

                    if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                    if(map[nx][ny] == 1 || visited[nx][ny]) continue;

                    que.add(new Point(nx,ny));
                    visited[nx][ny] = true;
                }
            }
        }
        return cnt;
    }

    static void draw(Point start,Point end){
        //정해진 영역을 칠하는 메서드
        for(int i=start.x;i<end.x;i++){
            for(int j=start.y;j<end.y;j++){
                map[i][j] = 1;
            }
        }
    }
}