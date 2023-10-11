import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author 신온유
 * @performance
 * @category
 * @note
 * 조합 + 완전탐색 문제
 * 1. 약품을 주입 할 위치를 정한다. 약품의 개수만큼 뽑아서 약품을 주입할 위치를 가진 배열을 가져온다
 * 2. 약품을 주입한다
 * 3. 전체 값 - 3번 연속인 횟수
 * @see
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5V1SYKAaUDFAWu
 * @since 2023/10/06
 **/
public class Solution {
    static int T,D,W,K;
    static int answer;
    static int[][] film;
    static int[] arr; // 약품 주입
    static boolean[] visit; // 약품 주입 할 위치를 찾는 방문배열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for(int t=1;t<T+1;t++){
            st = new StringTokenizer(br.readLine()," ");
            D = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            film = new int[D][W];
            arr = new int[D];
            answer = Integer.MAX_VALUE;

            for(int d = 0; d < D; d++){
                st = new StringTokenizer(br.readLine()," ");
                for(int w = 0 ; w < W; w++){
                    film[d][w] = Integer.parseInt(st.nextToken());
                }
            }
            Arrays.fill(arr,-1); // 기본은 아무것도 안채움 상태

            if(!isPass()) dfs(0,0);
            else answer = 0;

            System.out.printf("#%d %d \n",t,answer);
        }

    }
    static void dfs(int depth,int idx){
        if(idx >= answer) return;
        //약품을 최소갯수보다 많이 사용하면 그냥 리턴
        //depth 는 깊이
        //idx 약품 주입 횟수
        if(depth == D){
            // 모두 주입했다 !
            if(isPass()) answer = Math.min(answer,idx);
            return;
        }
        //주입하지 않음
        arr[depth] = -1;
        dfs(depth+1,idx);
        

        //A를 주입함
        arr[depth] = 0;
        dfs(depth+1,idx+1);

        //B를 주입함
        arr[depth] = 1;
        dfs(depth+1,idx+1);

    }

    private static boolean isPass(){
        int[][] tmp = new int[D][W];
        for(int d = 0; d < D; d++){
            int pill = arr[d];
            for(int w = 0 ; w < W; w++){
                if(pill != -1) tmp[d][w] = pill;
                else{
                    tmp[d][w] = film[d][w];
                }
            }
        }
        int width  = W;
        for(int w = 0; w < W; w++){
            int cnt = 1;
            int ex = tmp[0][w]; // 비교할 이전 값
            for(int d = 1; d < D ; d++){
                if(ex == tmp[d][w]) cnt++;
                else {
                    cnt = 1;
                    ex = tmp[d][w];
                }
                if(cnt == K) {
                    width--;
                    break;
                }
            }

        }
        return width == 0;
    }
}