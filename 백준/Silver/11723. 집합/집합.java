import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * @author 신온유
 * @performance
 * @category
 * @note
 * @see
 * @since 2023-08-10
 **/
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int 연산개수 = Integer.parseInt(br.readLine());
        int 비트 = 0; // 최대 개수가 20이므로

        while(연산개수-- >0){
            st = new StringTokenizer(br.readLine()," ");
            String 연산 = st.nextToken();
            int 숫자 = 0; // 없을 수도 있음

            if(st.hasMoreTokens()) 숫자 = Integer.parseInt(st.nextToken());

            switch (연산) {
                case "add":
                    비트 |= (1 << 숫자);
                    //값이 없으면 1, 있어도 1
                    // or 연산으로 1이 나오도록 함
                    // << 숫자만큼 밀어서 해당 위치를 찾아가도록 함
                    break;
                case "remove":
                    비트 &= ~(1 << 숫자);
                    //값이 있으면 0,없어도 0
                    //값이 있으면 -> 0
                    //값이 없으면 -> 1
                    //앞의 비트에 따라 곱연산을 결과가 결정되기 때문에 Not 연산으로 뒤에 비트를 뒤집음
                    break;
                case "check":
                    sb.append((비트 & (1<<숫자)) != 0 ? 1 : 0).append("\n");
                    // 해당 비트가 1이랑 같을 경우 1이 나오고 아닐경우 0이 나온다
                    break;
                case "toggle":
                    비트 ^= (1 << 숫자);
                    // 해당 비트열이 1일 경우 -> 0
                    // 해당 비트열이 0일 경우 -> 1
                    break;
                case "all":
                    비트 = (1 << 21) - 1;
                    //마지막 비트열까지 옮긴 다음 -1을 해줌, 0의 자리를 빼기 위함
                    break;
                case "empty":
                    비트 = 0;
                    break;

            }
        }
        System.out.println(sb);

    }

}