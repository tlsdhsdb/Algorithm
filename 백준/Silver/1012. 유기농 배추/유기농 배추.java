import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * @author 신온유
 * @performance
 * @category
 * @note
 * 배추들이 인접해있는 곳을 알아내야 함
 * 배추들이 뭉쳐있는 곳을 확인해야함
 * dfs로 탐색한 횟수가 몇번인지 확인해야한다
 * @see https://www.acmicpc.net/problem/1012
 * @since 2023-08-10
 **/
public class Main {
    static int T;
    static int M,N,K;
    static int[][] map;
    static boolean visited[][];
    static Point[] arrow = {new Point(0,1),new Point(0,-1),new Point(-1,0),new Point(1,0)};

    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine()); // 테스트 케이스의 수

        for(int t = 0; t < T ; t++){
            answer = 0;
            st = new StringTokenizer(br.readLine()," ");
            M = Integer.parseInt(st.nextToken()); // 가로
            N = Integer.parseInt(st.nextToken()); // 세로
            K = Integer.parseInt(st.nextToken()); // 배추 위치의 개수

            map = new int[N][M];

            for(int k = 0; k < K; k++){
                st = new StringTokenizer(br.readLine()," ");
                int m = Integer.parseInt(st.nextToken());
                int n = Integer.parseInt(st.nextToken());

                map[n][m] = 1; // 배추있어요!
            }

            visited = new boolean[N][M];

            for(int n = 0 ; n < N ; n++){
                for(int m = 0; m < M ; m++){
                    if(map[n][m] == 1 && !visited[n][m]) dfs(new Point(n,m));
                }
            }

            System.out.println(answer);

        }


    }

    static void dfs(Point node){
        Stack<Point> stack = new Stack<>();
        //visited = new boolean[N][M];
        stack.add(node);

        while(!stack.isEmpty()){
            Point target = stack.pop();
            int nx = target.x;
            int ny = target.y;

            if(visited[nx][ny]) continue;
            else visited[nx][ny] = true;

            for(Point p : arrow){
                int tx = nx + p.x;
                int ty = ny + p.y;

                if(tx < 0 || tx >= N || ty <0 || ty >= M) continue;
                if(map[tx][ty] == 1) stack.add(new Point(tx,ty));

            }
        }
        answer++;
    }

    static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}