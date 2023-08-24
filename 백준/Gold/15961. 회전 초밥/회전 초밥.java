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
 * @since 2023-08-24
 **/
public class Main {
    static int N,d,k,c;
    static int[] sushi; // 벨트에 있는 초밥
    static int[] eat; //이미 먹은 초밥

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken()); // 접시 개수
        d = Integer.parseInt(st.nextToken()); // 초밥의 가짓수
        k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시의 개수 (윈도우의 크기)
        c = Integer.parseInt(st.nextToken()) - 1; // 쿠폰번호 -> 쿠폰으로 먹을 수 있는 초밥의 종류

        sushi = new int[N];
        eat = new int[d];

        for(int n = 0; n < N; n++) sushi[n] = Integer.parseInt(br.readLine()) - 1;
        // 변수 초기화 및 할당

        int count = 0 ; // 초밥의 개수
        int maxLen = 0;

        for(int i = 0 ; i < k; i++) {
            if(eat[sushi[i]]++ == 0) count++;
        }

        for(int i= 0; i < N; i++){
            if(maxLen <= count){
                if(eat[c] == 0 ) maxLen = count + 1; // 쿠폰에 있는 초밥을 먹지 않았을 경우
                else maxLen = count; // 쿠폰에 있는 초밥을 이미 먹은 경우
            } // 윈도우 크기를 넘지 않거나 같을 경우

            int end = ( i + k ) % N; // 마지막 값의 경우,배열 길이를 초과할 수 있기 때문에 mod 연산
            if(eat[sushi[end]] ++  == 0) count++; // 윈도우 맨끝 먹었을 경우 추가하기
            if(-- eat[sushi[i]] == 0) count--; // 윈도우 맨 뒤에 있는 초밥 개수 빼기
        }

        System.out.println(maxLen);
    }

}