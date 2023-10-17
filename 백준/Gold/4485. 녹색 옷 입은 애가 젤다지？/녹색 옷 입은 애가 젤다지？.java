import java.io.*;
import java.util.*;

/**
 * @author onyoo
 * @performance
 * @category
 * @note
 * @see https://www.acmicpc.net/problem/4485
 * @since 2023-10-13
 **/
public class Main {
    static class Point implements Comparable<Point> {
        int x,y;
        int value;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Point(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }

        @Override
        public int compareTo(Point o) {
            return value - o.value;
        }
    }
    static int N;
    static int[][] map;
    static Point[] dir = {new Point(0,1),new Point(0,-1),new Point(1,0),new Point(-1,0)};
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st;
        int num = 1;
        while(true){
            N = Integer.parseInt(br.readLine());

            if(N==0){
                System.out.println(sb);
                break;
            }else{
                map = new int[N][N];
                answer = Integer.MAX_VALUE;
                for(int i=0;i<N;i++){
                    st = new StringTokenizer(br.readLine()," ");
                    for(int j=0;j<N;j++){
                        map[i][j] = Integer.parseInt(st.nextToken());
                    }
                }
                bfs();
                sb.append("Problem "+num+": " + answer);
                sb.append("\n");
                //탐색 시작
            }
            num++;
        }

    }
    static void bfs(){
        Queue<Point> que = new PriorityQueue<>();
        boolean[][] visited = new boolean[N][N];
        que.add(new Point(0,0,map[0][0]));
        visited[0][0] = true;

        while(!que.isEmpty()){
            Point curr = que.poll();
            if(curr.x == N-1 && curr.y == N-1)  answer = Math.min(curr.value,answer);
            for(Point p : dir){
                int nx = curr.x + p.x;
                int ny = curr.y + p.y;
                if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if(visited[nx][ny]) continue;
                visited[nx][ny] = true;
                que.add(new Point(nx,ny,curr.value + map[nx][ny]));
            }
        }

    }
}