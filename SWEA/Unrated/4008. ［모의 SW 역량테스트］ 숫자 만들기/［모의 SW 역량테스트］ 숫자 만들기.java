import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author onyoo
 * @performance
 * @category
 * @note
 * 주어진 연산자를 이용하여 경우의 수를 만든다 -> 조합 / 중복으로 뽑을 수 있는 연산자도 있다
 * 경우의 수를 이용하여 전체 탐색을 한다 !
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWIeRZV6kBUDFAVH
 * @since 2023-10-06
 **/
public class Solution {
    static int T,N;
    static int[] operator; // 연산자의 개수를 저장하는 배열
    static int[] number; // 숫자를 저장하는 배열 
    static boolean[] visited; // 방문여부를 체크하는 배열
    static int max,min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for(int t = 1; t < T + 1; t++){
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine()," ");
            operator = new int[4];
            number = new int[N];
            max = Integer.MIN_VALUE; // 최대값을 저장하기 위한 값
            min = Integer.MAX_VALUE; // 최소값을 저장하기 위한 값
            
            for(int i=0;i<4;i++){
                operator[i] = Integer.parseInt(st.nextToken());
            }

            st =new StringTokenizer(br.readLine()," ");
            for(int i=0;i<N;i++){
                number[i] = Integer.parseInt(st.nextToken());
            }
            dfs(0,new int[N-1]); // 어떤 연산자를 몇개 선택할 것인지 빈배열에 넣을 것 
            System.out.printf("#%d %d \n",t,max - min);
        }

    }
    static void dfs(int depth,int[] arr){
        if(depth == N-1){
            //연산자개수 = 숫자 개수 - 1
            int num = number[0]; // 첫 숫자
            // 수식계산에 있어서 숫자가 먼저이기 때문에 첫번째 숫자는 따로 빼놓는다
            for(int i=0;i<number.length - 1;i++){
                int curr = number[i+1]; // 연산자 다음으로 들어갈 숫자 
                if(arr[i] == 0) num += curr;
                else if(arr[i] == 1) num -= curr;
                else if(arr[i] == 2) num *= curr;
                else if(arr[i] == 3) num /= curr;
                // 연산자의 종류에 따라서 연산을 다르게 한다 
            }
            max = Math.max(num,max);
            min = Math.min(num,min);
            // 연산한 값이 최소인가, 최대인가에 따라서 값을 넣어준다
            return;
        }

        for(int i=0;i<4;i++){
            if(operator[i] == 0) continue; // 개수가 0개가 되면 넘어간다
            arr[depth] = i; // 0번째로 사용할 연산자는 i
            --operator[i]; // 사용할 수 있는 연산자의 개수를 하나 줄여준다
            dfs(depth+1,arr);
            ++operator[i]; // 다시 되돌려 놓는다
        }
        //연산자가 4개이기 때문에,연산자별로 무엇을 선택할지 조합 구성하기

    }
}