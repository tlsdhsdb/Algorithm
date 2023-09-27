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
 * @see
 * @since 2023-09-27
 **/
public class Main {
    static class Point{
        int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int R,C;
    static char[][] map;
    static Point start,end;
    static Queue<Point> water;
    static int[][] visited;
    static Point[] arrow = {new Point(0,1),new Point(0,-1),new Point(1,0),new Point(-1,0)};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new int[R][C];
        water = new ArrayDeque<>();

        for(int r = 0; r < R; r++) {
            char[] tmp = br.readLine().toCharArray();
            for(int c = 0; c <C; c++){
                map[r][c] = tmp[c];
                if(map[r][c] == 'D') end = new Point(r,c);
                else if(map[r][c] == 'S') start = new Point(r,c);
                else if(map[r][c] == '*') water.add(new Point(r,c));
            }
        }

        bfs(start);
        if(visited[end.x][end.y] == 0) System.out.println("KAKTUS");
        else{
            System.out.println(visited[end.x][end.y]);
        }
    }

    static void bfs(Point start){
        Queue<Point> que = new ArrayDeque<>();
        que.add(start);

        while(!que.isEmpty()){
            int size = water.size();
            for(int i=0;i<size;i++){
                Point w = water.poll();
                int x = w.x;
                int y = w.y;

                for(Point arr : arrow){
                    int nx = x + arr.x;
                    int ny = y + arr.y;

                    if(nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
                    if(map[nx][ny] == 'D' || map[nx][ny] == 'X' || map[nx][ny] == '*') continue;
                    map[nx][ny] = '*';
                    water.add(new Point(nx,ny));
                }
            }
            //존재하는 물의 양만큼 한번 옮겨준다
            size = que.size();

            for(int i=0;i<size;i++){
                Point c = que.poll();
                int x = c.x;
                int y = c.y;

                for(Point arr : arrow){
                    int nx = x + arr.x;
                    int ny = y + arr.y;

                    if(nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
                    if(visited[nx][ny] > 0 ) continue; // 0이상이라면 이미 방문한 지역
                    if(map[nx][ny] == '*' || map[nx][ny] == 'X') continue; //돌이나 물이 차있다면 이동하지 않는다

                    visited[nx][ny] = visited[x][y] + 1;
                    que.add(new Point(nx,ny));
                }
            }

        }
    }


}