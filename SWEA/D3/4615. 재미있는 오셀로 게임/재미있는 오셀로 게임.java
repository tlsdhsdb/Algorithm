import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author onyoo
 * @performance
 * @category
 * @note
 * @see
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWQmA4uK8ygDFAXj
 * @since 2023/11/11
 **/
public class Solution {
    static int T,N,M;
    static int[][] map;
    static int count;
    static int[] dx = {-1,0,1,1,1,0,-1,-1};
    static int[] dy = {1,1,1,0,-1,-1,-1,0};
    static int start_x;
    static int start_y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for(int t=1;t<T+1;t++){
            st = new StringTokenizer(br.readLine()," ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            //1 : 흑돌
            //2 : 백돌
            map = new int[N][N];

            map[N/2-1][N/2-1] = 2;
            map[N/2-1][N/2] = 1;
            map[N/2][N/2-1] = 1;
            map[N/2][N/2] = 2;

            for(int m=0;m<M;m++){
                st = new StringTokenizer(br.readLine()," ");
                int y = Integer.parseInt(st.nextToken()) - 1 ;
                int x = Integer.parseInt(st.nextToken()) - 1 ;
                int color = Integer.parseInt(st.nextToken());
                //돌을 놓을때마다 변화를 주어야 함
                //가로 세로 대각선 사이에 상대방의 돌이 껴있을 경우에만 내돌이 된다
                map[x][y] = color;

                count = 0;
                start_x = x;
                start_y = y;

                for(int i=0;i<8;i++){
                    dfs(x,y,map[x][y],i,0);
                }
            }
            int black = 0;
            int white = 0;

            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(map[i][j] == 1) black++;
                    else if(map[i][j] == 2)white++;
                }
            }

            System.out.printf("#%d %d %d\n",t,black,white);
        }
    }
    static void dfs(int x,int y,int color,int d,int depth) {

        int nx = x + dx[d];
        int ny = y + dy[d];

        if(nx < 0 || ny < 0 || nx >= N || ny >= N) {
            return;
        }
        if(map[nx][ny] == 0) return;
        if(map[nx][ny] == color) {
            int sx = start_x;
            int sy = start_y;
            for(int i=0;i<depth;i++){
                sx += dx[d];
                sy += dy[d];
                map[sx][sy] = color;
            }
            return;
        }

        dfs(nx,ny,color,d,depth+1);

    }

}