import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author 신온유
 * @performance
 * @category
 * @note
 * 안전영역의 최대 크기
 * @see
 * https://www.acmicpc.net/problem/14502
 * @since 2023/10/12
 **/
public class Main {
    static class Point{
        int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int N,M;
    static int[][] map;
    static Point[] dir = {new Point(0,1),new Point(0,-1),new Point(1,0),new Point(-1,0)};
    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        max = Integer.MIN_VALUE;

        for(int n=0;n<N;n++){
            st = new StringTokenizer(br.readLine()," ");
            for(int m=0;m<M;m++){
                map[n][m] = Integer.parseInt(st.nextToken());
            }
        }
        settingWall(0);
        System.out.printf("%d\n",max);
    }
    static void settingWall(int depth){
        if(depth == 3){
            // 벽을 다 세웠으면
            spreadVirus();
            return;
        }
        for (int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j] != 0) continue;
                map[i][j] = 1;
                settingWall(depth+1);
                map[i][j] = 0;
            }
        }
    }
    static void spreadVirus(){
        // 바이러스를 퍼트린다
        int[][] copy = copyMap();
        Queue<Point> que = new ArrayDeque<>();
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(copy[i][j] == 2){
                    que.add(new Point(i,j)); // 시작지점을 미리 큐에 넣어주면 된다
                }
            }
        }


        while(!que.isEmpty()){
            Point curr = que.poll();
            copy[curr.x][curr.y] = 2; // 바이러스가 퍼짐
            for(Point d : dir){
                int nx = curr.x + d.x;
                int ny = curr.y + d.y;

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(copy[nx][ny] != 0) continue;
                que.add(new Point(nx,ny));
                copy[nx][ny] = 2; // 바이러스를 퍼트린다
            }
        }
        int sum = 0;
        for(int n=0;n<N;n++){
            for(int m=0;m<M;m++){
                if(copy[n][m] == 0) sum++;
            }
        }
        max = Math.max(sum,max);
    }

    static int[][] copyMap(){
        int[][] copy = new int[N][M];
        for(int n=0;n<N;n++){
            for(int m=0;m<M;m++){
                copy[n][m] = map[n][m];
            }
        }
        return copy;
    }
}