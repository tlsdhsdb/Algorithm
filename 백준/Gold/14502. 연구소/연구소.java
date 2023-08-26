import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author 신온유
 * @performance
 * @category
 * @note
 * 연구소의 최대 크기는 8 * 8 = 64
 * 완전 탐색을 할 경우 구해야 할 벽의 위치 경우의 수는  64C3 = 41664
 * 시간제한은 2초로 초당 1억번 * 2 = 총 2억번 가능하고
 * 시간 제한을 넘지 않기 때문에 완전탐색을 사용하여 문제를 푸는 것이 적절하다고 판단함
 * 1. 벽의 위치를 고정합니다 이걸 완전탐색으로 진행합니다
 * 2. 바이러스를 퍼트리는 과정을 탐색을 통하여 진행합니다
 * @see https://www.acmicpc.net/problem/14502
 * @since 2023-08-10
 **/
public class Main {
    static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static Point[] arrow = {new Point(0,1),new Point(0,-1),new Point(1,0),new Point(-1,0)};
    //상하좌우를 저장하는 변수
    static int N,M; // 연구소의 세로,가로
    static int[][] map; // 연구소의 지도
    static int safe = Integer.MIN_VALUE; // 안전구역의 최대 크기를 저장하는 변수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int n = 0; n < N ; n ++){
            st = new StringTokenizer(br.readLine()," ");
            for(int m = 0 ; m < M ; m++){
                map[n][m] = Integer.parseInt(st.nextToken());
            }
        }
        settingWall(0);
        System.out.print(safe);
    }

    static void settingWall(int wall){
        //dfs 벽이 3개일때까지 확인을 해야하기 때문에
        if(wall == 3){
            // 벽이 세개 세워졌으면
            // 바이러스를 퍼트린다
            spreadVirus();
            return;
        }

        for(int n = 0; n < N ; n ++){
            for(int m = 0 ; m < M ; m++){
                if(map[n][m] == 0){
                    map[n][m] = 1; // 벽을 세운다
                    settingWall(wall+1);
                    map[n][m] = 0; // 벽을 원상복구한다
                }
            }
        }
    }

    static void spreadVirus(){
        // bfs 모든 정점을 탐색하며,빈 구역을 확인해야하기 때문에
        Queue<Point> que = new ArrayDeque<>();
        int safeZone = 0; // 안전구역을 저장하는 변수

        for(int n = 0; n < N ; n ++){
            for(int m = 0 ; m < M ; m++){
                if(map[n][m] == 2){
                    que.add(new Point(n,m));
                }
            }
        }
        //시작 노드,바이러스의 시작점을 큐에 넣어주기

        int copyMap[][] = new int[N][M];
        for(int n = 0; n < N; n++) copyMap[n] = map[n].clone();

        // 원본맵이 아닌 복사본에서 바이러스를 퍼트리기
        // 원본으로 다시 되돌려 놓기 어렵기 때문이다

        while(!que.isEmpty()){
            Point now = que.poll(); // 현재 지점

            for(Point ar : arrow){
                int nx = ar.x + now.x;
                int ny = ar.y + now.y;

                if(nx >= N || nx < 0 || ny >= M || ny < 0 ) continue;
                //유효하지 않은 좌표일 경우 탐색하지 않는다
                if(copyMap[nx][ny] == 0 ){
                    // 빈공간일 경우에만 바이러스를 퍼트린다
                    que.add(new Point(nx,ny));
                    copyMap[nx][ny] = 2;
                }
            }
            //현재 지점에서 4방향을 탐색함
        }
        for(int n = 0; n < N; n++){
            for(int m = 0 ; m < M; m++){
                if(copyMap[n][m] == 0) safeZone++;
            }
        }
        safe = Math.max(safeZone,safe);
    }
}