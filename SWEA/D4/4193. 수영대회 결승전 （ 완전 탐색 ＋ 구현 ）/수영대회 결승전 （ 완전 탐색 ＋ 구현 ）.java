import java.awt.*;
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
 * 가장 빠른길 -> BFS
 * 장애물 , 소용돌이
 * 소용돌이는 2초동안 유지 1초동안 잠잠
 * 몇초만에 골인 ? -> 탐색횟수
 * @see
 * https://swexpertacademy.com/main/code/userProblem/userProblemDetail.do?contestProbId=AWKaG6_6AGQDFARV
 * @since 2023/10/11
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
    static boolean[][] visited;
    static Point start,end;
    static Point[] dir = {new Point(0,1),new Point(0,-1),new Point(1,0),new Point(-1,0)};
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
        visited = new boolean[N][N]; // 탐색할때마다 초기화
        que.add(start);
        visited[start.x][start.y] = true;

        while(!que.isEmpty()){
            int size = que.size();
            for(int i=0;i<size;i++){
                Point curr = que.poll();
                if(curr.x == end.x && curr.y == end.y) return curr.time;

                for(Point d : dir){
                    int nx = curr.x + d.x;
                    int ny = curr.y + d.y;
                    int time = curr.time + 1;

                    if(nx<0 || ny<0 || nx >= N || ny >= N) continue; // 유효하지 않은 좌표
                    if(visited[nx][ny] || map[nx][ny] == 1) continue; // 이미 가본곳 or 장애물

                    if(map[nx][ny] == 2){
                        //소용돌이를 만낫다
                        if(curr.time % 3 == 2) {
                            visited[nx][ny] = true;
                            que.add(new Point(nx,ny,time)); // 소용돌이를 탈출한다
                        }
                        else{
                            que.add(new Point(curr.x,curr.y,time));
                            //소용돌이를 탈출하지 못할경우
                        }
                        continue;
                    }
                    //소용돌이를 만나지 않았을 경우
                    visited[nx][ny] = true;
                    que.add(new Point(nx,ny,time));
                }

            }

        }
        return -1; // 빠져나가지 못하고 탐색이 끝날 경우
    }
}