import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static class Point{
        int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int T;
    static int N,K;
    static int[][] map,visited;
    static int max;
    static int answer;
    static Point[] dir = {new Point(1,0),new Point(-1,0),new Point(0,1),new Point(0,-1)};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for(int t=1;t<=T;t++){
            st = new StringTokenizer(br.readLine()," ");

            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[N][N];

            max = answer = 0;

            Queue<Point> que = new ArrayDeque<>();


            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine()," ");
                for(int j=0;j<N;j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(max < map[i][j]){
                        max = map[i][j];
                        que.clear();
                        que.add(new Point(i,j));
                    }else if(max == map[i][j]){
                        que.add(new Point(i,j));
                    }
                }
            }

            while(!que.isEmpty()){
                Point top = que.poll();
                visited = new int[N][N];
                visited[top.x][top.y] = 1; // 방문표시
                dfs(1,top.x,top.y,false);// 탐색시작
            }
            System.out.printf("#%d %d\n",t,answer);
        }
    }
    static void dfs(int road,int x,int y,boolean cut){
        //길의 길이
        //좌표
        //자른지 여부 저장
        if(road > answer){
            // 현재 등산로의 길이가 최댓값보다 크다면
            answer = road;
        }
        for(Point p : dir){
            int nx = x + p.x;
            int ny = y + p.y;

            if(nx >= N || ny >= N || nx < 0 || ny < 0) continue;
            if(visited[nx][ny] == 1) continue;

            if(map[nx][ny] < map[x][y]){
                //그냥 길 생성 가능
                visited[nx][ny] = 1;
                dfs(road+1,nx,ny,cut);
                visited[nx][ny] = 0;
            }else if(map[x][y] <= map[nx][ny] && !cut){
                //길을 깎아야 지나갈 수 있음
                //길을 깎은 전적이 있다면
                int temp = map[nx][ny];
                if(map[nx][ny] - map[x][y] < K){
                    //깎을 수 있으면
                    map[nx][ny] = map[x][y] - 1;
                    //이전 경로보다 1만 작게 깎는다
                    //이래야 최대한 길게 경로를 낼 수 있기 때문이다.
                    visited[nx][ny] = 1;
                    dfs(road+1,nx,ny,true);
                    map[nx][ny] = temp; // 깎은 값을 다시 되돌려 놓는다
                    visited[nx][ny] = 0; // 되돌려 놓는다
                }
            }
        }
    }
}