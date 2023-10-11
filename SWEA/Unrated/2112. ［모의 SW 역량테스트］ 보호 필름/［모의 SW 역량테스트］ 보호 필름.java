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
 * 성능검사 -> 동일한 특성의 셀들이 K(합격기준)개 이상 연속적으로 있는 경우 통과함
 * 약품투약 -> 하나의 특성으로 한줄이 변함
 * 최소 투입 횟수를 구하자
 * 1.약품을 어디에 투입할지 조합을 구한다
 * 2.성능검사를 약품을 투약할때마다 시행한다
 * @see
 * https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5V1SYKAaUDFAWu&categoryId=AV5V1SYKAaUDFAWu&categoryType=CODE&&&
 * @since 2023/10/11
 **/
public class Solution {
    static int T,D,W,K;
    static int[][] film;
    static int[] arr; // 주입할 위치를 정하는 배열
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for(int t=1;t<T+1;t++){
            st = new StringTokenizer(br.readLine()," ");

            D = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken()); // 통과기준

            film = new int[D][W];
            arr = new int[D];
            answer = Integer.MAX_VALUE; // 최소값

            for(int i=0;i<D;i++){
                st = new StringTokenizer(br.readLine()," ");
                for(int j=0;j<W;j++){
                     film[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            Arrays.fill(arr,-1);

            if(!isPass()) dfs(0,0);
            else answer = 0;
            System.out.printf("#%d %d\n",t,answer);
        }

    }
    static void dfs(int depth,int idx){
        //idx 약품 주입횟수
        //depth 약품을 넣는 위치
        if(idx >= answer) return;
        // 약품을 최솟값보다 많이 사용했다면 볼것도 없이 넘긴다.
        if(depth == D){
            if(isPass()) answer = Math.min(answer,idx);
            return;
        }
        arr[depth] = -1;
        dfs(depth+1,idx);
        //아무것도 주입하지 않음

        arr[depth] = 0;
        dfs(depth+1,idx+1);
        //0번 약물 주입

        arr[depth] = 1;
        dfs(depth+1,idx+1);
        //1번 약물 주입

    }
    static boolean isPass(){
        int[][] tmp = new int[D][W];
        // 원본값을 손대면 안된다
        // 검사만 하고 되돌려놓아야 하기때문에
        for(int i=0;i<D;i++){
            int pill = arr[i];
            //한줄씩 채워진다
            for(int j=0;j<W;j++){
                if(pill != -1) tmp[i][j] = pill; // 주입하는 경우
                else tmp[i][j] = film[i][j]; // 주입안하는 경우
            }
        }
        // 약물 주입
        int width = W;
        for(int w=0;w<W;w++){
            int ex = tmp[0][w]; // 첫 필름 저장
            int cnt = 1;
            for(int d=1;d<D;d++){
                if(ex == tmp[d][w]) cnt++;
                else {
                    cnt = 1; //ex 값이 하나 있기 때문에 1로 초기화
                    ex = tmp[d][w];
                }
                if(cnt == K) {
                    width--;
                    break;
                }
            }
            if(width != W - (w + 1)) return false;
        }
        return width == 0;
    }
}