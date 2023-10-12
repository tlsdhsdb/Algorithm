import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author onyoo
 * @performance
 * @category
 * @note
 * R이 10000이고, 여기에서 C 500까지 가려면, 세가지 경우의 수로 500의 깊이까지 탐색하기 때문에 
 * 10000 * 3 ^ 500 이기 때문에 시간초과가 발생할 수 있다.
 * 그리디하게 생각할 것
 * 오름차순으로 시작한다 -> 오름차순으로 도착한다 
 * 경로를 재 탐색하지 않기 -> 하나의 파이프가 가지 못한 길은 다른 파이프도 연결할 수 없다
 * @see
 * https://www.acmicpc.net/problem/3109
 * @since 2023-10-12
 **/
public class Main {
    static int R,C;
    static char[][] map;
    static int[] dr = {-1,0,1};
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        count = 0;

        for(int r=0;r<R;r++){
            char[] arr = br.readLine().toCharArray();
            map[r] = arr;
        }
        for(int i=0;i<R;i++){
            dfs(i,0);
        }
        System.out.println(count);
    }
    static boolean dfs(int x,int y){
        for(int i=0;i<3;i++){
            int nx = x + dr[i];
            int ny = y + 1;
            if(nx<0 || ny<0 || nx >= R || ny >= C) continue;
            if(map[nx][ny] == '.'){ // 빈 공간에 도착했을 경우
                if(ny == C-1){ // 빵집에 도착하면
                    count++; // 가스관 하나가 연결된다
                    return true;
                }
                map[nx][ny] = '-';
                if(dfs(nx,ny)) return true;
            }
        }
        return false; // 여기까지 리턴하지 못하고 빠져나오면 연결이 불가능한 것
    }
}