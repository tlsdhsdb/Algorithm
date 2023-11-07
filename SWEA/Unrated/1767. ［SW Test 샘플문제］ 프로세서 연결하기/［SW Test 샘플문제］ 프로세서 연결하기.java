import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * @author onyoo
 * @performance
 * @category
 * @note
 * 프로세서 연결하기
 * 가장자리 -> 이미 전원이 연결됨
 * 겹치지 않게
 * 최대한 많은 코어에 전원을 연결했을 때 전선 길이의 합을 구하자
 * 단,여러 방법이 있을 경우 전선 길이의 합이 최소가 되는 값을 구하자
 * 최단경로를 가지면서,많이 연결해야한다.
 * @see https://swexpertacademy.com/main/solvingProblem/solvingProblem.do
 * @since 2023-11-06
 **/
public class Solution {
    static class Core{
        int x,y; //코어의 위치

        public Core(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int T,N;
    static int[][] map;
    static int maxCore, minLength;
    //최대 코어 개수,최소 전깃줄 길이
    static ArrayList<Core> cores;
    static int[] dx = {0,0,0,1,-1};
    static int[] dy = {0,1,-1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for(int t=1;t<T+1;t++){

            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            maxCore = Integer.MIN_VALUE;
            minLength = Integer.MAX_VALUE;
            cores = new ArrayList<>();

            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine()," ");
                for(int j=0;j<N;j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(map[i][j] == 0) continue;
                    if(i == 0 || j == 0 || i == N-1 || j == N-1 ) continue;
                    cores.add(new Core(i,j));
                }
            }
            dfs(0,0,0);
            System.out.printf("#%d %d\n",t,minLength);
        }
    }

    static void dfs(int depth,int core,int length){
        //깊이
        //현재 몇번째 코어
        //전깃줄의 길이
        if(depth == cores.size()){
            if(core > maxCore){
                maxCore = core; // 코어의 개수가 크다면
                minLength = length;
            }else if(core == maxCore){
                if(length < minLength) {
                    minLength = length;
                }
            }
            return;
        }
        Core curr = cores.get(depth); // 현재 코어

        for(int i=1;i<=4;i++){
            //일단 4방향 중 하나의 방향으로 가보자
            int count = 0;

            int nx = curr.x;
            int ny = curr.y;
            // 이동하는 좌표

            int rx = curr.x;
            int ry = curr.y;
            // 전기줄을 잇기 위해 가지고 있는 좌표

            while(true){
                nx += dx[i];
                ny += dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= N) break;
                if(map[nx][ny] == 1) {
                    count = 0; // 더 이상 전진 할 수 없는 자리이기 때문에 counting 종료
                    break;
                }
                count++;
            }
            //얼마나 이동할 수 있는지 숫자를 센다
            //이동한 횟수가 있다면 그 만큼 전선을 채워준다
            for(int c = 0; c < count; c++){
                rx += dx[i];
                ry += dy[i];

                map[rx][ry] = 1; // 전기줄을 이어준다
            }

            if(count == 0) dfs(depth+1,core,length); // 이번 재귀에서는 이 코어는 연결하지 못할 것 같아요 !
            else{
                dfs(depth+1,core+1,length+count);

                rx = curr.x;
                ry = curr.y;

                for(int c=0;c<count;c++){
                    rx += dx[i];
                    ry += dy[i];
                    map[rx][ry] = 0;
                }
            }
        }
    }

}