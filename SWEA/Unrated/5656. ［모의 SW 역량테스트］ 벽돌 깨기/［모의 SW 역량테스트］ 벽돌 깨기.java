import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author onyoo
 * @performance
 * @category
 * @note
 * 구슬은 좌우로만 이동가능하고 맨위에 있는 벽돌만 깨트릴 수 있음
 * 구슬이 명중한 벽돌은 상하좌우로 벽돌에 적힌 수 - 1 만큼 같이 제거 됨
 * @see
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXRQm6qfL0DFAUo
 * @since 2023/11/05
 **/
public class Solution {
    static class Point{
        int x,y,power;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Point(int x, int y, int power) {
            this.x = x;
            this.y = y;
            this.power = power;
        }
    }
    static int T,W,H,N;
    // W * H
    // 구슬 쏘는 횟수 N
    static int[][] map;
    static int[][] copy;
    static Point[] dir = {new Point(0,1),new Point(0,-1),new Point(1,0),new Point(-1,0)};
    static int min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for(int t=1;t<T+1;t++){
            st = new StringTokenizer(br.readLine()," ");

            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            map = new int[H][W];
            copy = new int[H][W];

            for(int i=0;i<H;i++){
                st = new StringTokenizer(br.readLine()," ");
                for(int j=0;j<W;j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                    copy[i][j] = map[i][j];
                }
            }
            min = Integer.MAX_VALUE;
            dfs(0,new int[N]);
            System.out.printf("#%d %d\n",t,min);
        }
    }

    static void dfs(int depth,int[] selected){
        if(depth == N){
            //구슬을 쏘자
            start(selected);
            min = Math.min(countMap(),min);
            copyMap();
            return;
        }

        for(int w=0;w<W;w++){
            selected[depth] = w; // 중복조합
            dfs(depth+1,selected);
        }
    }
    static void start(int[] arr){
        int x = 0;
        int y = 0;

        for(int i=0;i<N;i++){
            for(int j=0;j<H;j++){
                if(map[j][arr[i]] != 0){
                    x = j;
                    y = arr[i];
                    break;
                }
            }
            bfs(x,y);
            blockdown();
        }
    }
    static void bfs(int x,int y){
        Queue<Point> que = new ArrayDeque<>();
        que.add(new Point(x,y,map[x][y])); // 공의 파워를 기억함
        map[x][y] = 0;// 공이 부숴졌기 때문에 공의 파워를 초기화해줌

        while(!que.isEmpty()){
            Point curr = que.poll();
            int power = curr.power;
            for(int i=1;i<power;i++){
                // 파워만큼 반복
                for(Point d : dir){
                    int nx = curr.x + d.x * i;
                    int ny = curr.y + d.y * i;

                    if(nx < 0 || ny < 0 || nx >= H || ny >= W) continue;
                    if(map[nx][ny] == 0) continue;

                    que.add(new Point(nx,ny,map[nx][ny]));
                    map[nx][ny] = 0; // 터진 블록은 파워가 0이 된다
                }
            }
        }
    }

    static void blockdown(){
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<W;i++){
            for(int j=0;j<H;j++){
               if(map[j][i] != 0) stack.add(map[j][i]);
            }
            for(int j=H-1;j>=0;j--){
                if(stack.isEmpty()) map[j][i] = 0;
                else map[j][i] = stack.pop();
            }
        }
    }
    static int countMap(){
        int count = 0;
        for(int i=0;i<H;i++){
            for(int j=0;j<W;j++){
                if(map[i][j] != 0) count++;
            }
        }
        return count;
    }

    static void copyMap(){
        for(int i=0;i<H;i++){
            for(int j=0;j<W;j++){
                map[i][j] = copy[i][j];
            }
        }
    }
}