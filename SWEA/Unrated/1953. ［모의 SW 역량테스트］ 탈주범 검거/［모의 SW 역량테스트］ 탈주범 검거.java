import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author onyoo
 * @performance
 * @category
 * @note
 * 탈주범이 있을 수 있는 위치의 개수
 * 시간당 1의 거리를 움직일 수 있음
 * 맨홀 뚜껑 위치로 들어갔을때, 탈주범이 갈 수 있는 장소의 개수
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PpLlKAQ4DFAUq
 * @since 2023-11-02
 **/
public class Solution {
    static class Point{
        int x,y;
        int time;

        public Point(int x, int y,int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
    static int T;
    static int N,M,R,C,L;
    static int[][] map;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    //하 상 우 좌
    //0 1 2 3
    static int[][] haveDir = {
            {},
            {0,1,2,3},
            {0,1},
            {2,3},
            {1,2},
            {0,2},
            {0,3},
            {1,3}
    };
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for(int t=1;t<T+1;t++){
            st = new StringTokenizer(br.readLine()," ");

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            visited = new boolean[N][M];
            map = new int[N][M];

            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine()," ");
                for(int j=0;j<M;j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            bfs();

            int answer = 0;

            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(visited[i][j]) answer++;
                }
            }

            System.out.printf("#%d %d\n",t,answer);
        }
    }
    static void bfs(){
        Queue<Point> que = new ArrayDeque<>();
        que.add(new Point(R,C,1)); // 시작은 1시간부터
        visited[R][C] = true; // 시작지점에 있을 수 있기 때문에 방문표시
        while(!que.isEmpty()){
            int size = que.size(); // 탈주범이 시간내에 갈 수 있는 범위를 체크해야하기 때문에 size로
            for(int i=0;i<size;i++){
                Point curr = que.poll();
                int[] dir = haveDir[map[curr.x][curr.y]]; // 위치 돌기
                //현재 탈주범이 갈 수 있는 방향의 수를 확인하기
                for(int d : dir){
                    int nx = dx[d] + curr.x;
                    int ny = dy[d] + curr.y;
                    if(nx >= N || ny >= M || nx < 0 || ny < 0) continue; // 가려는 방향이 유효한 길인지 확인하기
                    if(map[nx][ny] == 0 || visited[nx][ny]) continue; // 파이프가 없거나, 이미 방문했다면 가지 않는다

                    int[] dir_rev = haveDir[map[nx][ny]]; // 현재 도착한 곳의 파이프
                    int rev = 0; // 현재 방향의 반대 방향을 가지는 변수

                    //현재 도착한 파이프가 연결할 수 있는 방향 중 하나에 이전 파이프가 포함되는지 확인하기 위함

                    if(d % 2 == 1) rev = d-1;
                    else rev = d+1;

                    //이전 파이프의 반대방향을 구한다

                    boolean connection = false; // 연결여부를 표현하는 변수

                    for (int move : dir_rev){
                        //현재 도착한 파이프가 가지고 있는 방향 좌표 중
                        //이전 파이프의 반대방향(연결부)가 있는지 확인한다
                        if(move == rev) connection = true;
                    }


                    if(!connection) continue;
                    if(curr.time  >= L) continue;
                    visited[nx][ny] = true;
                    que.add(new Point(nx,ny, curr.time+1));
                }
            }
        }
    }


}