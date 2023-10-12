import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
    static int T,N;
    static int[] operator; // 연산자
    static int[] number; // 사용되는 수식
    static int[] selected; // 사용될 연산자
    static int max,min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for(int t=1;t<T+1;t++){
            N = Integer.parseInt(br.readLine());

            operator = new int[4];
            number = new int[N];
            selected = new int[N-1]; // 연산자의 개수 : 숫자의 개수 - 1

            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;

            st = new StringTokenizer(br.readLine()," ");
            for(int i=0;i<4;i++){
                operator[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine()," ");
            for(int n=0;n<N;n++){
                number[n] = Integer.parseInt(st.nextToken());
            }
            dfs(0);
            System.out.printf("#%d %d\n",t,Math.abs(max-min));
        }
    }

    static void dfs(int depth){
        if(depth == N-1){
            // 연산자를 모두 선택했으면 계산을 한다
            int num = calculate();
            max = Math.max(num,max);
            min = Math.min(num,min);
            return;
        }
        for(int i=0;i<4;i++){
            if(operator[i]==0) continue; // 연산자 사용 가능 갯수가 없으면 넘어간다
            selected[depth] = i;
            operator[i]--; // 연산자의 사용 개수를 줄여준다
            dfs(depth+1);
            operator[i]++; // 연산자 되돌려놓기
        }
    }

    static int calculate(){

        int num = number[0];
        for(int i=1;i<number.length;i++){
            switch (selected[i-1]){
                case 0:
                    num += number[i];
                    break;
                case 1:
                    num -= number[i];
                    break;
                case 2:
                    num *= number[i];
                    break;
                case 3:
                    num /= number[i];
                    break;
            }
        }
        return num;
    }
}