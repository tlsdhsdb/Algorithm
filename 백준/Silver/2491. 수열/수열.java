import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author 신온유
 * @performance
 * @category
 * @note 수가,연속해서 커지거나 연속해서 작아지는 경우 중 가장 긴 수열을 구하시오
 * 시작지점을 잡고,끊길 경우 거기서 초기화 해준 뒤, 다시 시작한다
 * @see https://www.acmicpc.net/problem/2491
 * @since 2023-08-10
 **/
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int 길이 = Integer.parseInt(br.readLine());
        int[] 수열 = new int[길이];

        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<길이;i++){
            수열[i] = Integer.parseInt(st.nextToken());
        }

        int count = 1; // 첫번째 배열을 포함하고있기 때문
        int max = 1;
        for(int i=0;i<길이-1;i++){
            if(수열[i]<=수열[i+1]) count++;
            else count = 1;
            max = Math.max(count,max);
        }

        int count_desc = 1;
        for(int i=0;i<길이-1;i++){
            if(수열[i]>=수열[i+1]) count_desc++;
            else count_desc = 1;
            max = Math.max(count_desc,max);
        }

        System.out.println(max);

    }
}