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
 * 말의 이동 경로 -> (1,2) (2,1) (-1,-2) (-2,-1) (1,-2) (2,-1)  (-1,2) (-2,1)
 * 원숭이는 말처럼 K번만 움직일 수 있다
 * 원숭이가 왼쪽 위에서 오른쪽 아래까지 갈때,
 * 이동횟수가 최소가 되는 최솟값을 구하시오
 * BFS -> 최단경로, 다만 말의 이동경로를 곁들인
 * 3차원 visited 배열 필수 -> why ? 말처럼 이동할때, 일반적으로 이동할때를 다르게 기록하기 위해!
 * @see https://www.acmicpc.net/problem/1600
 * @since 2023-10-20
 **/
public class Main {
    static class Point{
        int x,y;
        int k; // 원숭이가 말 동작으로 이동한 횟수
        int time;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Point(int x, int y, int k, int time) {
            this.x = x;
            this.y = y;
            this.k = k;
            this.time = time;
        }
    }
    static Point[] dir = {
            new Point(1,2), new Point(2,1),
            new Point(1,-2), new Point(2,-1),
            new Point(-1,-2),new Point(-2,-1),
            new Point(-1,2),new Point(-2,1),// 말처럼 이동할 수 있는 경우의 수
            new Point(0,1),new Point(1,0),
            new Point(0,-1),new Point(-1,0)
    };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int K = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine()," ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[m][n];
        boolean[][][] visited = new boolean[m][n][K+1]; 
        // 말처럼 갔을때와 그렇지 않은 경우를 나누어서  visited
        // 한번도 말처럼 가지 않을 경우 0이기 때문에 K+1의 경우의 수를 나누어 visited 배열을 선언한다
        int answer = -1;

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<n;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Point> que = new ArrayDeque<>();
        que.add(new Point(0,0)); // 시작지점 설정
        visited[0][0][0] = true;

        while(!que.isEmpty()){
            Point curr = que.poll();
            int time = curr.time;

            if(curr.x == m-1 && curr.y == n-1) {
                answer = curr.time;
                break;
            }

            for(int j=0;j<dir.length;j++){
                Point p = dir[j];

                int nx = curr.x + p.x;
                int ny = curr.y + p.y;

                if(nx < 0 || ny < 0 || nx >= m || ny >= n) continue; //유효하지 않은 좌표
                if(map[nx][ny] == 1) continue; // 방문한 적이 있으면서 해당 좌표가 장애물일 경우 더이상 가지 않는다

                if(j < 8){
                    if(curr.k < K && !visited[nx][ny][curr.k+1]){
                        que.add(new Point(nx,ny,curr.k+1,time+1));
                        visited[nx][ny][curr.k+1] = true;
                    }else continue;
                }
                else{
                    if(!visited[nx][ny][curr.k]) {
                        que.add(new Point(nx,ny,curr.k,time+1));
                        visited[nx][ny][curr.k] = true;
                    }
                }

            }
        }

        System.out.println(answer);
    }
}