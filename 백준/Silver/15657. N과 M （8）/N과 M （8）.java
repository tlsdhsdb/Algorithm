import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author onyoo
 * @performance
 * @category
 * @note
 * n개의 자연수 중에서 m개를 고른 수열
 * 같은 수를 여러번 골라도 된다 -> 중복 가능
 * 비내림차순 (=오름차순) -> A1 <= A2 <= Ak-1 <= Ak
 * @see
 * https://www.acmicpc.net/problem/15657
 * @since 2023-10-26
 **/
public class Main {
    static int n,m;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];

        st = new StringTokenizer(br.readLine()," ");

        for(int i=0;i<n;i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        dfs(0,new int[m]);

    }
    static void dfs(int depth,int[] a){
        if(depth == m){
            StringBuilder sb = new StringBuilder();
            for(int value : a){
                sb.append(value + " ");
            }
            System.out.println(sb);
            return;
        }
        for(int i=0;i<arr.length;i++){
            a[depth] = arr[i];
            if(depth != 0){
                if(a[depth-1] <= a[depth]) dfs(depth+1,a);
            }
            else{
                dfs(depth+1,a);
            }
            a[depth] = 0;
        }
    }
}