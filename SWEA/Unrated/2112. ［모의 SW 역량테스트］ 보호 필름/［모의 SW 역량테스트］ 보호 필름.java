import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author onyoo
 * @performance
 * @category
 * @note
 * @see
 * @since 2023-10-12
 **/
public class Solution {
    static int T,D,W,K;
    static int[][] film;
    static boolean[] visited; //방문배열
    static int[] selected; // 어떤 약물을 어디에 주입할지 저장하는 배열
    static int min;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for(int t=1;t<T+1;t++){
            st = new StringTokenizer(br.readLine()," ");

            D = Integer.parseInt(st.nextToken()); // 필름의 두께
            W = Integer.parseInt(st.nextToken()); // 가로크기
            K = Integer.parseInt(st.nextToken()); // 합격기준

            film = new int[D][W];

            selected = new int[D];
            visited = new boolean[D];
            Arrays.fill(selected,-1); // 아무것도 주입하지 않은 상태를 -1로 둠
            //약물 주입 부분집합을 구하는데 필요함

            for(int d=0;d<D;d++){
                st = new StringTokenizer(br.readLine()," ");
                for(int w=0;w<W;w++){
                    film[d][w] =  Integer.parseInt(st.nextToken());
                }
            }

            min = Integer.MAX_VALUE; // 주입할 약물의 최소개수를 저장할 변수

            if(!check()) dfs(0,0);
            else min = 0;
            System.out.printf("#%d %d \n",t,min);
        }
    }
    static void dfs(int idx,int depth){
        // 주입할 약물의 개수
        // 약물의 위치
        if(min < idx) return;
        // 최소개수보다 많으면 그냥 볼것도 없이 리턴한다
        if(depth == D){
            // 최대 D까지 탐색
            if(check()) min = Math.min(min,idx);
            return;
        }
        // 부분집합을 구한다

        selected[depth] = -1;
        dfs(idx,depth+1);
        // 아무것도 주입하지 않는다

        selected[depth] = 0;
        dfs(idx+1,depth+1);
        // A약물을 주입한다

        selected[depth] = 1;
        dfs(idx+1,depth+1);
        // B약물을 주입한다

    }
    static boolean check(){
        int[][] copy = new int[D][W];
        for(int i=0;i<D;i++){
            int inject = selected[i];
            for(int j=0;j<W;j++){
                if(inject != -1) copy[i][j] = inject;
                else copy[i][j] = film[i][j]; // -1은 주입하지 않는 것이기 때문에 원래 필름을 가져온다
            }
        }
        // 약품을 주입하고
        int width = W; // 성공할때마다 체크 할 변수
        for(int w=0;w<W;w++){
            int ex = copy[0][w];
            int c = 1;
            for(int d=1;d<D;d++){
                int curr = copy[d][w];
                if(ex == curr) c++;
                else{
                    ex = curr; // 현재 값으로 변경해준다
                    c = 1; // 카운트 변수를 초기화 한다
                }
                if(c == K) {
                    width--;
                    break;
                }
            }
            if(width != W - (w+1)) return false;
        }
        return true;
        // 체크해준다
    }

}