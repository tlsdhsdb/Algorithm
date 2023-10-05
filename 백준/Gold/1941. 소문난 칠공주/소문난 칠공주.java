/*
* 소문난 칠공주
* 1. 7명의 여학생
* 2. 자리는 반드시 가로나 세로로 인접
* 3. 반드시 이다솜파 일 필요는 없다
* 4. 이다솜파 적어도 4명 이상 있어야 한다
* */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;


public class Main {
    static class Point{
        int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static final int N = 5;
    static char[][] princess = new char[N][N]; // 크기 고정
    static int[] selected = new int[7]; // 2차원 배열을 1차원 배열로 나타낸 뒤, 7명을 선택할 배열
    static boolean[] visited = new boolean[N*N];
    static Point[] arrow = {new Point(1,0),new Point(-1,0),new Point(0,1),new Point(0,-1)};
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0;i<5;i++){
            princess[i] = br.readLine().toCharArray();
        }
        dfs(0,0);
        System.out.println(answer);
    }

    static void dfs(int idx,int depth){
        if(depth == 7){
            if(validation()&&isAdj()) answer++;
            return;
        }
        for(int i=idx;i<N*N;i++){
            if(visited[i]) continue;
            visited[i] = true;
            selected[depth] = i;
            dfs(i,depth+1);
            visited[i] = false;
        }
    }

    static boolean validation(){
        int s = 0; // 이다솜파

        for(int select : selected){
            int x = select / N;
            int y = select % N;

            if(princess[x][y] == 'S') s++;
        }

        if(s < 4) return false; // 부적격
        else return true; // s  >= 4 보다 클 경우 항상 true
    }

    static boolean isAdj(){
        // 인접여부를 체크하자
        // 7명이 이어져있는지 확인하자
        boolean visitedCp[][] = new boolean[N][N];
        for(int value : selected){
            int c = value / N;
            int r = value % N;

            visitedCp[c][r] = true;
        }

        Point start = new Point(selected[0]/5,selected[0]%5 );
        int cnt  = 0;
        Queue<Point> que = new ArrayDeque<>();
        que.add(start);

        while(!que.isEmpty()){
            Point curr = que.poll();
            for(Point p : arrow){
                //4방향으로 이어져있는지 탐색하기
                int nx = curr.x + p.x;
                int ny = curr.y + p.y;

                if(0 > nx || nx >= N || 0 > ny || ny >= N) continue; // 범위 밖

                if(visitedCp[nx][ny]){
                    cnt++; // 몇명이 연결되어있는지 확인하기 위해서
                    que.add(new Point(nx,ny)); // 큐에 다음 탐색을 위한 노드 넣기
                    visitedCp[nx][ny] = false; // 방문했으면 바꿔준다
                }
            }
        }

        return cnt == 7;
    }
}