import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author 신온유
 * @performance
 * @category
 * @note
 * @see https://www.acmicpc.net/problem/14888
 * @since 2023-08-27
 **/
public class Main {
    static int N;
    static int[] arr;
    static int[] operator;
    // + - * /
    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        operator = new int[4];

        st = new StringTokenizer(br.readLine()," ");
        for(int n = 0; n < N; n++){
            arr[n] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine()," ");
        for(int oper = 0 ; oper < 4; oper++) {
            operator[oper] = Integer.parseInt(st.nextToken());
        }
        dfs(1,arr[0]);
        System.out.println(MAX);
        System.out.println(MIN);
    }
    public static void dfs(int depth,int num){
        if(depth == N){
            MAX = Math.max(num,MAX);
            MIN = Math.min(num,MIN);
            return;
        }
        for(int i=0;i<4;i++){
            //4개의 연산자 모두계산
            if(operator[i] > 0){
                operator[i]--; // 연산자 개수 빼기
                switch (i){
                    case 0:
                        dfs(depth+1,num + arr[depth]); break;
                    case 1:
                        dfs(depth+1,num - arr[depth]); break;
                    case 2:
                        dfs(depth+1,num * arr[depth]); break;
                    case 3:
                        dfs(depth + 1, num / arr[depth]); break;
                }
                operator[i]++; // 연산자 개수 복구
            }
        }

    }

}