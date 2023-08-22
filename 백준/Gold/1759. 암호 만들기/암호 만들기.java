import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * @author 신온유
 * @git
 * @youtube
 * @performance
 * @category
 * @note
 * @see https://www.acmicpc.net/problem/1759
 * @since 2023-08-22
 **/
public class Main {
    static int L,C;
    static char[] arr;
    static char print[];
    static char vowel[] = {'a','e','i','o','u'};
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine()," ");

        arr = new char[C];
        print = new char[L];

        for(int c = 0; c < C ; c++){
            arr[c] = st.nextToken().charAt(0);
        }

        Arrays.sort(arr);


        dfs(0,0);

        System.out.println(sb);

    }
    static void dfs(int depth,int start){
        if(depth == L){
            if(check()){
                for(char ch : print) sb.append(ch);
                sb.append("\n");
            }
            return;
        }
        for(int i = start ; i < arr.length; i++){
            print[depth] = arr[i];
            dfs(depth+1,i+1);
        }

    }
    static boolean check(){
        //모음 개수와 자음 개수를 체크하는 메서드
        int vow = 0; //모음
        int cons = 0; //자음

        for(char ch : print){
            boolean isVow = false;
            for(char v : vowel){
                if (ch == v) {
                    isVow = true;
                    vow++;
                }

                if(isVow) break;
            }
            if(!isVow) cons++;
        }

        if(vow >= 1 && cons >= 2) return true;
        return false;
    }
}