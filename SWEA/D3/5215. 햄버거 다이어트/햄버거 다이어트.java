import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author 신온유
 * @git
 * @youtube
 * @performance
 * @category
 * @note
 * @see
 * @since 2023-08-10
 **/
public class Solution {
    static int N,L;
    static int[][] arr;
    static int ans;
    static int[] score;
    static int[] kal;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int t = 1;t <= T;t++){
            st = new StringTokenizer(br.readLine()," ");

            N = Integer.parseInt(st.nextToken()); //재료의 수
            L = Integer.parseInt(st.nextToken()); //칼로리 제한

            score = new int[N];
            kal = new int[N];

            arr = new int[N][2];

            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine()," ");
                score[i] = Integer.parseInt(st.nextToken());
                kal[i] = Integer.parseInt(st.nextToken());
            }
            ans = 0;
            hamburger(0,0,0);
            System.out.println("#"+t+" "+ans);
        }


    }
    private static void hamburger(int idx,int taste,int kcal){
        //sum taste
        //sum cal

        if(kcal > L){
            return;
        }
        if(idx == N){
            ans = Math.max(ans,taste); // 맛의 합계를 저장함
            return;
        }
        hamburger(idx + 1,taste +score[idx] ,kcal + kal[idx] );
        hamburger(idx + 1,taste,kcal);
    }

}