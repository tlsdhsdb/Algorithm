import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static void swap(int[] a,int i,int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    static boolean nextPermutation(int[] a){
        int i = a.length-1 ; // 끝에서부터 올라감
        while(i > 0 && a[i-1] >= a[i]){
            i -= 1;
        }
        //정렬되지 않은 부분을 찾아준다
        //1 2 3 4에서 우리가 찾는 부분은 4이다
        //4 부분이 정렬되지 않았기 때문이다
        if(i<=0){
            return false;
            //마지막 순열인 경우
        }
        //i가 음수가 되거나 혹은 0인경우는 마지막 순열이라는 증거
        //이미 정렬이 다 되어있기 때문에 i가 끝까지 순회하여 0이 된것이기 때문
        int j = a.length - 1;
        // a[i-1] < a[j] 를 만족하는 첫번째 수 찾기
        // i 와 swap 할 j 위치를 탐색함
        // 정렬된 쪽의 끝과 정렬되지 않은 부분에서 두번째로 중앙값보다 큰 경우의 수를
        // swap 합니다
        // 1 2 3 4 -> a[i-1] = 3 a[j] = 4 부터 시작
        // 이미 a[i-1] < a[j] 이기 때문에, a[i-1] <-> a[j]
        while (a[j] <= a[i-1]){
            j -= 1;
        }

        swap(a,i-1,j);

        j = a.length - 1;
        while(i <j ){
            swap(a,i,j);
            i += 1;
            j -= 1;
        }
        //순열 뒤집기
        return true;

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine()," ");

        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if(nextPermutation(arr)){
            for(int i=0;i<N;i++){
                System.out.print(arr[i] + " ");
            }
        }else{
            System.out.println("-1");
        }
    }


}