import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * @author 신온유
 * @git
 * @youtube
 * @performance
 * @category
 * @note
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWngfZVa9XwDFAQU#
 * @since 2023-09-15
 **/
public class Solution {
    static class Point{
        int x,y,dist;

        public Point(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int answer;

    static Point start,end;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int t=1;t<T+1;t++) {
            N = Integer.parseInt(br.readLine());

            map = new int[N][N];
            visited = new boolean[N][N];


            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine()," ");
                for(int j=0;j<N;j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            st = new StringTokenizer(br.readLine()," ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            start = new Point(x,y,0);

            st = new StringTokenizer(br.readLine()," ");
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            end = new Point(x,y,0);

            answer = bfs(start);
            System.out.printf("#%d %d\n",t,answer);
        }
    }

    static int bfs(Point start){
        Deque<Point> que = new ArrayDeque();
        que.add(start);
        visited[start.x][start.y] = true;

        while(!que.isEmpty()){
            int size = que.size();
            for(int i=0;i<size;i++){
                Point curr = que.poll();

                if(curr.x == end.x && curr.y == end.y) {
                    return curr.dist;
                }
                for(int j=0;j<4;j++){
                    int nx = curr.x + dx[j];
                    int ny = curr.y + dy[j];
                    int move = curr.dist + 1;

                    if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                    if(visited[nx][ny] || map[nx][ny] == 1) continue;
                    //이미 방문했거나, 장애물이 있을 경우

                    if(map[nx][ny] == 2){ //소용돌이가 있는 경우
                        if(2 == (curr.dist % 3)){
                            //이 조건을 만족하면,소용돌이가 사라진 것
                            que.offer(new Point(nx,ny,move));
                            visited[nx][ny] = true;
                        }else{
                            //소용돌이를 통과하지 못한 경우
                            //소용돌이가 사라질때까지 기다린다
                            que.offer(new Point(curr.x, curr.y,curr.dist+1));
                        }
                        continue;
                    }
                    visited[nx][ny] = true;
                    que.add(new Point(nx,ny,move));
                }
            }
        }
        return -1;
    }
}