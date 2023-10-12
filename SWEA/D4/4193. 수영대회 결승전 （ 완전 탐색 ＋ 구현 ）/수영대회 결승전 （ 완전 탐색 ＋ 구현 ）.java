import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author onyoo
 * @performance
 * @category
 * @note
 * @see
 * @since 2023-10-12
 **/
public class Solution {
    static class Point{
        int x,y;
        int time;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Point(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
    static int T,N;
    static int[][] map;
    static Point start,end;
    static Point[] dir = {new Point(1,0),new Point(-1,0),new Point(0,1),new Point(0,-1)};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());

        for(int t=1;t<T+1;t++){
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine()," ");
                for(int j=0;j<N;j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            st = new StringTokenizer(br.readLine()," ");
            start = new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));

            st = new StringTokenizer(br.readLine()," ");
            end = new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));

            int answer = bfs();
            System.out.printf("#%d %d \n",t,answer);
        }
    }
    static int bfs(){
        Queue<Point> que = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][N];
        que.add(start);
        visited[start.x][start.y] = true; //첫번째 노드 방문

        while(!que.isEmpty()){
            int size = que.size();
            for(int i=0;i<size;i++){
                Point curr = que.poll();
                if(curr.x == end.x && curr.y == end.y) return curr.time;
                for(Point p : dir){
                    int nx = curr.x + p.x;
                    int ny = curr.y + p.y;
                    int time = curr.time;

                    if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue; // 유효하지 않은 좌표일 경우 못간다
                    if(map[nx][ny] == 1 || visited[nx][ny]) continue; // 장애물일 경우 못간다
                    if(map[nx][ny] == 2){
                        if(time % 3 == 2){
                            que.add(new Point(nx,ny,time+1));
                            visited[nx][ny] = true;
                            // 소용돌이가 없어지는 시간일 경우
                        }else{
                            que.add(new Point(curr.x, curr.y,time+1));
                            //소용돌이가 계속 있을 경우
                            //자리에서 시간만 보낸다
                        }
                        continue;
                    }//소용돌이를 마주한 경우
                    que.add(new Point(nx,ny,time+1));
                    visited[nx][ny] = true;
                    //장애물 , 소용돌이가 없는 경우 그냥 간다
                }
            }
        }
        return -1;
    }
}