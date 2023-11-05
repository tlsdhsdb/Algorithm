import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author onyoo
 * @performance
 * @category
 * @note
 * 대각선 방향으로 움직이고,사각형 모양을 그리며 출발한 카페로 돌아와야 함
 * 같은 종류의 디저트를 다시 먹는 것을 싫어함 -> 같은 숫자의 디저트를 팔고있는 카페가 있으면 안됨
 * 하나의 카페에서 디저트를 먹는 것도 안됨
 * 같이 왔던 길을 되돌아 가는 것도 안됨
 * 디저트를 되도록 많이 먹으려고 한다
 * 사각형의 형태로 돌아와야한다
 * 사각형이면서 돌아와야 함
 * 1. 출발지점 = 도착지점
 * 2. 방향 전환 = 3번
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5VwAr6APYDFAWu&categoryId=AV5VwAr6APYDFAWu&categoryType=CODE&problemTitle=%EB%94%94%EC%A0%80%ED%8A%B8+%EC%B9%B4%ED%8E%98&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1&&&&&&&&&
 * @since 2023-11-02
 **/
public class Solution {
    static class Point{
        int x,y;
        int round; // 몇번을 꺾는지
        int curr; // 현재 방향
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Point(int x, int y, int round, int curr) {
            this.x = x;
            this.y = y;
            this.round = round;
            this.curr = curr;
        }
    }
    static int T,N;
    static int[][] map;
    static Point[] dir = {
        new Point(1,1), new Point(1,-1),
            new Point(-1,-1), new Point(-1,1)
    };
    //사각형을 시계방향으로 그리도록 유도함
    static int max;
    static boolean[] visited;
    static Point start;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for(int t=1;t<T+1;t++){
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            int maxIdx = 0;

            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine()," ");
                for(int j=0;j<N;j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                    maxIdx = Math.max(maxIdx,map[i][j]);
                }
            }
            max = Integer.MIN_VALUE;
            visited = new boolean[maxIdx+1];
            //디저트 가게의 번호를 visited 배열로 구성함
            //중복이 나오지 않게 하기 위함

            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    start = new Point(i,j);
                    dfs(i,j,0,0);
                }
            }
            System.out.printf("#%d %d\n",t,max == Integer.MIN_VALUE ? -1 : max);
        }
    }
    static void dfs(int x,int y,int depth,int d){
        if(x < 0 || y < 0 || x >= N || y >= N) return;
        //유효하지 않은 좌표일 경우 리턴
        if(depth > 1 && x == start.x && y == start.y){
            max = Math.max(depth,max);
            return;
        }
        for(int i=d;i<=d+1;i++){
            //무조건 다음것
            if(i> 3) break; // 사각형이 아닐 경우
            int nx = x + dir[i].x;
            int ny = y + dir[i].y;

            if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            if(visited[map[nx][ny]]) continue;
            visited[map[nx][ny]] = true;
            dfs(nx,ny,depth+1,i);
            visited[map[nx][ny]] = false;
        }
    }
}